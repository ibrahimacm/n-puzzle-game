public class customException extends Exception {
	private int i;
    public customException(int ii) {
    	i = ii;
    }
    public int getN() {
    	return i;
    }
}