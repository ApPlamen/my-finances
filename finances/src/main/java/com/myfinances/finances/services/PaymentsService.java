package com.myfinances.finances.services;

import com.myfinances.finances.dtos.inputs.CreateEditPaymentInputDTO;
import com.myfinances.finances.dtos.inputs.PaymentActiveInputDTO;
import com.myfinances.finances.dtos.inputs.PaymentInputDTO;
import com.myfinances.finances.dtos.inputs.PaymentUpdateDTO;
import com.myfinances.finances.dtos.request.BoardPaymentsRequest;
import com.myfinances.finances.dtos.views.PaymentBoardItemViewDTO;
import com.myfinances.finances.dtos.views.PaymentEditViewDTO;
import com.myfinances.finances.dtos.views.PaymentViewDTO;
import com.myfinances.finances.entities.Payment;
import com.myfinances.finances.entities.PaymentCategory;
import com.myfinances.finances.entities.PaymentOption;
import com.myfinances.finances.infrastructure.PaymentRepo;
import com.myfinances.finances.specifications.PaymentsSpecifications;
import io.micrometer.common.util.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentsService extends CRUDService<Payment, Integer, PaymentInputDTO, PaymentUpdateDTO, PaymentViewDTO> {
    private final PaymentRepo repo;
    private final PaymentOptionsService paymentOptionsService;
    private final PaymentCategoriesService paymentCategoriesService;

    public PaymentsService(PaymentRepo repo,
                           PaymentOptionsService paymentOptionsService,
                           PaymentCategoriesService paymentCategoriesService) {
        super(repo);
        this.repo = repo;
        this.paymentOptionsService = paymentOptionsService;
        this.paymentCategoriesService = paymentCategoriesService;
    }

    public List<PaymentBoardItemViewDTO> getBoard(BoardPaymentsRequest request) {
        Specification<Payment> spec = Specification.where(PaymentsSpecifications.userId(request.getUserId()));

        if (!StringUtils.isBlank(request.getDescription())) {
            spec = spec.and(PaymentsSpecifications.descriptionLike(request.getDescription()));
        }
        if (!StringUtils.isBlank(request.getVendor())) {
            spec = spec.and(PaymentsSpecifications.vendorLike(request.getVendor()));
        }
        if (request.getStartDate() != null) {
            spec = spec.and(PaymentsSpecifications.dateTimeIsGreaterThanOrEqualTo(request.getStartDate()));
        }
        if (request.getEndDate() != null) {
            spec = spec.and(PaymentsSpecifications.dateTimeIsLessThanOrEqualTo(request.getEndDate()));
        }

        return this.repo.findAll(spec).stream()
                .map(PaymentBoardItemViewDTO::create)
                .collect(Collectors.toList());
    }

    public PaymentEditViewDTO getEditPayment(int paymentId) {
        return this.repo.findById(paymentId)
                .map(PaymentEditViewDTO::create)
                .orElseThrow();
    }

    public void createEditPayment(CreateEditPaymentInputDTO request) {
        Payment payment = request.getId().isPresent()
                ? this.repo.findById(request.getId().get()).orElse(createNewPayment())
                : createNewPayment();

        Payment entity = request.toEntity(payment);

        PaymentOption paymentOption = paymentOptionsService.findById(request.getPaymentOption());
        entity.setPaymentOption(paymentOption);

        PaymentCategory paymentCategory = paymentCategoriesService.findById(request.getPaymentCategory());
        entity.setPaymentCategory(paymentCategory);

        this.repo.save(entity);
    }

    public void setActive(PaymentActiveInputDTO request) {
        Payment payment = this.repo.findById(request.getPaymentId()).orElseThrow();

        payment.setActive(request.isActive());

        this.repo.save(payment);
    }

    @Override
    protected PaymentViewDTO toView(Payment payment) {
        return PaymentViewDTO.builder()
                .id(payment.getId())
                .description(payment.getDescription())
                .amount(payment.getAmount())
                .build();
    }

    private Payment createNewPayment() {
        Payment newPayment = new Payment();
        newPayment.setActive(true);
        return newPayment;
    }
}
