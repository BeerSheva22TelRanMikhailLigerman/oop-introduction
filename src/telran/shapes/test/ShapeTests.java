package telran.shapes.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.shapes.*;

class ShapeTests {

	@Test
	@Disabled
	void rectangleTest() {
		Rectangle rectangle = new Rectangle(10, 5);
		assertEquals(10, rectangle.getWidth());
		assertEquals(5, rectangle.getHeight());
		displayStrings(rectangle.presentation(20));
		Rectangle.setSymbol("#");
		displayStrings(rectangle.presentation(20));
	}
	
	@Test
	@Disabled
	void squareTest() {
		Square square = new Square(3);
		displayStrings(square.presentation(4));
		square.setWidht(5);
		assertEquals(5, square.getHigth());
		assertEquals(5, square.getWidth());
		square.setHeight(6);
		assertEquals(6, square.getHigth());
		assertEquals(6, square.getWidth());
		displayStrings(square.presentation(3));
	}
	
	@Test		
	@Disabled
	void SquareLeftTriangleTest() {
		SquareLeftTriangle squareLeftTriangle = new SquareLeftTriangle(8);
		displayStrings(squareLeftTriangle.presentation(10));
	}
	
	
	
	@Test
	@Disabled
	void SquareRightTriangleTest() {
		SquareRightTriangle squareRightTriangle = new SquareRightTriangle(4);
		displayStrings(squareRightTriangle.presentation(20));
	}
	
	@Test
	@Disabled
	void numberOfFigure() {
		StringOfObject stringOfObject = new StringOfObject(5, 10, "SLT.S.R.S.SLT.SRT");
		displayStrings(stringOfObject.presentation(2));
	}
	
	
	
	@Test
	void BaseChiperTest() {
		int testNumber = 123;
		BaseCipher kod = new BaseCipher(10);
		String testString = kod.cipher(testNumber);
		assertEquals(testNumber, kod.decipher(testString));
		
		BaseCipher kod2 = new BaseCipher(1);
		testString = kod2.cipher(testNumber);
		assertEquals(testNumber, kod2.decipher(testString));
		
		BaseCipher kod3 = new BaseCipher(95);
		testString = kod3.cipher(testNumber);
		assertEquals(testNumber, kod3.decipher(testString));
				
		BaseCipher kod4 = new BaseCipher(16);
		kod4.setKey("0123456789abcdef");
		testNumber = 11259375;
		testString = kod4.cipher(testNumber);
		assertEquals("abcdef", kod4.cipher(testNumber));
		assertEquals(testNumber, kod4.decipher("abcdef"));
				
		BaseCipher kod5 = new BaseCipher(2);
		kod5.setKey("01");
		testNumber = 10;
		testString = kod5.cipher(testNumber);
		assertEquals("1010", kod5.cipher(testNumber));
		assertEquals(testNumber, kod5.decipher("1010"));
	}
	
	private void displayStrings(String strings[]) {
		for(String str: strings) {
			System.out.println(str);
		}
	}

}