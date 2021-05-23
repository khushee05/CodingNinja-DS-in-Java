//Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to get reduced to 1. You can perform any one of the following 3 steps:
//1.) Subtract 1 from it. (n = n - ­1) ,
//2.) If n is divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
//3.) If n is divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).  
//
//Input format :
//The first and the only line of input contains an integer value, 'n'.
//
//Output format :
//Print the minimum number of steps.

package DynamicProgramming1;

import java.util.Scanner;

public class Min_Steps_to_one_Using_DP {

	public static int countMinStepsToOne(int n) {

		int storage[] = new int[n+1];
		for(int i = 2 ; i <= n ; i++ ){
			int min = storage[i-1];
			if( i%3 == 0 && min > storage[i/3] ) min = storage[i/3];
			if( i%2 == 0 && min > storage[i/2] ) min = storage[i/2];
			storage[i] = min + 1;
		}
		return storage[n];
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(countMinStepsToOne(n));
	}
}
