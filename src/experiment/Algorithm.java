package experiment;

public class Algorithm {

	protected boolean printResult = false;	// if function have to print result
	protected int size;	// size of table or something else
	protected int option = 0;	// for several variants
	
	
	public Algorithm(boolean printResult, int size, int option) {
		this.printResult = printResult;
		this.size = size;
		this.option = option;
	}

	Object run() {
		return null;
	}
	
}
