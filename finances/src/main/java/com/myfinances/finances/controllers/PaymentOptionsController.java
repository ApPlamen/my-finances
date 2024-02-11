package com.myfinances.finances.controllers;

import com.myfinances.finances.dtos.views.PaymentOptionViewDTO;
import com.myfinances.finances.services.PaymentOptionsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/payment-options")
public class PaymentOptionsController {
    private PaymentOptionsService service;

    @GetMapping("options")
    public ResponseEntity<List<PaymentOptionViewDTO>> getRolesOptions() {
        List<PaymentOptionViewDTO> options = service.getPaymentOptions();
        return ResponseEntity.ok(options);
    }
}
