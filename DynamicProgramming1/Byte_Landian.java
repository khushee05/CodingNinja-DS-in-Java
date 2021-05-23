//Byteland has a very strange monetary system.
//Each Bytelandian gold coin has an integer number written on it. A coin n can be exchanged in a bank into three coins: n/2, n/3 and n/4. But these numbers are all rounded down (the banks have to make a profit).
//You can also sell Bytelandian coins for American dollars. The exchange rate is 1:1. But you can not buy Bytelandian coins.
//You have one gold coin. What is the maximum amount of American dollars you can get for it?
//
//
//Input format :
//The first and the only line of input contains a the integer value of 'n'. It is the number written on your coin.
//
//Output format :
//Print the the maximum amount of American dollars you can make.
//


package DynamicProgramming1;

import java.util.*;

public class Byte_Landian{

	public static long bytelandian(long n, HashMap<Long, Long> memo) {
		// Write your code here
		if(n== 0)
			return 0;
		if(memo.containsKey(n))
			return memo.get(n);
		else
		{
			long ans = Math.max(n, bytelandian(n/2,memo)+bytelandian(n/3,memo)+bytelandian(n/4,memo));
			memo.put(n,ans);
		}

		return memo.get(n);

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong();
		HashMap<Long,Long>map = new HashMap<>();
		System.out.println(bytelandian(n,map));
	}

}
