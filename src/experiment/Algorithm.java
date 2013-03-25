package experiment;

import org.apache.commons.lang.time.StopWatch;

public abstract class Algorithm {

	protected boolean printResult = false;	// if function have to print result
	protected int size;	// size of table or something else
	protected int option = 0;	// for several variants
	protected StopWatch sw;
	
	
	public Algorithm(boolean printResult, int size, int option) {
		this.printResult = printResult;
		this.size = size;
		this.option = option;
	}

	/**
	 * This method is for running some algorithm
	 * @return
	 */
	public abstract Object run();
	
	/**
	 * Method implementing some test to check result 
	 * @param obj result from run method
	 * @return true or false 
	 */
	public abstract boolean test(Object obj);
	
	/**
	 * @return time
	 */
	public String getTime()
	{
		return Long.toString(sw.getTime());
	}
}
