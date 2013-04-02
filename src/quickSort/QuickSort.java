package quickSort;

public class QuickSort {
	
	private int[] table;
	private int count = 0;
	
	private void quickSort(int left, int right)
	{
		 int l = left;                          // index of left-to-right scan
	        int r = right;                            // index of right-to-left scan

	        if (right - left >= 1)                   // check that there are at least two elements to sort
	        {
	                int pivot = table[left];       // set the pivot as the first element in the partition

	                while (r > l)                   // while the scan indices from left and right have not met,
	                {
	                        while (table[l] <= pivot && l <= right && r > l)  // from the left, look for the first
	                                l++;                                    // element greater than the pivot
	                        while (table[r] > pivot && r >= left && r >= l) // from the right, look for the first
	                            r--;                                        // element not greater than the pivot
	                        if (r > l)                                       // if the left seekindex is still smaller than
	                                swap(l, r);                      // the right index, swap the corresponding elements
	                }
	                swap(left, r);          // after the indices have crossed, swap the last element in
	                                                // the left partition with the pivot 
	                quickSort(left, r - 1); // quicksort the left partition
	                quickSort(r + 1, right);   // quicksort the right partition
	        }
	        else    // if there is only one element in the partition, do not do any sorting
	        {
	                return;                     // the array is sorted, so exit
	        }
//		count++;
//		int l = left, r = right;
//	    int pivot = table[left + (right-left)/2];
//
//	    while (l <= r) {
//	      
//	    	while (table[l] < pivot) {
//	        l++;
//	      }
//	      while (table[r] > pivot) {
//	        r--;
//	      }
//
//	      if (l <= r) {
//	        swap(l, r);
//	        l++;
//	        r--;
//	      }
//	    }
//	    if (left < r)
//	      quickSort(left, r);
//	    if (l < right)
//	      quickSort(l, right);
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
