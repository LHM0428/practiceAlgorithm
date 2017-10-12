package baekjoon2294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
	static int numCoins;
	static int[] coins;
	static int[] sum = new int[100001];
	public static void main(String[] args) {
		Scan sc = new Scan();
		
		numCoins = sc.nextInt();
		int result = sc.nextInt();
		
		coins = new int[numCoins+1];
		
		Arrays.fill(sum, 0, 10001, 10001);
		
		for(int i=1; i<=numCoins; i++){
			int value = sc.nextInt();
			coins[i] = value;
			sum[value] = 1;
		}
		
		for(int i=1; i<=result; i++){
			for(int j=1; j<=numCoins; j++){
				if(i-coins[j] >= 0){
					sum[i] = Math.min(sum[i-coins[j]] + sum[coins[j]], sum[i]);
				}
			}
			//System.out.println("sum["+i+"] : "+sum[i]);
		}
		
		System.out.println(sum[result] > 10000 ? -1 : sum[result]);
	}
}






















