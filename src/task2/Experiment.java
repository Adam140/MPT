package task2;

import java.io.File;

import org.apache.commons.lang.time.StopWatch;

import util.WriteFile;

public class Experiment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Experiment start:");
		WriteFile wf = new WriteFile(new File("experimentFloydWarshall.txt"));
		WriteFile wf2 = new WriteFile(new File("experimentFloydWarshall2.txt"));
		for (int i = 10; i < 800; i++) {
			int N = i;
			System.out.print("Size: " + i);
			Double[][] firstD = util.Random.randCostArray(N);
			Double[][] D = null;
			Double[][] P = new Double[N][N];
			StopWatch sw = new StopWatch();
			StopWatch sw2 = new StopWatch();
			sw.start();
			D = FloydWarshall.shortestpath(firstD, P, sw2);
			sw.stop();
			System.out.println(" time: " + sw.getTime() + " ms");
			String buffer = i + " " + sw.getTime() + "\n";
			String buffer2 = i + " " + sw2.getTime() + "\n";
			wf.writeString(buffer);
			wf2.writeString(buffer2);
		}

	}

}
