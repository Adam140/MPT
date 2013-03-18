package quickSort;

import java.util.Arrays;

import experiment.Algorithm;

import util.Random;

public class QuickSortFacade extends Algorithm {


	public QuickSortFacade(boolean printResult, int size, int option) {
		super(printResult, size, option);
	}

	public void run() {
		 int N = 10;

		 int[] table = Random.randArrayInt(N, 0, 10);
		 
		 if(printResult)
			 System.out.println("Table before sort \n" + Arrays.toString(table));
		 
		 QuickSort.sort(table);
		 
		 if(printResult)
			 System.out.println("Table after sort \n" + Arrays.toString(table));
	}

}
