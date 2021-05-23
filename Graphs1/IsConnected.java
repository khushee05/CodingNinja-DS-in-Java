//Given an undirected graph G(V,E), check if the graph G is connected graph or not.

package Graphs1;

import java.util.*;
import java.io.IOException;

public class IsConnected {

	public static void main(String[] args) throws NumberFormatException, IOException {
       
        Scanner scan = new Scanner(System.in);
    	int V= scan.nextInt();
        int E = scan.nextInt();
        
        if(V ==0)
        {
            System.out.print(true);
                return;
        }

        int [][] mat = new int[V][V];
        
    	for(int i =0; i<E;i++)
        {
        	int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            mat[v1][v2] = 1;
            mat[v2][v1] = 1;
        }
        
        
        boolean visit[] = new boolean[mat.length];
        isConnected(mat,0,visit);
        for(int i=0; i<visit.length; i++)
        {
            if(visit[i] == false)
            {
                System.out.print(false);
                return;
            }
        }
        System.out.print(true);
        

	}
    
    public static void isConnected(int[][] edges,int node, boolean[] visit)
    {
        
        visit[node] = true;
        for(int i=0;i<edges.length;i++){
            if( edges[node][i] ==1 && !visit[i] ){
                
                isConnected(edges,i,visit);
            }
        }
    }
}