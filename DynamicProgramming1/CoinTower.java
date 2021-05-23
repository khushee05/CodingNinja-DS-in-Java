//Whis and Beerus are playing a new game today. They form a tower of N coins and make a move in alternate turns.
//Beerus plays first. In one step, the player can remove either 1, X, or Y coins from the tower. 
//The person to make the last move wins the game. Can you find out who wins the game?
//		
//Input format :
//The first and the only line of input contains three integer values separated by a single space. 
//They denote the value of N, X and Y, respectively.
//
//Output format :
//Prints the name of the winner, either 'Whis' or 'Beerus' (Without the quotes).

package DynamicProgramming1;

import java.util.Scanner;

public class CoinTower {

	public static String findWinner(int n, int x, int y) {
		//Your code goes here
        String s1 = "Beerus";
        String s2 = "Whis";
        
        boolean dp[] = new boolean[n+1];
        dp[0] = false;
        dp[1] = true;
        
        for(int i =2; i<dp.length; i++)
        {
            dp[i] = false;
        }
        
        for(int i =2; i<=n; i++)
        {
            if(i-1 >= 0 && dp[i-1]==false )
            {
                dp[i] = true;
            }
           else if(i-x >= 0 && dp[i-x]==false )
            {
                dp[i] = true;
            }
            else if(i-y >= 0 && dp[i-y]==false )
            {
                dp[i] = true;
            }
            else
                dp[i]=false;
        }
        
        if(dp[n] == false)
            return s2;
        else
            return s1;
	}
	
	public static void main(String srgs[])
	{
		Scanner scan = new Scanner(System.in);
		int n,x,y;
		n = scan.nextInt();
		x = scan.nextInt();
		y = scan.nextInt();
		System.out.print(findWinner(n,x,y));
		
	}
	
	
}
