package com.rewards.model;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyReward {
    private String month;
    private int points;
}

