package quickSort;

import java.util.Arrays;

import org.apache.commons.lang.time.StopWatch;

import experiment.Algorithm;

import util.Random;

public class QuickSortFacade extends Algorithm {

	public static int UNSORTED = 0;
	public static int SORTED = 1;
	public QuickSortFacade(boolean printResult, int size, int option) {
		super(printResult, size, option);
		sw = new StopWatch();
	}

	public Object run() {

		int[] table = new int[size];

		if (option == UNSORTED)
			table = Random.randArrayInt(size, 0, 100);
		if (option == SORTED)
			Arrays.fill(table, 1);

		if (printResult)
			System.out.println("Table before sort \n" + Arrays.toString(table));

		// the main algorithm
		sw.start();
		QuickSort.sort(table);
		sw.stop();
		
		if (printResult)
			System.out.println("Table after sort \n" + Arrays.toString(table));

		return table;
	}

	public boolean test(Object obj) {
		int[] tab = (int[]) obj;

		for (int i = 1; i < tab.length; i++) {
			if (tab[i - 1] > tab[i])
				return false;
		}
		return true;
	}

}
