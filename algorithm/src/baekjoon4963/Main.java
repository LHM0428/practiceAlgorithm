package baekjoon4963;

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

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
	static int[][] map;
	static boolean[][] isVisited;
	public static void main(String[] args) {
		Scan sc = new Scan();
		int w = sc.nextInt();
		int h = sc.nextInt();
		while(w+h>0){
			int result = 0;
			map = new int[h][w];
			isVisited = new boolean[h][w];
			for(int i=0; i<h; i++){
				for(int j=0; j<w; j++){
					map[i][j] = sc.nextInt();
				}
			}
			for(int i=0; i<h; i++){
				for(int j=0; j<w; j++){
					if(!isVisited[i][j] && map[i][j] == 1){
						check(i, j, w, h);
						result++;
					}
				}
			}
			System.out.println(result);
			w = sc.nextInt();
			h = sc.nextInt();
		}
	}
	private static void check(int i, int j, int w, int h) {
		if(isVisited[i][j]) return;
		isVisited[i][j] = true;
		if(map[i][j] == 1){
			if(i+1 < h) {
				check(i+1, j, w, h);
				if(j+1 < w)	check(i+1, j+1, w, h);
				if(j > 0) check(i+1, j-1, w, h);
			}
			if(i > 0) {
				check(i-1, j, w, h);
				if(j+1 < w)	check(i-1, j+1, w, h);
				if(j > 0) check(i-1, j-1, w, h);
			}
			if(j+1 < w) {
				check(i, j+1, w, h);
				if(i+1 < h) check(i+1, j+1, w, h);
				if(i > 0) check(i-1, j+1, w, h);
			}
			if(j > 0){
				check(i, j-1, w, h);
				if(i+1 < h) check(i+1, j-1, w, h);
				if(i > 0) check(i-1, j-1, w, h);
			}
		}
	}
}






























