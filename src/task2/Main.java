package task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import util.ReadFile;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

		int[][] firstD = null;

		String choice = "";
//		do {
//			System.out.println("[F]ile or [M]anual: ");
//			choice = consoleReader.readLine();
//		} while (!"F".equalsIgnoreCase(choice) && !"M".equalsIgnoreCase(choice));

		choice = "F";
		if ("F".equalsIgnoreCase(choice)) {
			String temp = "";
//			do{
//				System.out.println("Enter input file name");
//				temp = consoleReader.readLine();
//			}while(!new File(temp).exists());
			temp = "C:\\Users\\Adam\\git\\MPT\\src\\task2\\input.txt";
			firstD = ReadFile.fillArrayFromFile(temp);
		} else {
			String temp = "";
			int N;

			do {
				try {
					System.out.println("Enter number of rental posts: ");
					temp = consoleReader.readLine();
					N = Integer.parseInt(temp);
					break;
				} catch (Exception e) {
					continue;
				}
			} while (true);

			firstD = intializeArray(N);

			for (int i = 1; i < N; i++) {
				for (int j = 0; j < i; j++)
				{
					try {
						System.out.println("Enter cost from " + i + " to " + j);
						temp = consoleReader.readLine();
						firstD[i][j] = Integer.parseInt(temp);
					} catch (Exception e) {
						j--;
					}
				}
			}
		}
		
		printArray(firstD);
		// ************************************* Array is ready******************************************************
		
		int N = firstD.length;
		int[][] D;
    	int[][] P = new int[N][N];
    	// Initialize with the previous vertex for each edge. -1 indicates
    	// no such vertex.
    	for (int i=0; i<N; i++)
    		for (int j=0; j<N; j++)
    			if (firstD[i][j] == -1)
    				P[i][j] = -1;
    			else
    				P[i][j] = i;
    		
    	for (int i=0; i<N; i++)
    		P[i][i] = i;
    	
    	
    	D = FloydWarshall.shortestpath(firstD, P);

		printArray(D);
		
    	System.out.println("From where to where do you want to find the shortest path?");
    	int start = 1;
    	int end = 4;
    
    	printArray(P);
    	// The path will always end at end.
    	String myPath = end + "";
    
    	// Loop through each previous vertex until you get back to start.
    	while (P[start][end] != start) {
    		myPath = P[start][end] + " -> " + myPath;
    		end = P[start][end];
    	}
    	
    	myPath = start + " -> " + myPath;
    	System.out.println("Here's the path "+myPath);
 
	}

	public static int[][] intializeArray(int N) {
		int[][] array = new int[N][];

		for (int i = 0; i < N; i++) {
			array[i] = new int[N];
			for (int j = 0; j <= i; j++) {
				array[i][j] = -1;
			}
		}

		return array;
	}
	
	public static void printArray(int[][] array)
	{
		try{
	        int rows = array.length;
	        int columns = array[0].length;
	        String str = "|\t";

	        for(int i=0;i<rows;i++){
	            for(int j=0;j<columns;j++){
	                str += array[i][j] + "\t";
	            }

	            System.out.println(str + "|");
	            str = "|\t";
	        }

	    }catch(Exception e){System.out.println("Matrix is empty!!");}
		System.out.println();
	}

}
