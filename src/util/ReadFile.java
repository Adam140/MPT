package util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import task2.Main;

public class ReadFile {

	public static Double[][] fillArrayFromFile(String file) {
		Double[][] array = null;
		try {
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream(file);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			int i = 0;
			int temp = 0;
			String strLine;

			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				if (i == 0) {
					array = Main.intializeArray(Integer.parseInt(strLine));
				} else
				{
					String[] split = strLine.split(",");
					if(split.length != array.length)
						throw new Exception("Wrong number of costs");
					
					for(int j = 0; j < split.length; j++)
					{
						array[i-1][j] = Double.valueOf(split[j].replaceAll("\\s",""));
//						if(array[i-1][j] == -1)
//							array[i-1][j] = Double.POSITIVE_INFINITY;
							
					}
							
				}
				
				
				i++;
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	return array;
	}
	
}
