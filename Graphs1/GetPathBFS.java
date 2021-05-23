package Graphs1;

import java.util.*;
import java.io.IOException;
public class GetPathBFS {
	
	public static void main(String[] args)  throws NumberFormatException, IOException{
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
        public static ArrayList<Integer> getPath(int[][] edges,int start,int end,boolean[] visited){

		Queue<Integer> queue = new LinkedList<>();
		HashMap<Integer, Integer> map = new HashMap<>();

		queue.add(start);
		visited[start] = true;
		while( !queue.isEmpty() && queue.peek()!=end) {

			int front = queue.poll();
			for(int i=0;i<edges.length;i++) {
				if(!visited[i] && edges[front][i] == 1) {
					queue.add(i);
					visited[i] = true;
					map.put(i, front);
				}
			}

		}
		ArrayList<Integer> ans = new ArrayList<>();
		if(!map.containsKey(end)) {
			return null;
		}
		else {
			ans.add(end);
			int f = map.get(end);
			while(f!=start) {
				ans.add(f);

				f = map.get(f);

			}
			ans.add(start);

		}

		return ans;



	}

}
