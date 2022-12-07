package telran.shapes;

public class SquareTriangle extends Square {
	private boolean isLeftDiagonal;
	
	
	protected SquareTriangle(int size, boolean isLeftDiagonal) {			
		super(size);
		this.isLeftDiagonal = isLeftDiagonal;
	}
	
	public String[] presentation(int offset) {
		return isLeftDiagonal ? bildSLT(offset) : bildSRT(offset);
	}

	private String[] bildSRT(int offset) {
		int size = super.getHeight();
		String res[] = new String[size];
		res[0] = getOffset(offset + size - 1) + SYMBOL;
		for (int i = 1; i < res.length - 1; i++) {
			res[i] = middleLineSRT(offset, i, size);
		}
		res[size-1] = getLine(offset);
		return res;
	}


	private String[] bildSLT(int offset) {
		int size = super.getHeight();
		String res[] = new String[size];
		res[0] = getOffset(offset) + SYMBOL + getOffset(size - 1);
		for (int i = 1; i < res.length - 1; i++) {
			res[i] = middleLineSLT(offset, i, size);
		}
		res[size-1] = getLine(offset);
		return res;
	}



	private String middleLineSRT(int offset, int i, int size) {
		String res = " ".repeat(offset + size - 1 - i) + SYMBOL + " ".repeat(i-1) + SYMBOL;
		return res;
	}



	private String middleLineSLT(int offset, int i, int size) {
		String res = getOffset(offset) + SYMBOL + " ".repeat(i-1) + SYMBOL + getOffset(size-i-1);
		return res;
	}


}
