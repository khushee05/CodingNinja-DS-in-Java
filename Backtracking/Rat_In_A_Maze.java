//You are given a N*N maze with a rat placed at maze[0][0]. Find whether any path exist that rat can follow to reach its destination i.e. 
//maze[N-1][N-1]. Rat can move in any direc�tion ( left, right, up and down).
//Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can�not enter into those cells 
//and those with value 1 are open.

//Input Format
//Line 1: Integer N
//Next N Lines: Each line will contain ith row elements (separated by space)
//
//Output Format :
//The output line contains true if any path exists for the rat to reach its destination otherwise print false.


package Backtracking;

import java.util.Scanner;

public class Rat_In_A_Maze {

	public static boolean ratInAMaze(int maze[][]){

		int n = maze.length;
        int path[][] = new int[n][n];
        return solvemaze(maze,0,0,path);

	}
    public static boolean solvemaze(int maze[][], int i, int j, int path[][]){
        
        int n = maze.length;
        if( i < 0  || i>=n || j<0 || j>= n || maze[i][j] == 0 || path[i][j] == 1)
            return false;
        path[i][j] = 1;
        
        if( i == n-1 && j==n-1)
            return true;
        
        if(solvemaze(maze, i-1, j,path)){
            return true;
        }
           
        if(solvemaze(maze, i, j+1,path)){
            return true;
        }
        
        if(solvemaze(maze, i+1, j,path)){
            return true;
        }
        
        if(solvemaze(maze, i, j-1,path)){
            return true;
        }
           return false;
               
    }
    
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int maze[][] = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				maze[i][j] = s.nextInt();
			}
		}
		System.out.println(ratInAMaze(maze));	
	}
}
