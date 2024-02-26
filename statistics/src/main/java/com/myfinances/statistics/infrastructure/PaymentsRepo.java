package com.myfinances.statistics.infrastructure;

import com.myfinances.statistics.models.Payment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentsRepo {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Payment> getPayments() {
        String sql = """
                SELECT id, amount, description, payment_option, active, user_id, vendor, date_time
                FROM payments""";

        Query query = entityManager.createNativeQuery(sql);
        var result = query.getResultList();

        return result;
    }
}
