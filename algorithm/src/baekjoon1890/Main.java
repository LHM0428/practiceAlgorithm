package baekjoon1890;

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
	
	static int N;
	static int board[][] = new int[101][101];
	static long dp[][][] = new long[101][101][2];
	static final int RIGHT = 0;
	static final int DOWN = 1;
	public static void main(String[] args) {
		Scan sc = new Scan();
		
		N = sc.nextInt();
		
		for(int i=1; i<=N; i++){
			for(int j=1; j<=N; j++){
				board[i][j] = sc.nextInt();
			}
		}
		dp[N][N][RIGHT] = 1;
		dp[N][N][DOWN] = 1;
		
		
		go(1,1, board[1][1]);
		System.out.println(dp[1][1][RIGHT]+dp[1][1][DOWN]);
	}
	
	
	private static void go(int row, int col, int go) {
		if(col+go <= N){
			dp[row][col][RIGHT] += goRight(row, col+go, board[row][col+go]);
		}
		
		if(row+go <= N){
			dp[row][col][DOWN] += goDown(row+go, col, board[row+go][col]);
		}
		
	}


	private static long goRight(int row, int col, int go) {
		System.out.println("RIGHT "+row+", "+col+" : "+dp[row][col][RIGHT]);
		if( dp[row][col][RIGHT] > 0 || board[row][col] == 0 ) return dp[row][col][RIGHT];
		
		if(col+go <= N){
			dp[row][col][RIGHT] += goRight(row, col+go, board[row][col+go]);
		}
		
		if(row+go <= N){
			dp[row][col][RIGHT] += goDown(row+go, col, board[row+go][col]);
		}
		
		return dp[row][col][RIGHT];
	}
	
	private static long goDown(int row, int col, int go) {
		System.out.println("DOWN "+row+", "+col+" : "+dp[row][col][DOWN]);
		if( dp[row][col][DOWN] > 0 || board[row][col] == 0 ) return dp[row][col][DOWN];
		
		if(row+go <= N){
			dp[row][col][DOWN] += goDown(row+go, col, board[row+go][col]);
		}
		
		if(col+go <= N){
			dp[row][col][DOWN] += goRight(row, col+go, board[row][col+go]);
		}
		
		return dp[row][col][DOWN];
	}
}


































