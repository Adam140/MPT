package experiment;

import quickSort.QuickSortFacade;

public class Experiment {

	public static boolean PRINT_RESULT = false;
	public static String INPUT_FILE = "in.txt";
	public static String OUTPUT_FILE = "result.txt";
	public static long TIME = 10;
	public static int MAX_SIZE = 100;
	public static int MIN_SIZE = 5;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	Algorithm algorithm = null; 
	
	for(int i = MIN_SIZE; i < MAX_SIZE; i++)
	{
		for(int j = 0; j < TIME; j++)
		{
			algorithm = new QuickSortFacade(PRINT_RESULT, i, 0);
			
			long start = System.nanoTime();    
			algorithm.run();
			long elapsedTime = System.nanoTime() - start;
			System.out.println("size: " + i + " time: " + elapsedTime);
		}
	}
	}

}
