package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void simpleAdd_1() {
		int expected = 5;
		int actual = 3+2;
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void simpleAdd_2() {
		int expected = 5;
		int actual = 3+2+1;
		Assertions.assertNotEquals(expected, actual);
	}

}