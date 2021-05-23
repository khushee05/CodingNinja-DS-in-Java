package Graphs1;

import java.util.ArrayList;
import java.util.*;

public class GetPathDFS {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        
        int V =scan.nextInt();
        int E = scan.nextInt();
        
        int[][] edges = new int[V][V];
        for(int i =0; i<E;i++)
        {
        	int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            edges[v1][v2] = 1;
            edges[v2][v1] = 1;
        }
        
		
		int start = scan.nextInt();
		int end  = scan.nextInt();
		boolean[] visited = new boolean[edges.length];
        
        
		ArrayList<Integer> ans = getPath(edges, start, end, visited);
		if(ans!=null)
			for(int i : ans) {
				System.out.print(i+" ");
			}
	}

	public static ArrayList<Integer> getPath( int[][] edges ,int start ,int end, boolean[] visited){
		if(start == end) {
			ArrayList<Integer> ansArrayList = new ArrayList<>();
			ansArrayList.add(start);
			return ansArrayList;
		}
		visited[start] = true;
		for(int i=0;i<edges.length;i++) {

			if(edges[start][i]==1 && !visited[i]) {

				ArrayList<Integer> ans = getPath(edges, i, end, visited);
				if(ans!=null) {
					ans.add(start);
					return ans;
				}

			}

		}
		return null;

	}
}