package baekjoon1965;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Scan {
		private StringTokenizer tokenizer;
		private BufferedReader br;

		public Scan() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
	
	public static void main(String[] args) {
		Scan sc = new Scan();
		int N = sc.nextInt();
		
		int boxes[] = new int[1001];
		int dp[] = new int[1001];
		for(int i=1; i<=N; i++){
			boxes[i] =  sc.nextInt();
		}
		
		int max = 0;
		for(int i=1; i<=N; i++){
			dp[i] = 1;
			for(int j=1; j<=i; j++){
				if(boxes[i] > boxes[j] && dp[i] < dp[j]+1){
					dp[i] = dp[j]+1;
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}

































