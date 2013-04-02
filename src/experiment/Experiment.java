package experiment;

import java.util.Arrays;

import quickSort.QuickSortFacade;
import util.Random;
import util.WriteFile;
import org.apache.commons.lang.time.StopWatch;

/**
 * The main class, used for all experiment Static variable:
 * <ul>
 * <li><b>PRINT_RESULT</b> - if is true then result will be print</li>
 * <li><b>INPUT_FILE </b> - path for input file</li>
 * <li><b>OUTPUT_FILE </b> - path or name for output file</li>
 * <li><b>REPEAT </b> - how many time experiment should be repeat (with this
 * same size)</li>
 * <li><b>AVERAGE </b> - take average of all reapet</li>
 * <li><b>MIN_SIZE </b> - first size using in experiment</li>
 * <li><b>MAX_SIZE </b> - last size using in experiment</li>
 * <li><b>OPTION </b> - some options for algorithm, depend on task</li>
 * </ul>
 * 
 * @author Adam
 * 
 */
public class Experiment {

	public static boolean PRINT_RESULT = false;
	public static String INPUT_FILE = "in.txt";
	public static String OUTPUT_FILE = "2.txt";
	public static int REPEAT = 100; // how many time check this same size
	public static boolean AVERAGE = true;
	public static int MIN_SIZE = 10;
	public static int MAX_SIZE = 100000;
	public static int OPTION = QuickSortFacade.UNSORTED;

	public static void main(String[] args) throws Exception {

		Algorithm algorithm = null;
		String buffer = "";
		WriteFile wf = new WriteFile(OUTPUT_FILE);

		for (int i = MIN_SIZE; i <= MAX_SIZE; i += 10) {
			int[] avg = new int[REPEAT];
			for (int j = 0; j < REPEAT; j++) {
				// *******************************************************
				algorithm = new QuickSortFacade(PRINT_RESULT, i, OPTION); // here
																			// change
																			// variant
				// *******************************************************
				Object result = algorithm.run();

				if (!algorithm.test(result)) {
					throw new Exception("BAD IMPLEMENTATION!");
				}

				if (AVERAGE)
					avg[j] = Integer.valueOf( algorithm.getTime());
				else {
					buffer = Integer.toString(i) + " " + algorithm.getTime()
							+ "\n";
					System.out.println("size: " + i + " time: "
							+ algorithm.getTime());
					wf.writeString(buffer);
				}

			}
			if (AVERAGE) {
				buffer = Integer.toString(i) + " " + avg(avg) + "\n";
				System.out.println("size: " + i + " time: "	+ avg(avg));
				wf.writeString(buffer);
			}

		}

		wf.close();
	}

	public static double avg(int[] table) {
		double result = 0;

		for (int i = 0; i < table.length; i++)
			result += table[i];

		return result / table.length;
	}

}
