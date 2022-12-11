package telran.shapes;

/*
 * get string:
 * R - rectangle
 * S - square rectangle
 * SLT - square left triangle
 * SRT - square right triangle
 */

public class StringOfObject extends Rectangle {
	private String matrixString;

	public StringOfObject(int width, int height, String string) {
		super(width, height);
		this.matrixString = string;	
		
	}
	
	public String[] presentation(int offset) {
		int size = super.getHeight();
		String[] matrixArray = getMatrixArray(matrixString);
		String[] masterArray = new String[size];
		masterArray = getObject(offset, matrixArray[0]);
		for (int i = 1; i < matrixArray.length; i++) {
			addArray(masterArray, getObject(offset, matrixArray[i]));
 		}
		
		return masterArray;
	}

	private String[] addArray(String[] masterArray, String[] arrayToAdd) {
		for (int i = 0; i < masterArray.length; i++) {
			masterArray[i] = masterArray[i] + arrayToAdd[i];
		}
		return masterArray;
		
	}

	private String[] getObject(int offset, String figure) {
		int size = super.getHeight();
		int width = super.getWidth();
		String newFigure[] = new String[size];
		switch(figure) {
		case "S": Square square = new Square(size);
				newFigure = square.presentation(offset); break;
		case "SLT": SquareLeftTriangle slt = new SquareLeftTriangle(size);
				newFigure = slt.presentation(offset); break;
		case "SRT": SquareRightTriangle srt = new SquareRightTriangle(size);
				newFigure = srt.presentation(offset); break;
		case "R": Rectangle rectangle = new Rectangle(width, size);
				newFigure = rectangle.presentation(offset); break;
		}
		return newFigure;
		
	}

	private String[] getMatrixArray(String matrixString) {
		String[] res = matrixString.split(delimetr());
		return res;
	}

	private String delimetr() {
		return  "(\\.)";
	}
	
	
 }
