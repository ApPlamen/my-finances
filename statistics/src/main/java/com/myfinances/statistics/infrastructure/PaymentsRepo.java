package com.myfinances.statistics.infrastructure;

import com.myfinances.statistics.models.KeyValuePair;
import com.myfinances.statistics.models.request.ChangeByDateStatisticRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentsRepo {
    @PersistenceContext
    private EntityManager entityManager;

    public List<KeyValuePair> getChangeByDate(ChangeByDateStatisticRequest request) {
        String sql = """
                SELECT sum AS value, to_char(date, 'DD.MM.YYYY') AS name
                FROM (
                    SELECT SUM(amount) AS sum, cast(date_time AS date) AS date
                    FROM payments
                    WHERE user_id = :userId
                    GROUP BY date
                    ORDER BY date);""";

        Query query = entityManager.createNativeQuery(sql, "ChangeByDateStatisticResult");
        query.setParameter("userId", request.getUserId());
        var result = query.getResultList();

        return result;
    }
}
