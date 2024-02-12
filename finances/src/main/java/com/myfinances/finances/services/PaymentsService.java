package com.myfinances.finances.services;

import com.myfinances.finances.dtos.inputs.CreateEditPaymentInputDTO;
import com.myfinances.finances.dtos.inputs.PaymentActiveInputDTO;
import com.myfinances.finances.dtos.inputs.PaymentInputDTO;
import com.myfinances.finances.dtos.inputs.PaymentUpdateDTO;
import com.myfinances.finances.dtos.views.PaymentBoardItemViewDTO;
import com.myfinances.finances.dtos.views.PaymentEditViewDTO;
import com.myfinances.finances.dtos.views.PaymentViewDTO;
import com.myfinances.finances.entities.Payment;
import com.myfinances.finances.entities.PaymentOption;
import com.myfinances.finances.infrastructure.PaymentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentsService extends CRUDService<Payment, Integer, PaymentInputDTO, PaymentUpdateDTO, PaymentViewDTO> {
    private final PaymentRepo repo;
    private final PaymentOptionsService paymentOptionsService;

    public PaymentsService(PaymentRepo repo, PaymentOptionsService paymentOptionsService) {
        super(repo);
        this.repo = repo;
        this.paymentOptionsService = paymentOptionsService;
    }

    public List<PaymentBoardItemViewDTO> getBoard(int userId) {
        return this.repo.findAllByUserIdOrderByIdAsc(userId).stream()
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
