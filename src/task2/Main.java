package task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang.time.StopWatch;

import util.ReadFile;
import util.WriteFile;

public class Main {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

		Double[][] firstD = null;

		String choice = "";
		do {
			System.out.println("[F]ile or [M]anual or [G]enerate: ");
			choice = consoleReader.readLine();
		} while (!"F".equalsIgnoreCase(choice) && !"M".equalsIgnoreCase(choice) && !"G".equalsIgnoreCase(choice));

//		choice = "F";
		if ("F".equalsIgnoreCase(choice) || "G".equalsIgnoreCase(choice)) {
			String temp = "";
			if("G".equalsIgnoreCase(choice))
			{
				do {
					try {
						System.out.println("Enter number of rental posts: ");
						temp = consoleReader.readLine();
						int N = Integer.parseInt(temp);
						firstD = util.Random.randCostArray(N);
						temp = "array" + N + ".txt";
						WriteFile.writeString(temp, arrayToString(firstD));
						break;
					} catch (Exception e) {
						continue;
					}
				} while (true);
			}
			// temp = "C:\\Users\\Adam\\git\\MPT\\src\\task2\\input.txt";
			
			while (!new File(temp).exists())
			{
				System.out.println("Enter input file name");
				temp = consoleReader.readLine();
			}
			System.out.println("Read array from file: " + temp);
			
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
				for (int j = 0; j < i; j++) {
					try {
						System.out.println("Enter cost from " + i + " to " + j);
						temp = consoleReader.readLine();
						firstD[i][j] = Double.valueOf(temp);
					} catch (Exception e) {
						j--;
					}
				}
			}
		}
		System.out.println("Matrix of cost");
		printArray(firstD);
		// ************************** Array is ready********************************************

		int N = firstD.length;
		Double[][] D;
		Double[][] P = new Double[N][N];

		D = FloydWarshall.shortestpath(firstD, P, new StopWatch());
			
		System.out.println("Matrix of shortest cost");
		printArray(D);

		System.out.println("Matrix of references");
		printArray(P);
		do {
			try {
				System.out.println("From where to where do you want to find the shortest path?");
				System.out.println("Enter first vertex");
				int start = Integer.parseInt(consoleReader.readLine());
				System.out.println("Enter second vertex");
				int end = Integer.parseInt(consoleReader.readLine());
				if( start >= end || start >= N || end >= N)
					throw new Exception("Wrong vertex");
				System.out.print(start + "->");
				FloydWarshall.printPath(start, end, P);
				System.out.print(end);
				System.out.println("\nPut [q] to quit: ");
				String quit = consoleReader.readLine();
				if(quit.equalsIgnoreCase("q"))
					break;
			} catch (Exception e) {
				System.out.println("Some error ocurs. Enter input again");
				continue;
			}
		} while (true);

	}

	public static Double[][] intializeArray(int N) {
		Double[][] array = new Double[N][];

		for (int i = 0; i < N; i++) {
			array[i] = new Double[N];
			for (int j = 0; j <= i; j++) {
				if(i == j)
					array[i][j] = 0.0;
				else
					array[i][j] = Double.POSITIVE_INFINITY;
					
			}
		}

		return array;
	}

	public static void printArray(Object[][] firstD) {
		try {
				
			int rows = firstD.length;
			int columns = firstD[0].length;
			String str = "|\t";

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					str += firstD[i][j] + "\t";
				}

				System.out.println(str + "|");
				str = "|\t";
			}

		} catch (Exception e) {
			System.out.println("Matrix is empty!!");
		}
		System.out.println();
	}

	public static String arrayToString(Double[][] array) {
		String result = "";
		int n = array.length;

		result += n + "\n";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result += array[i][j];
				if (j + 1 != n) {
					result += ",";
				}
			}

			result += "\n";
		}
		return result;
	}
}
