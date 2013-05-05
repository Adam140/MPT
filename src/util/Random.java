package util;

public class Random {

	/**
	 * Randomize some integral in the range of <a;b>
	 * @param a min value
	 * @param b max value
	 * @return random integer
	 */
	public static int randInt(int a, int b)
	{
		int result = 0;
		result = a + (int)(Math.random() * ((b - a) + 1));
		return result;
	}
	
	/**
	 * Create array of integral, filled with random number
	 * @param size length of array
	 * @param a min value
	 * @param b max value
	 * @return int[size]
	 */
	public static int[] randArrayInt(int size, int a, int b)
	{
		int[] result = new int[size];
		
		for(int i = 0; i < size; i++)
		{
			result[i] = randInt(a, b);
		}
		
		return result;
	}

	/**
	 * Create 2-D array of integral for second task, it's a array of cost.
	 * If n was lowest then two then n would be random. 
	 * @param n number of rental posts
	 * @return Double[n][n]
	 */
	public static Double[][] randCostArray(int n)
	{
		n = n < 2 ? randInt(5,1000):n;
		Double[][] array = new Double[n][n];
		
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if( j > i)
					array[i][j] = (double) randInt(1, 100);
				else if( i == j)
					array[i][j] = 0.0;
				else
					array[i][j] = Double.POSITIVE_INFINITY;
					
					
			}
		}
		return array;
	}
}
