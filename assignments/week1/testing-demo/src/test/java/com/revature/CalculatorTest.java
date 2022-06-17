package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.exceptions.DivideBy0Exception;
import com.revature.exceptions.Number13Exception;

public class CalculatorTest {

	private static Calculator sut;
	
	/*
	 * JUnit 5
	 * 	- @BeforeAll
	 *  - @BeforeEach
	 *  - @AfterAll
	 *  - @AfterEach
	 *  
	 *  - @Test
	 *  - @Ignore
	 *  - @Order
	 */
	
	// Used to set up the test
	@BeforeAll
	public static void setUp() {
		sut = new Calculator();
	}
	
	@AfterAll
	public static void tearDown() {
		System.out.println("Tear down behavior.");
	}
	
	@BeforeEach
	public void before() {
		System.out.println("@Before each behavior");
	}
	
	@Test
	public void addOneAndTwo() {
		int expected = 3;
		int actual = sut.add(1, 2);
		
		assertEquals(expected, actual);
	}
 
	@Test
	public void addEightAndFive() {
		assertThrows(Number13Exception.class, () -> sut.add(8, 5));
	}
	
	@Test
	public void addZeroAndThirteen() {
		assertThrows(Number13Exception.class, () -> sut.add(0, 13));
	}
	
	@Test
	public void minusOneAndTwo() {
		int expected = 2;
		int actual = sut.subtract(5, 3);
		
		assertEquals(expected, actual);
	}	
	
 
	
	@Test
	public void sumArray() {
		int expected = 140;
        int[] Intarr = {5,10,15,20,25,30,35};
		int actual = sut.sumOfAnArray(Intarr);
		   
		assertEquals(expected, actual);
	}	
		
	
	@Test
	public void sumArrayZero() {
        int[] Intarr = {0,0,0,0,0,0,0};
		   
		assertThrows(DivideBy0Exception.class, () -> sut.sumOfAnArray(Intarr));
	}	
			
	
}
