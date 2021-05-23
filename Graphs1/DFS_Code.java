package Graphs1;

import java.util.*;
import java.io.IOException;
public class DFS_Code {

	public static void main(String[] args) throws NumberFormatException, IOException {
      
        Scanner scan = new Scanner(System.in);
    	int V= scan.nextInt();
        int E = scan.nextInt();

        int [][] mat = new int[V][V];
        
    	for(int i =0; i<E;i++)
        {
        	int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            mat[v1][v2] = 1;
            mat[v2][v1] = 1;
        }
       
        
        boolean visit[] = new boolean[mat.length];
        DFS(mat,0,visit);
        

	}
    
    public static void DFS(int[][] edges, int node, boolean[] visited)
    {
        
    	System.out.print(node + " ");
    	
    	visited[node] = true;
        for(int i=0;i<edges.length;i++){
            if( edges[node][i] ==1 && !visited[i] ){
                DFS(edges,i,visited);
    
   
            }
        }
    }

}
