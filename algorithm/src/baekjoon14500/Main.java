package baekjoon14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	static int[][] board, value, isVisited;
	static int height, width;
	static int[] dx = { 0, 0, -1 ,1}, dy = {-1, 1, 0, 0};
	public static void main(String[] args) {
		Scan sc = new Scan();
		height = sc.nextInt();
		width = sc.nextInt();
		board = new int[height][width];
		value = new int[height][width];
		isVisited = new int[height][width];
		for(int i=0;i<height;i++)
			for(int j=0; j<width;j++)
				board[i][j] = sc.nextInt();
		
		int result = 0;
		for(int i=0; i<height; i++)
			for(int j=0; j<width; j++){
				result = Math.max(result, dfs(i,j,1));
				result = Math.max(result, exception(i,j,1));
			}
		System.out.println(result);
	}
	private static int exception(int i, int j, int k) {
		int sum = board[i][j];
		boolean[] check = new boolean[4];
		int blockNum = 0;
		for(int l=0; l<4; l++){
			int a = i + dx[l];
			int b = j + dy[l];
			if(check(a,b)){
				sum += board[a][b];
				check[l] = true;
				blockNum++;
			}
		}
		int max = 0;
		if(blockNum==3){
			return sum;
		}
		for(int l=0; l<4; l++){
			if(check[l]){
				int a = i + dx[l];
				int b = j + dy[l];
				max = Math.max(max, sum-board[a][b]);
			}
		}
		return max;
	}
	private static int dfs(int i, int j, int k ) {
		if(k==4) return board[i][j];
		isVisited[i][j] = 1;
		int score = board[i][j];
		int max = 0;
		for(int l=0; l<4; l++){
			int a = i + dx[l];
			int b = j + dy[l];
			if(check(a,b) && isVisited[a][b]==0){
				max = Math.max(max, score+dfs(a,b,k+1));
			}
		}
		//if(k==1)System.out.println(max);
		isVisited[i][j] = 0;
		return max;
	}
	private static boolean check(int i, int j) {
		return i>-1 && j>-1 && i<height && j<width;
	}
}































