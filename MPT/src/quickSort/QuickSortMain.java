package quickSort;

import java.util.Arrays;

import util.Random;

public class QuickSortMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 int N = 10;

		 int[] table = Random.randArrayInt(N, 0, 10);
		 
		 System.out.println("Table before sort \n" + Arrays.toString(table));
		 QuickSort.sort(table);
		 System.out.println("Table after sort \n" + Arrays.toString(table));
	}

}
