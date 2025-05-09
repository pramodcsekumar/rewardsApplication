package com.rewards.service;

import com.rewards.model.Customer;
import com.rewards.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service class responsible for calculating customer reward points
 * based on a list of purchase transactions.
 *
 * <p>
 * Reward Calculation Rules:
 * <ul>
 *     <li>1 point for every dollar spent over $50 up to $100</li>
 *     <li>2 points for every dollar spent over $100</li>
 * </ul>
 * </p>
 *
 * <p>
 * The rewards are aggregated per month and totaled per customer.
 * </p>
 */
@Service
public class RewardsService {

    // Sample dataset of transactions; in real application, this would come from a database
    private final List<Transaction> transactions = List.of(
            new Transaction("C1", 120, LocalDate.of(2023, 1, 15)),
            new Transaction("C1", 75, LocalDate.of(2023, 2, 10)),
            new Transaction("C1", 200, LocalDate.of(2023, 3, 5)),
            new Transaction("C2", 95, LocalDate.of(2023, 1, 25)),
            new Transaction("C2", 130, LocalDate.of(2023, 2, 14))
    );

    /**
     * Calculates reward points for each customer based on their transaction history.
     *
     * @return a map of customer IDs to {@link Customer} objects containing monthly and total reward points
     */
    public Map<String, Customer> calculateRewards() {
        Map<String, Map<String, Integer>> rewards = new HashMap<>();

        for (Transaction t : transactions) {
            String customerId = t.getCustomerId();
            String month = t.getDate().getMonth().name();
            int points = calculatePoints(t.getAmount());

            rewards
                    .computeIfAbsent(customerId, k -> new HashMap<>())
                    .merge(month, points, Integer::sum);
        }

        Map<String, Customer> result = new HashMap<>();
        for (var entry : rewards.entrySet()) {
            String customerId = entry.getKey();
            Map<String, Integer> monthPoints = entry.getValue();
            int total = monthPoints.values().stream().mapToInt(Integer::intValue).sum();
            result.put(customerId, new Customer(customerId, "Customer " + customerId, monthPoints, total));
        }

        return result;
    }

    /**
     * Calculates the reward points earned from a single transaction amount.
     *
     * @param amount the transaction amount in dollars
     * @return the total reward points earned for the given transaction
     */
    private int calculatePoints(double amount) {
        int points = 0;
        if (amount > 100) {
            points += (int) ((amount - 100) * 2);
            amount = 100;
        }
        if (amount > 50) {
            points += (int) ((amount - 50));
        }
        return points;
    }
}
