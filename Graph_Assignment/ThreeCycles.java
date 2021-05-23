package Graph_Assignment;

import java.util.Scanner;
import java.io.IOException;

public class ThreeCycles {

	public static int solve(boolean[][] edges, int n) {
		
        int count=0;
		for(int i=0;i<edges.length;i++) {
			for(int j=0;j<edges.length;j++) {
				if(edges[i][j] == true) {
					
					for(int k=0;k<edges.length;k++) {
						
						if(k!=i && edges[k][j]==true && edges[i][k] == true ) {
							count++;
						}
						
						
					}
					
				}
			}
		}
		return count/6;
	}
	

	public static boolean[][] takeInput() throws IOException {
	
        Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();

		boolean[][] graphs = new boolean[n][n];
		int firstvertex, secondvertex;

		for (int i = 0; i < m; i++) {
			firstvertex = scan.nextInt();
            secondvertex = scan.nextInt();
			graphs[firstvertex][secondvertex] = true;
			graphs[secondvertex][firstvertex] = true;
		}
		return graphs;
	}

	public static void main(String[] args) throws IOException {
		boolean[][] graphs = takeInput();

		int ans = solve(graphs, graphs.length);
		System.out.println(ans);

	}
}