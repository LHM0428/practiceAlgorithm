package baekjoon11051;

import java.util.Scanner;

public class Main {
	static int mod = 10007;
	static int[][] dp = new int[1001][1001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		for(int i=1; i<=N; i++){
			dp[i][0] = 1;
			dp[i][i] = 1;
		}
		
		System.out.println(searchBinomalCoefficient(N, K));
		
	}
	
	private static int searchBinomalCoefficient(int n, int k) {
		if(dp[n][k] > 0) return dp[n][k];
		
		dp[n][k] = (searchBinomalCoefficient(n-1, k-1) + searchBinomalCoefficient(n-1, k))%mod;
		
		return dp[n][k]%mod;
	}
}
