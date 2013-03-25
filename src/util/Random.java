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

}
