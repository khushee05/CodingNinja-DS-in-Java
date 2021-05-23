//It's Gary's birthday today and he has ordered his favourite square cake consisting of '0's and '1's . But Gary wants the biggest piece of '1's and no '0's . A piece of cake is defined as a part which consist of only '1's, and all '1's share an edge with each other on the cake. Given the size of cake N and the cake, can you find the count of '1's in the biggest piece of '1's for Gary ?
//
//
//Input Format :
//The first line of input contains an integer, that denotes the value of N. 
//Each of the following N lines contain N space separated integers.
//
//
//Output Format :
//Print the count of '1's in the biggest piece of '1's, according to the description in the task.



package Graph_Assignment;

public class LargestPiece {
    

	public static int dfs(String[] cake, int n) {
		
        boolean[][] visited = new boolean[n][n];
		int max = 0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(!visited[i][j] && cake[i].charAt(j)=='1' ){
					int ans = max1s( cake,visited,i,j,n);
					if(max <ans){
						max = ans;
					}
				}
			}
		}
		return max;
	}
						
    public static int max1s(String[] cake,boolean[][] visited,int x,int y,int n){

		int max = 0;
        
        if(x<0 || y<0 || x>=n || y>=n)
            return 0;
        
        if(visited[x][y] == true)
            return 0;
        
        if(cake[x].charAt(y) =='0')
        {
            visited[x][y] = true;
            return 0;
        }
        
        visited[x][y] = true;
        
		
		max = max + max1s(cake,visited, x-1,y,n);
        max = max + max1s(cake,visited, x,y-1,n);
        max = max + max1s(cake,visited, x+1,y,n);
        max = max + max1s(cake,visited, x,y+1,n);
        
        
		return max + 1;


	}


}
