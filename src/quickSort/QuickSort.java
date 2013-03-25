package quickSort;

public class QuickSort {
	
	private int[] table;
	private int count = 0;
	
	private void quickSort(int left, int right)
	{
		count++;
		int l = left, r = right;
	    // Get the pivot element from the middle of the list
	    int pivot = table[left + (right-left)/2];

	    // Divide into two lists
	    while (l <= r) {
	      // If the current value from the left list is smaller then the pivot
	      // element then get the next element from the left list
	      while (table[l] < pivot) {
	        l++;
	      }
	      // If the current value from the right list is larger then the pivot
	      // element then get the next element from the right list
	      while (table[r] > pivot) {
	        r--;
	      }

	      // If we have found a values in the left list which is larger then
	      // the pivot element and if we have found a value in the right list
	      // which is smaller then the pivot element then we exchange the
	      // values.
	      // As we are done we can increase i and j
	      if (l <= r) {
	        swap(l, r);
	        l++;
	        r--;
	      }
	    }
	    // Recursion
	    if (left < r)
	      quickSort(left, r);
	    if (l < right)
	      quickSort(l, right);
//	    
//		int pivot, temp;
//		
//		temp = (int) Math.floor( (left + right) / 2.0 );
//		
//		pivot = table[temp];
//		table[temp] = table[right];
//		
//		int i,j;
//		for(i=j=left; i < right; i++)
//		{
//			if(table[i] < pivot)
//			{
//				swap(i,j);
//				j++;
//			}
//		}
//		table[right] = table[j];
//		table[j] = pivot;
//		
//		if(left < j - 1)
//			quickSort(left, j - 1);
//		if(right > j + 1)
//			quickSort(j + 1, right);
	    
	}
	
	private void swap(int a, int b)
	{
		int temp = table[a];
	    table[a] = table[b];
	    table[b] = temp;
	}
	
	public static void sort(int[] table)
	{
		int size = table.length;
		
		QuickSort quick = new QuickSort();
		quick.table = table;
		quick.quickSort(0, size - 1);
//		System.out.println("count" + quick.count);
		
	}
	

}
