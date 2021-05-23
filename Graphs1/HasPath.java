package Graphs1;

import java.util.*;
import java.io.IOException;
public class HasPath {

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
        
        int node = scan.nextInt();
        int target= scan.nextInt();
        
        boolean visit[] = new boolean[mat.length];
        boolean ans = hasPathDFS(mat,node,target,visit);
        System.out.print(ans);
        

	}
    
    public static boolean hasPathDFS(int[][] edges, int start, int end, boolean[] visited)
    {
        if(start == end){
            return true;
        }
        visited[start] = true;
        for(int i=0;i<edges.length;i++){
            if( edges[start][i] ==1 && !visited[i] ){
                if(hasPathDFS(edges,i,end,visited)){
                    return true;
                }
            }
        }
        return false;
    }

}