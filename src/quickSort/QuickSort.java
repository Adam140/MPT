package quickSort;

public class QuickSort {

	private int[] table;
	private int count = 0;

	private void quickSort(int left, int right) {
		int l = left;  // index of left-to-right scan
		int r = right; // index of right-to-left scan

		if (right - left >= 1)
		{
			int pivot = table[left];

			while (r > l) 
			{
				while (table[l] <= pivot && l <= right && r > l)
					l++; // element greater than the pivot
				while (table[r] > pivot && r >= left && r >= l)
					r--; // element not greater than the pivot
				if (r > l)
					swap(l, r);
			}
			swap(left, r); 
			
			quickSort(left, r - 1); // quicksort the left partition
			quickSort(r + 1, right); // quicksort the right partition
		} else 
		{
			return; 
		}
	}

	private void swap(int a, int b) {
		int temp = table[a];
		table[a] = table[b];
		table[b] = temp;
	}

	public static void sort(int[] table) {
		int size = table.length;

		QuickSort quick = new QuickSort();
		quick.table = table;
		quick.quickSort(0, size - 1);
	}

}
