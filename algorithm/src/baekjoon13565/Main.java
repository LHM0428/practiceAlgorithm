package baekjoon13565;

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
		public int[] nextRow(){
			char[] a = next().toCharArray();
			int[] b = new int[a.length];
			int i = 0;
			for(char c : a){
				b[i++] = c - '0';
			}
			return b;
		}
	}
	static int[][] board;
	static boolean[][] isVisited;
	static int numRows, numColumns;
	public static void main(String[] args) {
		Scan sc = new Scan();
		numRows = sc.nextInt();
		numColumns = sc.nextInt();
		board = new int[numRows][numColumns];
		isVisited = new boolean[numRows][numColumns];
		for(int i=0; i<numRows; i++){
			board[i] = sc.nextRow();
		}
		int result = 0;
		for(int column=0; column<numColumns; column++){
			result += check(0, column);
		}
		if(result>0) System.out.println("YES");
		else System.out.println("NO");
	}
	private static int check(int row, int column) {
		if(row==numRows-1) return 1;
		if(isVisited[row][column] || board[row][column] == 1) return 0;
		isVisited[row][column] = true;
		int result = 0;
		if(row>0) result += check(row-1, column);
		if(row+1<numRows) result += check(row+1, column);
		if(column>0) result += check(row, column-1);
		if(column+1<numColumns) result += check(row, column+1);
		
		
		return result;
	}
}
