//Given a NxM matrix containing Uppercase English Alphabets only. Your task is to tell if there is a path in the given matrix which makes the sentence “CODINGNINJA” .
//There is a path from any cell to all its neighbouring cells. For a particular cell, neighbouring cells are those cells that share an edge or a corner with the cell.


//Input Format :
//The first line of input contains two space separated integers N and M, where N is number of rows and M is the number of columns in the matrix. 
//Each of the following N lines contain M characters. Please note that characters are not space separated.

//Output Format :
//Print 1 if there is a path which makes the sentence “CODINGNINJA” else print 0.

package Graph_Assignment;

import java.io.IOException;
import java.util.Scanner;

public class Find_CODINGNINJA {
	
	public static int solve(String[] Graph , int N, int M)
	{
        String S = "CODINGNINJA";
        boolean [][]visited = new boolean[N][];
        for(int i=0;i<Graph.length;i++) {
			visited[i] = new boolean[Graph[i].length()];
		}

        
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<Graph[i].length();j++)
            {
               if(Graph[i].charAt(j) == S.charAt(0))
               {
                    boolean ans = solveHelper(Graph,N,M,i,j,S,visited);
                    if(ans)
                        return 1;
                }
            }
        }

        return 0;
    }
	
    public static boolean solveHelper(String[] Graph, int N, int M, int i, int j, String S, boolean[][] visited)
    {
        if(i<0 || i>=N || j<0 || j>=M)
        {
            return false;
        }

        if(S.length() == 0)
        {	
            visited[i][j] = true;
            return true;
        }

        if(visited[i][j]== true)
        {
            return false;
        }


        if(S.charAt(0)!=Graph[i].charAt(j))
            return false;

        visited[i][j]= true;

        if(solveHelper(Graph,N,M,i-1,j,S.substring(1),visited))
           return true;
        if(solveHelper(Graph,N,M,i+1,j,S.substring(1),visited))
            return true;
        if(solveHelper(Graph,N,M,i,j-1,S.substring(1),visited))
            return true;
        if(solveHelper(Graph,N,M,i,j+1,S.substring(1),visited))
            return true;
        if(solveHelper(Graph,N,M,i+1,j-1,S.substring(1),visited))
            return true;
        if(solveHelper(Graph,N,M,i+1,j+1,S.substring(1),visited))
            return true;
        if(solveHelper(Graph,N,M,i-1,j-1,S.substring(1),visited))
            return true;
        if(solveHelper(Graph,N,M,i-1,j+1,S.substring(1),visited))
            return true;

        visited[i][j]=false;
        return false;

    }
    
//    public static void main(String[] args) throws NumberFormatException, IOException{
//        
//        Scanner scan = new Scanner(System.in);
//    	int N= scan.nextInt();
//        int M= scan.nextInt();
//
//        String [] mat = new String[M];
//        
//    	for(int i=0; i<N; i++)
//    	{
//    		mat[i] = scan.nextLine();
//    	}
//    	
//    	int ans = solve(mat,N,M);
//    	System.out.print(ans);
//
//    }
}
