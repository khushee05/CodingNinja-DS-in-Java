//A thief wants to loot houses. He knows the amount of money in each house. He cannot loot two consecutive houses. Find the maximum amount of money he can loot.
//
//Input format :
//The first line of input contains an integer value of 'n'. It is the total number of houses.
//
//The second line of input contains 'n' integer values separated by a single space denoting the amount 
//of money each house has.
//Output format :
//Print the the maximum money that can be looted.


package DynamicProgramming1;

import java.util.Scanner;

public class LootHouses {
	
	public static int maxMoneyLooted(int[] houses) {
		//Your code goes here
        int n = houses.length;
        int dp[] = new int[n];
        if(n==0)
            return 0;
        dp[0] = houses[0];
        dp[1]= Math.max(houses[0], houses[1]);
        for(int i =2; i<n ; i++)
        {
            dp[i] = Math.max(houses[i] + dp[i-2], dp[i-1] );
        }
        
        return dp[n-1];
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i =0; i<n; i++)
        {
        	arr[i] = scan.nextInt();
        }
        System.out.println(maxMoneyLooted(arr));
}
}
