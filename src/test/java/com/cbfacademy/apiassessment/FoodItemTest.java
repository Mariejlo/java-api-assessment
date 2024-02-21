package com.cbfacademy.apiassessment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;

import com.cbfacademy.App;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FoodItemTest {

	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate restTemplate;

	@BeforeEach
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/greeting");
	}

	@Test
	@Description("/greeting endpoint returns expected response for default name")
	public void greeting_ExpectedResponseWithDefaultName() {
		ResponseEntity<String> response = restTemplate.getForEntity(base.toString(), String.class);

		assertEquals(200, response.getStatusCode().value());
		assertEquals("Hello World", response.getBody());
	}

	@Test
	@Description("/greeting endpoint returns expected response for specified name parameter")
	public void greeting_ExpectedResponseWithNameParam() {
		ResponseEntity<String> response = restTemplate.getForEntity(base.toString() + "?name=John", String.class);

		assertEquals(200, response.getStatusCode().value());
		assertEquals("Hello John", response.getBody());
	}

	public class FoodItemTest {
		/**
		 * This class tests the functionalities of the FoodItem model,
		 * especially the calculateTotalCalories method.
		 */
		@Test
		public void testCalculateTotalCalories() {
			// Arrange
			FoodItem foodItem = new FoodItem();
			foodItem.setCarbohydrates(10);
			foodItem.setProteins(10);
			foodItem.setFats(10);
			foodItem.setSugars(10);
			System.out.println(foodItem);
			System.out.println(foodItem.calculateTotalCalories());

			// Act
			double actualCalories = foodItem.calculateTotalCalories();
			System.out.println(actualCalories);

			// Assert
			double expectedCalories = (10 * 4) + (10 * 4) + (10 * 9);
			assertEquals(expectedCalories, foodItem.calculateTotalCalories());
			// ... add more test cases...



			
		}

	}

}
