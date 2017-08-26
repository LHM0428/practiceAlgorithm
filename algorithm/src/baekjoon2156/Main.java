package baekjoon2156;

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
		int numGlass = sc.nextInt();
		int[] wineLiter = new int[numGlass+1];
		int[] total = new int[numGlass+1];
		for(int i=1; i<= numGlass; i++)
			wineLiter[i] = sc.nextInt();
		for(int i = 1; i<3 && i<=numGlass; i++){
			if(i==1)
				total[i] = wineLiter[1];
			else
				total[i] = wineLiter[i] + wineLiter[i-1];
		}
		for(int i=3; i<=numGlass; i++){
			int max = Math.max(wineLiter[i] + total[i-2], total[i-1]);
			max = Math.max(max, wineLiter[i] + wineLiter[i-1] + total[i-3]);
			total[i] = max;
		}
		System.out.println(total[numGlass]);
	}
}


































