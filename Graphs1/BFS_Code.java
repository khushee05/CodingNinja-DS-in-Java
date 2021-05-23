package Graphs1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
import java.io.IOException;

public class BFS_Code {

	public static void main(String[] args) throws NumberFormatException, IOException {
        
        Scanner scan = new Scanner(System.in);
    	int V= scan.nextInt();
        int E = scan.nextInt();
        if(V==0)
            return;
        int [][] mat = new int[V][V];
        
    	for(int i =0; i<E;i++)
        {
        	int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            mat[v1][v2] = 1;
            mat[v2][v1] = 1;
        }
	
        boolean[] arr = new boolean[V];
        
        // bfsTraversal(mat,arr);
         for(int i=0; i< mat.length; i++){
            if(!arr[i]){
                bfsTraversal(mat,i,arr);   
            }
         }
	}
    public static void bfsTraversal(int[][] mat,int s, boolean[] arr){
        
        Queue<Integer> pending = new LinkedList<>();
        pending.add(s);
       
        
        while(! pending.isEmpty())
        {     
            int node = pending.poll();
            System.out.print(node + " ");
             arr[s] = true;
            for(int i = 0; i< mat.length; i++)
            {
                if(mat[node][i] == 1 && arr[i] == false)
                {
                    arr[i] = true;
                    pending.add(i);
                }
            }
        }
        
        
        
    }
        

}
