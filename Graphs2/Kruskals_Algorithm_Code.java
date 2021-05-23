//Input Format :
//Line 1: Two Integers V and E (separated by space)
//Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
//
//Output Format :
//Print the MST, as described in the task.

package Graphs2;

import java.util.*;
import java.io.IOException;

class Edge implements Comparable<Edge>{
    
    int v1;
    int v2;
    int weight;
    
    Edge(int v1, int v2, int weight)
    {
        this.v1 = v1;
        this.v2= v2;
        this.weight = weight;
    }
    public int compareTo(Edge e)
    {
        return this.weight - e.weight;
    }
}

public class Kruskals_Algorithm_Code {
    
    public static int findParent(int v, int[] parent)
    {
        if(v ==parent[v])
            return v;
        return findParent(parent[v], parent);
    }
    
    public static Edge[] kruskalAlgo(Edge[] edges, int V)
    {
        Arrays.sort(edges);
        Edge[] mst = new Edge[V-1];
        
        int[] parent = new int[V];
        for(int j =0; j<V; j++)
        {
            parent[j] = j;
        }
        
        int count =0, i =0;
        while(count != V-1)
        {
            Edge curredge = edges[i++];
            int v1Parent = findParent(curredge.v1, parent);
            int v2Parent = findParent(curredge.v2, parent);
            
            if(v1Parent != v2Parent)
            {
                mst[count] = curredge;
                count++;
                parent[v1Parent] = v2Parent;
            }
        }
        return mst;
    }

	public static void main(String[] args) throws NullPointerException {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
        
		Edge[] edges = new Edge[E];
		for(int i =0; i<E; i++)
        {
           
            int V1= sc.nextInt();
            int V2 = sc.nextInt();
            int W = sc.nextInt();
            
            Edge edge = new Edge(V1,V2, W);
            
            edges[i] = edge;
        }
        
        Edge mst[] = kruskalAlgo(edges, V);
        
        for(int i =0; i<mst.length; i++)
        {
            if(mst[i].v1 < mst[i].v2)
            {
                System.out.println(mst[i].v1 +" " + mst[i].v2 + " " + mst[i].weight);
            }
            else
                System.out.println(mst[i].v2 +" " + mst[i].v1 + " " + mst[i].weight);
        }
	}
}
