package baekjoon11052;

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
	public static void main(String[] args) throws Exception {
		Scan sc = new Scan();
		int n = sc.nextInt();
		int[] p = new int[n+1];
		int[] total = new int[n+1];
		for(int i=1; i<=n; i++){
			p[i] = sc.nextInt();
		}
		for(int i = 1; i <= n; i++){
			for(int j=1; j<=n; j++){
				if(i <= j)
					total[j] = total[j] > total[j-i] + p[i] ? total[j] : total[j-i]+p[i];
			}
		}
		System.out.println(total[n]);
	}
}

