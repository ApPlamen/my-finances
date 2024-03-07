package com.myfinances.finances.controllers;

import com.myfinances.finances.dtos.views.PaymentCategoryViewDTO;
import com.myfinances.finances.services.PaymentCategoriesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/payment-categories")
public class PaymentCategoriesController {
    private PaymentCategoriesService service;

    @GetMapping("options")
    public ResponseEntity<List<PaymentCategoryViewDTO>> getPaymentCategoriesOptions() {
        List<PaymentCategoryViewDTO> options = service.getPaymentCategoriesOptions();
        return ResponseEntity.ok(options);
    }
}
