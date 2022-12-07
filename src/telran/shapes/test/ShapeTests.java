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
	
	void SquareLeftTriangleTest() {
		SquareLeftTriangle squareLeftTriangle = new SquareLeftTriangle(8);
		displayStrings(squareLeftTriangle.presentation(10));
	}
	
	
	
	@Test
	
	void SquareRightTriangleTest() {
		SquareRightTriangle squareRightTriangle = new SquareRightTriangle(4);
		displayStrings(squareRightTriangle.presentation(20));
	}
	
	
	
	
	
	private void displayStrings(String strings[]) {
		for(String str: strings) {
			System.out.println(str);
		}
	}
	
	

}