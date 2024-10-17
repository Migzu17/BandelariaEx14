package org.acumen.training.codes.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.acumen.training.codes.ChekcStr;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestChekcStr {

	private ChekcStr checkString;

	@BeforeEach
	public void setup() {
		checkString = new ChekcStr();
		System.out.println("Dependencies set up...");
	}

	@AfterEach
	public void teardown() {
		checkString = null;
		System.out.println("Dependencies torn down.");
	}
	
	@Order(1)
	@ParameterizedTest
	@ValueSource(chars = { 'a', 'b', 'c', 'd', 'e' })
	public void testBinariseWithCharacters(char data) {
		String testStr = checkString.binarise(data);
		int testInt = Integer.parseInt(testStr);

		assertAll(() -> {
			assertEquals(testInt, 1000000);
			assertNotEquals(testInt, 1000000);
			assertTrue(testStr.equals("1001010"));
			assertFalse(testStr.equals("1001010"));
		});
	}

	@Order(2)
	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 })
	public void testBinariseWithIntegers(int data) {
		String testStr = checkString.binarise(data);
		int testInt = Integer.parseInt(testStr);

		assertAll(() -> {
			assertEquals(testInt, 1);
			assertNotEquals(testInt, 10);
			assertTrue(testStr.equals("1"));
			assertFalse(testStr.equals("10"));
		});
	}

	// Exception Testing
	@Order(3)
	@ParameterizedTest
	@MethodSource("emptyOrNullString")
	public void testConvertWithEmptyOrNullStringParam(String data) {
		assertDoesNotThrow(() -> {
			String testStr = checkString.convert(data);
			int testInt = Integer.parseInt(testStr);
			assertAll(() -> {
				assertEquals(testInt, 1);
				assertNotEquals(testInt, 10);
				assertTrue(testStr.equals("1"));
				assertFalse(testStr.equals("10"));
			});
		}, "Exception unhandled.");
	}
	
	private static Stream<String> emptyOrNullString() {
		return Stream.of("", null);
	}
	
	// Exception Testing
	@Order(4)
	@ParameterizedTest
	@ValueSource(strings = "\n10001111\n")
	public void testConvertWithWhitespacesOnParam(String data) {
		assertDoesNotThrow(() -> {
			String testStr = checkString.convert(data);
			int testInt = Integer.parseInt(testStr);
			assertAll(() -> {
				assertEquals(testInt, 1);
				assertNotEquals(testInt, 10);
				assertTrue(testStr.equals("1"));
				assertFalse(testStr.equals("10"));
			});
		}, "Exception unhandled.");
	}
	
	// Exception Testing
	@Order(5)
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"})
	public void testConvertWithIntegersAsStringsParam(String data) {
		assertDoesNotThrow(() -> {
			String testStr = checkString.convert(data);
			int testInt = Integer.parseInt(testStr);
			assertAll(() -> {
				assertEquals(testInt, 1);
				assertNotEquals(testInt, 10);
				assertTrue(testStr.equals("1"));
				assertFalse(testStr.equals("10"));
			});
		}, "Exception unhandled.");
	}
	
	@Order(6)
	@ParameterizedTest
	@MethodSource("emptyOrNullString")
	public void testTotalWithEmptyOrNullStringParam(String data) {
		assertDoesNotThrow(() -> {
			int test = checkString.total(data);
			assertAll(() -> {
				assertEquals(test, 1);
				assertNotEquals(test, 10);
				assertTrue(test > 1);
				assertFalse(test > 10);
			});
		}, "Exception unhandled.");
	}
	
	// Exception Testing
	@Order(7)
	@ParameterizedTest
	@ValueSource(strings = "\n10001111\n")
	public void testTotalWithWhitespacesOnParam(String data) {
		assertDoesNotThrow(() -> {
			int test = checkString.total(data);
			assertAll(() -> {
				assertEquals(test, 1);
				assertNotEquals(test, 10);
				assertTrue(test > 1);
				assertFalse(test > 10);
			});
		}, "Exception unhandled.");
	}
	
	// Exception Testing
	@Order(8)
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"})
	public void testTotalWithIntegersAsStringsParam(String data) {
		assertDoesNotThrow(() -> {
			int test = checkString.total(data);
			assertAll(() -> {
				assertEquals(test, 1);
				assertNotEquals(test, 10);
				assertTrue(test > 1);
				assertFalse(test > 10);
			});
		}, "Exception unhandled.");
	}

}
