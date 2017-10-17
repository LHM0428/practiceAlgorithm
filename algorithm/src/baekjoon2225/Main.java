package baekjoon2225;

import java.util.Scanner;

public class Main {
	static long mod = 1000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		long[][] dp = new long[201][201];
		for(int i=0; i<=N; i++){
			for(int j=0; j<=K; j++)
				dp[i][j] = 0;
		}
		
		System.out.println(start(N, K, dp));
	}

	private static long  start(int n, int k, long[][] dp) {
		
		if(k == 0){
			if(n==0) return 1;
			return 0;
		}
		
		if(dp[n][k] > 0 ) return dp[n][k];
		
		for(int i=0; i<=n; i++){
			dp[n][k] += start( n-i , k-1, dp) % mod;
		}
		
		return dp[n][k]%mod;
	}
}
