package baekjoon1912;

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
		int length = sc.nextInt();
		int[] numbers = new int[length+1];
		int[] sum = new int[length+1];
		for(int i=1; i<=length; i++)
			numbers[i] = sc.nextInt();
		
		for(int i=1; i<=length; i++){
			if(sum[i-1]+numbers[i] > numbers[i])
				sum[i] = sum[i-1]+numbers[i];
			else
				sum[i] = numbers[i];
		}
		int max = sum[1];
		for(int i=2; i<=length; i++)
			max = Math.max(max, sum[i]);
		System.out.println(max);
	}
}






































