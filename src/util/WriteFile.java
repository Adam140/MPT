package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

	private File file;
	private FileWriter fstream = null;
	private BufferedWriter out = null;

	public WriteFile(String file) {
		this.file = new File(file);
	}

	public WriteFile(File file) {
		this.file = file;
	}

	public void writeString(String buffer) {

		try {
			if (fstream == null || out == null) {
				fstream = new FileWriter(file.getAbsolutePath());
				out = new BufferedWriter(fstream);
			}
			out.flush();
			out.write(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		if (out != null)
			try {
				out.close();
				out = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	/**
	 * Fast static method to write some string into file, without creat object or close file
	 * 
	 * @param file
	 *            path to file
	 * @param buffer
	 *            some string to write
	 */
	public static void writeString(String file, String buffer) {

		try {
			FileWriter fstream = new FileWriter(file);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(buffer);
			// Close the output stream
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

}
