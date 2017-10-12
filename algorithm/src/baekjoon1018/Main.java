package baekjoon1018;

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

		public int[] nextBlock() {
			char[] blocks = next().toCharArray();
			int[] a = new int[blocks.length];
			for(int i=0; i<blocks.length; i++){
				if(blocks[i]=='W')
					a[i] = 1;
				else
					a[i] = 0;
			}
			return a;
		}
		public int nextInt(){
			return Integer.parseInt(next());
		}
	}
	static int numRows, numColumns;
	static int[][] board;
	static int[][] blackChess;
	public static void main(String[] args) {
		Scan sc = new Scan();
		numRows = sc.nextInt();
		numColumns = sc.nextInt();
		board = new int[numRows][numColumns];
		blackChess = new int[8][8];
		for(int i=0; i<numRows; i++){
			int[] block = sc.nextBlock();
			board[i] = block;
		}
		
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				blackChess[i][j] = (i+j)%2;
			}
		}
		
		int result = Integer.MAX_VALUE;
		for(int y=0; y<=numRows-8; y++){
			for(int x=0; x<=numColumns-8; x++){
				int cnt = 0;
				for(int i=0; i<8; i++){
					for(int j=0; j<8; j++){
						if(blackChess[i][j]!=board[i+y][j+x]) cnt++;
					}
				}
				cnt = Math.min(64-cnt, cnt);
				result = Math.min(result, cnt);
			}
		}
		
		System.out.println(result);
		
	}
}




























