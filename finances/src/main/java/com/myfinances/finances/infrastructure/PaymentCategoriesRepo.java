package com.myfinances.finances.infrastructure;

import com.myfinances.finances.entities.PaymentCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentCategoriesRepo extends Repo<PaymentCategory, Integer> {
}
