package com.rewards.unitTest;

import com.rewards.model.Customer;
import com.rewards.service.RewardsService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RewardsApplicationTests {

	@InjectMocks
	private RewardsService rewardsService;

	@Test
	void contextLoads() {
	}


	@Test
	void shouldCalculateCorrectRewardsForEachCustomer() {
		Map<String, Customer> rewards = rewardsService.calculateRewards();

		// Validate customer count
		assertThat(rewards).hasSize(2);

		// ---- C1 ----
		Customer c1 = rewards.get("C1");
		assertThat(c1).isNotNull();
		assertThat(c1.getTotalPoints()).isEqualTo(90 + 25 + 250); // Jan + Feb + Mar
		assertThat(c1.getMonthlyPoints()).containsEntry("JANUARY", 90);
		assertThat(c1.getMonthlyPoints()).containsEntry("FEBRUARY", 25);
		assertThat(c1.getMonthlyPoints()).containsEntry("MARCH", 250);

		// ---- C2 ----
		Customer c2 = rewards.get("C2");
		assertThat(c2).isNotNull();
		assertThat(c2.getTotalPoints()).isEqualTo(45 + 110); // Jan + Feb
		assertThat(c2.getMonthlyPoints()).containsEntry("JANUARY", 45);
		assertThat(c2.getMonthlyPoints()).containsEntry("FEBRUARY", 110);
	}

}
