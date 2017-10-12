package baekjoon1520;

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
	
	static int height, width, cnt=0;
	static int[][] square;
	static int[][] result;
	public static void main(String[] args) {
		Scan sc = new Scan();
		height = sc.nextInt();
		width = sc.nextInt();
		square = new int[height][width];
		result = new int[height][width];
		for(int i=0; i<height; i++)
			for(int j=0; j<width; j++){
				square[i][j] = sc.nextInt();
				result[i][j] = -1;
			}
		
		result[0][0] = 1;
		System.out.println(findRoute(height-1, width-1,  square[height-1][width-1]));
	}
	private static int findRoute(int i, int j, int current) {
		if(result[i][j]!=-1) return result[i][j];
		
		result[i][j] = 0;
		
		if(i+1<height && square[i+1][j] > current){
			result[i][j] += findRoute(i+1, j, square[i+1][j]);
		}
		if(j+1<width && square[i][j+1] > current){
			result[i][j] += findRoute(i, j+1, square[i][j+1]);
		}
		if(i>0 && square[i-1][j] > current){
			result[i][j] += findRoute(i-1, j, square[i-1][j]);
		}
		if(j>0 && square[i][j-1] > current){
			result[i][j] += findRoute(i, j-1, square[i][j-1]);
		}
		
		return result[i][j];
	}
}
