package baekjoon2565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
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
	
	static int N;
	static Line[] lines;
	public static void main(String[] args) {
		Scan sc = new Scan();
		N = sc.nextInt();
		
		lines = new Line[N];
		int[] dp = new int[N+1];
		for(int i=0; i<N; i++){
			lines[i] = new Line(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(lines, new Comparator<Line>() {

			@Override
			public int compare(Line o1, Line o2) {
				if(o1.from>o2.from) return 1;
				return -1;
			}
			
		});
		for(Line a : lines)
		System.out.print(a.to);
		System.out.println();
		int max = 0;
		for(int i=0; i<N; i++){
			int pre = lines[i].to;
			dp[i] = 1;
			for(int j=0; j<=i; j++){
				if(pre > lines[j].to && dp[i] < dp[j]+1){
					dp[i] = dp[j]+1;
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(N-max);
	}
	
	static class Line{
		int from, to;

		public Line(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}
}
