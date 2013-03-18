package quickSort;

public class QuickSort {
	
	private static void quickSort(int[] table, int left, int right)
	{
		int pivot, temp;
		
		temp = (int) Math.floor( (left + right) / 2.0 );
		
		pivot = table[temp];
//		table[right] = pivot;
		table[temp] = table[right];
		
		int i,j;
		for(i=j=left; i < right; i++)
		{
			if(table[i] < pivot)
			{
				temp = table[i];
				table[i] = table[j];
				table[j] = temp;
				j++;
			}
		}
		table[right] = table[j];
		table[j] = pivot;

		if(left < j - 1)
			quickSort(table, left, j - 1);
		if(right > j + 1)
			quickSort(table, j + 1, right);
	}
	
	public static void sort(int[] table)
	{
		int size = table.length;
		
		quickSort(table, 0, size - 1);
		
	}
	

}
