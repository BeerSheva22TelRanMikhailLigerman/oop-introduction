package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.util.MyArrays;

class MyArraysTest {

	
	@Test
	@Disabled
	void sortTest() {
		String[] strings = {"abcd", "lmn", "zz"};
		String[] expected = {"zz", "lmn", "abcd"};
		
		
		MyArrays.sort(strings, new StringLengthComparator());
		assertArrayEquals(expected, strings);
	}
	
	@Test 
	@Disabled
	void binarySearchStringTest() {
		String[] strings = { "", "1", "23", "456", "7890" };
		assertEquals(2, MyArrays.binarySearch(strings, "19", new StringLengthComparator()));
		assertEquals(0, MyArrays.binarySearch(strings, "", new StringLengthComparator()));
		assertEquals(-6, MyArrays.binarySearch(strings, "55555", new StringLengthComparator()));

		
	}
	@Test
	@Disabled
	void binarySearchIntegerTest() {
		Integer[] numbers = { 1, 2, 3, 5, 6, 7, 8, 9 };	
		assertEquals(3, MyArrays.binarySearch(numbers, 5, new IntegerComparator()));
		assertEquals(-1, MyArrays.binarySearch(numbers, 0, new IntegerComparator()));
		assertEquals(-9, MyArrays.binarySearch(numbers, 10, new IntegerComparator()));
	}
	
	@Test
	void evenOddTest() {
		Integer numbers[] = { 13, 2, -8, 47, 100, 10, 7 };
		Integer expected[] = { -8, 2, 10, 100, 47, 13, 7 };
		MyArrays.sort(numbers, new EvenOddComparator());
		assertArrayEquals(expected, numbers);
	}


}
