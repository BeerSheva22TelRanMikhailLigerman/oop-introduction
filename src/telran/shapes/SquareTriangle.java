package telran.shapes;

public class SquareTriangle extends Square {
	private boolean isLeftDiagonal;
	
	
	protected SquareTriangle(int size, boolean isLeftDiagonal) {			
		super(size);
		this.isLeftDiagonal = isLeftDiagonal;
	}
	
	
	
	public String[] presentation(int offset) {
		int size = super.getHeight();
		String res[] = new String[size];
		res[size-1] = " ".repeat(offset) +  SYMBOL.repeat(size);						
		if (isLeftDiagonal) {
			res[0] = " ".repeat(offset) + SYMBOL;
			for (int i = 1; i < res.length - 1; i++) {
				res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(i-1) + SYMBOL;
				} 
		} else {
				res[0] = " ".repeat(offset + size - 1) + SYMBOL;
				for (int i = 1; i < res.length - 1; i++) {
					res[i] = " ".repeat(offset + size - 1 - i) + SYMBOL + " ".repeat(i-1) + SYMBOL;
			}
		}
		
		
		
		return res;
	}


}
