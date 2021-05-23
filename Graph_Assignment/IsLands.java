//An island is a small piece of land surrounded by water . A group of islands is said to be connected if we can reach from any given island to any other island in the same group . Given V islands (numbered from 1 to V) and E connections or edges between islands. Can you count the number of connected groups of islands.
//Input Format :
//The first line of input contains two integers, that denote the value of V and E.
//Each of the following E lines contains two integers, that denote that there exists an edge between vertex a and b. 
//Output Format :
//Print the count the number of connected groups of islands

package Graph_Assignment;

import java.util.Scanner;

public class IsLands {

	public static int numConnected(int[][] edges, int n) {
        
		boolean visited[] = new boolean[n];
        int count =0;
        for(int i=0; i<n; i++)
        {
            if(!visited[i])
            {
                numConnected(edges,n,i,visited);
                
                    count++;
            }
        }
        return count;
        
	}
    public static void numConnected(int[][] edges, int n, int i, boolean visited[])
    {
        visited[i] = true;
        for(int j =0; j<n; j++)
        {
            if(edges[i][j] == 1 && visited[j] == false)
              numConnected(edges,n,j,visited);
        }
    }
    
    public static void main(String[] args) throws NumberFormatException {
        
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
        
        int ans = numConnected(mat, mat.length);
        System.out.println(ans);
		
	}

}