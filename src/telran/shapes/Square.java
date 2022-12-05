package telran.shapes;

public class Square extends Rectangle {

	public Square(int width) {
		super(width, width);
	}
	
public void setWidht(int width) {
	setSize(width);
}

public void setHeight(int width) {
	setSize(width);
}

private void setSize(int size) {
	super.setWidth(size);
	super.setHeight(size);
}

public int getWidth() {
	return super.getWidth();
}

public int getHigth() {
	return super.getWidth();
}
	
public String[] presentation(int offset) {
		
	return super.presentation(offset);
}



}
