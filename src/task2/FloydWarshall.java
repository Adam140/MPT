package task2;

public class FloydWarshall {

	public static Double[][] shortestpath(Double[][] D, Double[][] P) {

		int N = D.length;
		// Initialize with the previous vertex for each edge. -1 indicates
		// no such vertex.
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				if (D[i][j] == -1)
				{
					P[i][j] = 0.0;
					D[i][j] = Double.POSITIVE_INFINITY;
				}
				else
					P[i][j] = Double.valueOf(i);
			}
		}

		for (int i = 0; i < N; i++)
			P[i][i] = 0.0;
		
    	Double[][] ans = new Double[N][N];
    
    	ans = D.clone();

    	// Compute successively better paths through vertex k.
    	for (int k=0; k<N;k++) {

      		// Do so between each possible pair of points.
      		for (int i=0; i<N; i++) {
        		for (int j=0; j<N;j++) {
          			if (ans[i][k]+ans[k][j] < ans[i][j]) {
          				ans[i][j] = ans[i][k]+ans[k][j];
          				P[i][j] = Double.valueOf(k);
          			}
          		}
      		}
    	}
    
		for (int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
			{
				if(i == j)
					P[i][j] = -1.0;
			}
		
    	return D;
  	}
	
	public static void printPath(int i, int j, Double[][] P)
	{
//		System.out.println("PRINT_PATH: i=" + i + " j=" + j + " P[" + i + "][" + j +"]=" + P[i][j].intValue());
		if(P[i][j] != -1.0 && P[i][j].intValue() != i)
		{
			printPath(i, P[i][j].intValue(), P);
			System.out.print(P[i][j].intValue() + "->");
			printPath(P[i][j].intValue(), j, P);
			
		}
	}

}
