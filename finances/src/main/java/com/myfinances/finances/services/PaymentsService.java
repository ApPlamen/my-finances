package com.myfinances.finances.services;

import com.myfinances.finances.dtos.inputs.CreateEditPaymentInputDTO;
import com.myfinances.finances.dtos.inputs.PaymentInputDTO;
import com.myfinances.finances.dtos.inputs.PaymentUpdateDTO;
import com.myfinances.finances.dtos.views.PaymentBoardItemViewDTO;
import com.myfinances.finances.dtos.views.PaymentEditViewDTO;
import com.myfinances.finances.dtos.views.PaymentViewDTO;
import com.myfinances.finances.entities.Payment;
import com.myfinances.finances.infrastructure.PaymentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentsService extends CRUDService<Payment, Integer, PaymentInputDTO, PaymentUpdateDTO, PaymentViewDTO> {
    private final PaymentRepo repo;

    public PaymentsService(PaymentRepo repo) {
        super(repo);
        this.repo = repo;
    }

    public List<PaymentBoardItemViewDTO> getBoard() {
        return this.repo.findAllByOrderByIdAsc().stream()
                .map(PaymentBoardItemViewDTO::create)
                .collect(Collectors.toList());
    }

    public PaymentEditViewDTO getEditPayment(int paymentId) {
        return this.repo.findById(paymentId)
                .map(PaymentEditViewDTO::create)
                .orElseThrow();
    }

    public void createEditPayment(CreateEditPaymentInputDTO request) {
        Payment payment = request.getId().isPresent() ? this.repo.findById(request.getId().get()).orElse(new Payment()) : new Payment();
        Payment entity = request.toEntity(payment);

        this.repo.save(entity);
    }

    @Override
    protected PaymentViewDTO toView(Payment payment) {
        return PaymentViewDTO.builder()
                .id(payment.getId())
                .description(payment.getDescription())
                .amount(payment.getAmount())
                .build();
    }
}
