package baekjoon2293;

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
	static int numCoins;
	static int[] coins;
	static int[] sum = new int[10001];
	public static void main(String[] args) {
		Scan sc = new Scan();
		
		numCoins = sc.nextInt();
		int result = sc.nextInt();
		
		coins = new int[numCoins+1];
		
		for(int i=1; i<=numCoins; i++){
			coins[i] = sc.nextInt();
		}
		
		//구하고자 하는 sum의 값이 coin의 값과 같을 경우의 수는 sum[0] 이므로 1을 저장
		sum[0] = 1;
		
		for(int i=1; i<=numCoins; i++){
			for(int j=1; j<=result; j++){
				if(j-coins[i] >= 0){
					sum[j] += sum[j-coins[i]];
				}
			}
		}
		
		
		System.out.println(sum[result]);
	}
}


































