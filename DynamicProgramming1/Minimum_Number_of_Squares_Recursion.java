//Given an integer N, find and return the count of minimum numbers required to represent N as a sum of squares.
//That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}. The output will be 1, as 1 is the minimum count of numbers required to represent N as sum of squares.
//
//Input format :
//The first and the only line of input contains an integer value, 'N'.
//
//Output format :
//Print the minimum count of numbers required.

package DynamicProgramming1;

import java.util.Scanner;

public class Minimum_Number_of_Squares_Recursion {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(minCount(n));
	}

	public static int minCount(int n) {

		if(n==1) {
			return 1;
		}
		if(n==0) {
			return 0;
		}
		int min =Integer.MAX_VALUE;
		for(int i=1;i<=Math.sqrt(n);i++) {

			int count = minCount( n - (i*i));
			if(min > count ) {
				min = count;
			}

		}
		return min + 1;

	}
	
}
