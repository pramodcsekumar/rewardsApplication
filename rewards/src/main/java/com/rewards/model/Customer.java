package com.rewards.model;

import java.util.Map;
import java.util.Objects;

/**
 * Represents a customer and their reward summary.
 */

// Lombok is not working for this class

public class Customer {

    private String id;
    private String name;
    private Map<String, Integer> monthlyPoints;
    private int totalPoints;

    public Customer(){

    }


    public Customer(String id, String name, Map<String, Integer> monthlyPoints, int totalPoints) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Customer ID is required");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Customer name is required");
        this.id = id;
        this.name = name;
        this.monthlyPoints = monthlyPoints;
        this.totalPoints = totalPoints;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getMonthlyPoints() {
        return monthlyPoints;
    }

    public void setMonthlyPoints(Map<String, Integer> monthlyPoints) {
        this.monthlyPoints = monthlyPoints;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getTotalPoints() == customer.getTotalPoints() && getId().equals(customer.getId()) && getName().equals(customer.getName()) && getMonthlyPoints().equals(customer.getMonthlyPoints());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getMonthlyPoints(), getTotalPoints());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", monthlyPoints=" + monthlyPoints +
                ", totalPoints=" + totalPoints +
                '}';
    }
}


