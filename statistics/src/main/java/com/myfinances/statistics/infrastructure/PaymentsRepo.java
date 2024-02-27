package com.myfinances.statistics.infrastructure;

import com.myfinances.statistics.models.response.KeyValuePair;
import com.myfinances.statistics.models.request.ChangeByDateStatisticRequest;
import com.myfinances.statistics.utils.DateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class PaymentsRepo {
    @PersistenceContext
    private EntityManager entityManager;

    public List<KeyValuePair> getChangeByDate(ChangeByDateStatisticRequest request) {
        StringBuilder sql = new StringBuilder("""
                SELECT sum AS value, to_char(date, 'DD.MM.YYYY') AS name
                FROM (
                    SELECT SUM(amount) AS sum, cast(date_time AS date) AS date
                    FROM payments
                    WHERE user_id = :userId
                    AND active = TRUE
                """);

        if (request.getStartDate() != null) {
            sql.append("AND date_time >= :startDate").append("\n");
        }
        if (request.getEndDate() != null) {
            sql.append("AND date_time <= :endDate").append("\n");
        }

        sql.append("""
                    GROUP BY date
                    ORDER BY date);
                """);

        Query query = entityManager.createNativeQuery(sql.toString(), "ChangeByDateStatisticResult");

        query.setParameter("userId", request.getUserId());
        if (request.getStartDate() != null) {
            query.setParameter("startDate", request.getStartDate());
        }
        if (request.getEndDate() != null) {
            Date endDate = DateUtil.addDays(request.getEndDate(),1);
            query.setParameter("endDate", endDate);
        }

        return query.getResultList();
    }
}
