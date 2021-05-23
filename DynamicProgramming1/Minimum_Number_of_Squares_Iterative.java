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

public class Minimum_Number_of_Squares_Iterative {

	public static int minCountDP(int n) {
		int[] storage  = new int[n+1];
		storage[0]=0;
		storage[1] =1;
		for(int i=2;i<=n;i++) {
			int min = Integer.MAX_VALUE;
			for(int j=1;j<=Math.sqrt(i);j++) {
				int count = storage[i-(j*j)];
				if(min > count) {
					min = count;
				}
				
			}
			storage[i] = min + 1;
			
		}
		return storage[n];
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(minCountDP(n));
	}
}
