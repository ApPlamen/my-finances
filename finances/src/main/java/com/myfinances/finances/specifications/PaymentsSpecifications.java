package com.myfinances.finances.specifications;

import com.myfinances.finances.entities.Payment;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class PaymentsSpecifications {
    public static Specification<Payment> userId(int userId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("userId"), userId);
    }

    public static Specification<Payment> descriptionLike(String description) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("description"), description);
    }

    public static Specification<Payment> vendorLike(String vendor) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("vendor"), vendor);
    }

    public static Specification<Payment> dateTimeIsGreaterThanOrEqualTo(Date dateTime) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("dateTime"), dateTime);
    }

    public static Specification<Payment> dateTimeIsLessThanOrEqualTo(Date dateTime) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("dateTime"), dateTime);
    }
}
