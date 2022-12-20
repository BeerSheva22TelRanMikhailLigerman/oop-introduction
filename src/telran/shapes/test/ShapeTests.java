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
		square.setWidth(5);
		assertEquals(5, square.getWidth());
		square.setHeight(6);
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
	@Disabled
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
	
	@Test
	@Disabled
	void testCanvas() {
		Canvas canvas1 = new Canvas(4, 5, new Shape[] {new SquareRightTriangle(3), new Square(2), new SquareLeftTriangle(8)});
		Canvas canvas2 = new Canvas(5, 4, new Shape[] {new Rectangle(3, 7), canvas1, new Rectangle(4,3)});
		canvas1.setDirection("raw");
		canvas2.setDirection("column");
		canvas1.setMargin(1);
		canvas2.setMargin(1);
		displayStrings(canvas2.presentation(1));
	}
	
	Canvas canvas = new Canvas(10, 20,
			new Shape[] { new Rectangle(10, 3), new Square(10), new SquareLeftTriangle(10) });
	Shape[] shapes = { new Rectangle(10, 3), new Square(10), new SquareLeftTriangle(10), new SquareRightTriangle(10),
			canvas, new Square(10) };
	
	@Test
	
	void canvasInRowTest() {
		Canvas canvas = new Canvas(10, 4, shapes);
		canvas.setMargin(3);
		displayStrings(canvas.presentation(2));
	}

	@Test
	
	void canvasInColumnTest() {
		Canvas canvas = new Canvas(10, 4, shapes);
		canvas.setDirection("column");
		this.canvas.setDirection("column");
		canvas.setMargin(1);
		displayStrings(canvas.presentation(2));

	}
	private void displayStrings(String strings[]) {
		for(String str: strings) {
			System.out.println(str);
		} 
	}

}