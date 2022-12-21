package telran.shapes;

import java.util.Arrays;

public class Canvas extends Shape {
	private Shape[] shapes;
	
	private static final String ROW = "row";
	private static final String COLUMN = "column";
	private String direction = ROW;
	private int margin = 5;
	
	public Canvas(int width, int height, Shape[] shapes) {
		super(width, height);
		this.shapes = shapes;
	}

	@Override
	public String[] presentation(int offset) {
		return direction.equals("row") ? presentationInRow(offset) : presentationInColumn(offset);
	}
	
	private String[] presentationInColumn(int offset) {
			String res[] = new String[heightsSum() + (shapes.length - 1) * margin];
			Arrays.fill(res, " ".repeat(getWidth()));
			int length = mergeLines(0, res, getFigure(shapes[0], offset));
			for(int i = 1; i < shapes.length; i++) {
				length = mergeLines(length + margin, res, getFigure(shapes[i], offset));
			}
		return res;
	}
	
	private int mergeLines(int position, String[] res, String[] figerForAdd) {
		System.arraycopy(figerForAdd, 0, res, position, figerForAdd.length);
		return position + figerForAdd.length;
	}
	
	private int heightsSum() {
		int sum = 0;
		for(Shape shape: shapes) {
			if (shape instanceof Square) {
				shape.setHeight(getWidth());
			}
			sum += shape.getHeight();
		}
		return sum;
	}

	private String[] presentationInRow(int offset) {
		String[] res = getFigure(shapes[0], offset);
		for(int i = 1; i < shapes.length; i++) {
			res = addFigureInRow(res, getFigure(shapes[i], margin), 0);
		}
		return res;
	}

	private String[] addFigureInRow(String[] masterArray, String[] figureForAdd, int offset) {
		for (int i = 0; i < masterArray.length; i++) {
			masterArray[i] = masterArray[i] + " ".repeat(offset) + figureForAdd[i];
		}
		return masterArray;
	}

	private String[] getFigure(Shape shape, int offset) {
		String[] res;
		if (directionRow()) {
			shape.setHeight(getHeight());
			res = shape.presentation(offset);
		} else {
			shape.setWidth(getWidth());
			res = shape.presentation(offset);	//add offset
		}
		return res;
	}
		
	private boolean directionRow() {
		return direction.equals(ROW);
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		if (direction.equalsIgnoreCase(ROW) || direction.equalsIgnoreCase(COLUMN)) {
			this.direction = direction;
		}
	}

	public int getMargin() {
		return margin;
	}

	public void setMargin(int margin) {
		this.margin = margin > 0 ? margin : 0;
	}
	
	@Override
	public int getHeight() {
		return direction.equals("row") ? super.getHeight() : (heightsSum() + margin * (shapes.length - 1));
	}
	

}
