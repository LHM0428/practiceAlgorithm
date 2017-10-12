package baekjoon9461;

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
	static long[] list;
	public static void main(String[] args) {
		Scan sc = new Scan();
		int testCase = sc.nextInt();
		int[] tenth = { 0,1,1,1,2,2,3,4,5,7,9 };
		for(int i=0; i<testCase; i++){
			int N = sc.nextInt();
			list = new long[N+1];
			if(N<=10)System.out.println(tenth[N]);
			else{
				for(int j=1; j<=10; j++) list[j] = tenth[j];
				
				for(int j=11; j<=N; j++){
					list[j] = list[j-1]+list[j-5];
				}
				System.out.println(list[N]);
			}
		}
	}
}































