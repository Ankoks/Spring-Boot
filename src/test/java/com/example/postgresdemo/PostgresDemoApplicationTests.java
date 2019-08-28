package com.example.postgresdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostgresDemoApplicationTests {

	public static void main(String[] args) {

		System.out.println(new BigDecimal("6.24").divide(new BigDecimal("100"), RoundingMode.CEILING));
		System.out.println(new BigDecimal("3.24").divide(new BigDecimal("100"), RoundingMode.HALF_UP));
		System.out.println(new BigDecimal("3.74").divide(new BigDecimal("100"), RoundingMode.HALF_UP));
		System.out.println(new BigDecimal("33.5").divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP));
		System.out.println(new BigDecimal("33.4").divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP));

		//0.335
	}

	@Test
	public void contextLoads() {
	}

}
