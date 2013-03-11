package util;

public class Random {

	public static int randInt(int a, int b)
	{
		int result = 0;
		result = a + (int)(Math.random() * ((b - a) + 1));
		return result;
	}
	
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
