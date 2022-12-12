package telran.shapes;

public class BaseCipher {
	int keyLenght;
	String key;
	
	public BaseCipher (int keyLenght) {
		this.keyLenght = checkKeyLenght(keyLenght);
		this.key = getKey(this.keyLenght);
		}
	
	
	
	private int checkKeyLenght(int keyLenght) {
		int res = keyLenght < 2 ? 2 : keyLenght;
		res =  keyLenght > 94 ? 94 : res;
		return res;
	}



	private String getKey(int keyLenght) {		
		char[] res = new char[keyLenght];
		boolean[] helper = new boolean[94];
		int i = 0;
		while (i < keyLenght) {
			int symbol = getSymbol(33, 126);	
			if (!helper[symbol - 33]) {
				res[i] = (char) symbol;
				helper[symbol - 33] = true;
				i++;
			}
		}
		return new String(res);
	}



	private static int getSymbol(int min, int max) {
		return (int)(min + Math.random() * (max - min + 1));
	}



	public String cipher(int number) {
		String res = new String();
		int remainder = 0;
		while (number > 0) {
			remainder = number % keyLenght;
			res = res + key.charAt(remainder);
			number /= keyLenght;
		}
		res = new StringBuffer(res).reverse().toString();
		return res;
	}
	public int decipher(String kodedNumber) {
		int res = 0;
		int lenght = kodedNumber.length();
		for (int i = lenght - 1; i >= 0; i--) {
			res = (int) (res + (key.indexOf(kodedNumber.charAt(i)) * Math.pow(keyLenght, lenght - i - 1)));
		}
		return res;
	}
	
	/*
	 * for visual testing only
	 * the key set by this method must match the length of the key in the class instance
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
	
	
	

}
