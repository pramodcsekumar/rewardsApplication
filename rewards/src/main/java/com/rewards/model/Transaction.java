package com.rewards.model;
import lombok.*;
import java.time.LocalDate;

/**
 * Represents a customer transaction.
 */
@Data
@NoArgsConstructor
@Getter
public class Transaction {

    private String customerId;
    private double amount;
    private LocalDate date;

    /**
     * Constructs a validated transaction.
     * @param customerId the ID of the customer
     * @param amount the transaction amount
     * @param date the transaction date
     */
    public Transaction(String customerId, double amount, LocalDate date) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (customerId == null || customerId.isBlank()) throw new IllegalArgumentException("Customer ID is required");
        if (date == null) throw new IllegalArgumentException("Transaction date is required");

        this.customerId = customerId;
        this.amount = amount;
        this.date = date;
    }


    public String getCustomerId() {
        return customerId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}


