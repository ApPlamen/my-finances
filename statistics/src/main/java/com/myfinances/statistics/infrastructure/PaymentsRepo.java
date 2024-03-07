package com.myfinances.statistics.infrastructure;

import com.myfinances.statistics.models.request.ChangeByDateStatisticRequest;
import com.myfinances.statistics.models.request.EarnedByMonthStatisticRequest;
import com.myfinances.statistics.models.request.SpentByMonthStatisticRequest;
import com.myfinances.statistics.models.request.SpentByPaymentOptionStatisticRequest;
import com.myfinances.statistics.models.request.SpentByVendorByPaymentOptionStatisticRequest;
import com.myfinances.statistics.models.request.SpentByVendorStatisticRequest;
import com.myfinances.statistics.models.response.KeyValuePair;
import com.myfinances.statistics.models.sql.AmountByMonthAndYearSQLResponse;
import com.myfinances.statistics.models.sql.SpentByVendorByPaymentOptionSQLResponse;
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

        Query query = createKeyValuePairNativeQuery(sql);

        query.setParameter("userId", request.getUserId());
        if (request.getStartDate() != null) {
            query.setParameter("startDate", request.getStartDate());
        }
        if (request.getEndDate() != null) {
            Date endDate = DateUtil.addDays(request.getEndDate(), 1);
            query.setParameter("endDate", endDate);
        }

        return query.getResultList();
    }

    public List<KeyValuePair> getSpentByVendor(SpentByVendorStatisticRequest request) {
        StringBuilder sql = new StringBuilder("""
                SELECT SUM(ABS(amount)) AS value, vendor AS name
                FROM payments
                WHERE user_id = :userId
                AND active = TRUE
                AND amount < 0
                """);

        if (request.getStartDate() != null) {
            sql.append("AND date_time >= :startDate").append("\n");
        }
        if (request.getEndDate() != null) {
            sql.append("AND date_time <= :endDate").append("\n");
        }

        sql.append("""
                GROUP BY vendor
                ORDER BY vendor;
                """);

        Query query = createKeyValuePairNativeQuery(sql);

        query.setParameter("userId", request.getUserId());
        if (request.getStartDate() != null) {
            query.setParameter("startDate", request.getStartDate());
        }
        if (request.getEndDate() != null) {
            Date endDate = DateUtil.addDays(request.getEndDate(), 1);
            query.setParameter("endDate", endDate);
        }

        return query.getResultList();
    }

    public List<SpentByVendorByPaymentOptionSQLResponse> getSpentByVendorByPaymentOption(SpentByVendorByPaymentOptionStatisticRequest request) {
        StringBuilder sql = new StringBuilder("""
                SELECT SUM(ABS(p.amount)) AS amount, p.vendor AS vendor, po.description AS paymentOption
                FROM payments AS p
                JOIN payment_options AS po
                	ON p.payment_option = po.id
                WHERE p.user_id = :userId
                AND p.amount < 0
                AND active = TRUE
                """);

        if (request.getStartDate() != null) {
            sql.append("AND p.date_time >= :startDate").append("\n");
        }
        if (request.getEndDate() != null) {
            sql.append("AND p.date_time <= :endDate").append("\n");
        }

        sql.append("""
                GROUP BY p.vendor, po.description
                ORDER BY p.vendor;
                """);

        Query query = entityManager.createNativeQuery(sql.toString(), "SpentByVendorByPaymentOption");

        query.setParameter("userId", request.getUserId());
        if (request.getStartDate() != null) {
            query.setParameter("startDate", request.getStartDate());
        }
        if (request.getEndDate() != null) {
            Date endDate = DateUtil.addDays(request.getEndDate(), 1);
            query.setParameter("endDate", endDate);
        }

        return query.getResultList();
    }

    public List<KeyValuePair> getSpentByPaymentOption(SpentByPaymentOptionStatisticRequest request) {
        StringBuilder sql = new StringBuilder("""
                SELECT SUM(ABS(p.amount)) AS value, po.description AS name
                FROM payments AS p
                JOIN payment_options AS po
                	ON p.payment_option = po.id
                WHERE p.user_id = :userId
                AND p.active = TRUE
                AND p.amount < 0
                """);

        if (request.getStartDate() != null) {
            sql.append("AND p.date_time >= :startDate").append("\n");
        }
        if (request.getEndDate() != null) {
            sql.append("AND p.date_time <= :endDate").append("\n");
        }

        sql.append("""
                GROUP BY po.description
                ORDER BY po.description;
                """);

        Query query = createKeyValuePairNativeQuery(sql);

        query.setParameter("userId", request.getUserId());
        if (request.getStartDate() != null) {
            query.setParameter("startDate", request.getStartDate());
        }
        if (request.getEndDate() != null) {
            Date endDate = DateUtil.addDays(request.getEndDate(), 1);
            query.setParameter("endDate", endDate);
        }

        return query.getResultList();
    }

    private Query createKeyValuePairNativeQuery(StringBuilder sql) {
        return entityManager.createNativeQuery(sql.toString(), "KeyValuePair");
    }

    public List<AmountByMonthAndYearSQLResponse> getEarnedByMonth(EarnedByMonthStatisticRequest request) {
        String sql = """
                SELECT SUM(amount) AS amount, to_char(date_time, 'MM') AS month, to_char(date_time, 'YYYY') AS year
                FROM payments
                WHERE user_id = :userId
                AND amount > 0
                AND active = TRUE
                GROUP BY month, year
                ORDER BY month, year;
                """;

        Query query = entityManager.createNativeQuery(sql, "AmountByMonthAndYearSQLResponse");

        query.setParameter("userId", request.getUserId());

        return query.getResultList();
    }

    public List<AmountByMonthAndYearSQLResponse> getSpentByMonth(SpentByMonthStatisticRequest request) {
        String sql = """
                SELECT SUM(ABS(amount)) AS amount, to_char(date_time, 'MM') AS month, to_char(date_time, 'YYYY') AS year
                FROM payments
                WHERE user_id = :userId
                AND amount < 0
                AND active = TRUE
                GROUP BY month, year
                ORDER BY month, year;
                """;

        Query query = entityManager.createNativeQuery(sql, "AmountByMonthAndYearSQLResponse");

        query.setParameter("userId", request.getUserId());

        return query.getResultList();
    }
}
