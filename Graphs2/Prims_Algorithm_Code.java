//Input Format :
//Line 1: Two Integers V and E (separated by space)
//Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
//
//Output Format :
//Print the MST, as described in the task.

package Graphs2;

import java.util.Scanner;

public class Prims_Algorithm_Code {
    
    private static int findMinVertex(boolean[] visited, int[] weight)
    {
        int minvertex = -1;
        for(int i =0; i<visited.length; i++)
        {
        	if(!visited[i] && (minvertex == -1 || weight[i] < weight[minvertex]))
            {
                minvertex = i;
            }
            
    	}
        return minvertex;
        
    }
    
    public static void primsAlgo(int[][]mat, int V){
        
        boolean visited[] = new boolean[V];
        int parent[] = new int[V];
        int weight[] = new int[V];
        
        parent[0] = -1;
        weight[0] = 0;
        
        for(int i =1; i<V; i++)
        {
            weight[i] = Integer.MAX_VALUE;
        }
        
        for(int i=0; i<V; i++)
        {
            int minvertex = findMinVertex(visited, weight);
            visited[minvertex] = true;
            for(int j =0; j< V; j++)
            {
                if(mat[minvertex][j] !=0 && !visited[j]){
                    if(weight[j] > mat[minvertex][j])
                    {
                        weight[j] = mat[minvertex][j];
                        parent[j] = minvertex;
                    }
            }
        }
        }
        
        for(int i =1; i<V; i++)
        {
            if(i < parent[i])
            	System.out.println(i + " " + parent[i] + " " + weight[i]);
            else
                System.out.println(parent[i] + " " + i + " " + weight[i]);
        }
    }

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int V = scan.nextInt();
		int E = scan.nextInt();

		int[][] mat = new int[V][V];
        
        for(int i=0; i<E; i++)
        {
            int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            int w = scan.nextInt();
            mat[v1][v2] = w;
            mat[v2][v1] = w;
        }
        
        primsAlgo(mat,V);
	}
}