package task2;

public class FloydWarshall {

	public static int[][] shortestpath(int[][] array, int[][] path) {

    	int n = array.length;
    	int[][] ans = new int[n][n];
    
    	ans = array.clone();

    	// Compute successively better paths through vertex k.
    	for (int k=0; k<n;k++) {

      		// Do so between each possible pair of points.
      		for (int i=0; i<n; i++) {
        		for (int j=0; j<n;j++) {
        		
        			if(ans[i][k] == -1 || ans[k][j] == -1)
        				continue;
        
          			if (ans[i][k]+ans[k][j] < ans[i][j]) {
          				ans[i][j] = ans[i][k]+ans[k][j];
          				path[i][j] = path[k][j];
          			}
          		}
      		}
    	}
    
    	return array;
  	}

}
