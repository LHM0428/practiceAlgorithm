package baekjoon9251;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] a = sc.nextLine().toCharArray();
		char[] b = sc.nextLine().toCharArray();
		
		int[][] dp = new int[1001][1001];
		
		for(int i=0; i<a.length; i++){
			for(int j=0; j<b.length; j++){
					dp[i+1][j+1] = a[i] == b[j] ? dp[i][j] + 1 : Math.max(dp[i][j+1], dp[i+1][j]);
			}
		}
		
		System.out.println(dp[a.length][b.length]);
	}
}
