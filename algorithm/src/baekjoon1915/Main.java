package baekjoon1915;

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
			char[] arr = next().toCharArray();
			int[] intArr = new int[arr.length];
			for(int i=0; i<arr.length; i++){
				intArr[i] = arr[i] - '0';
			}
			return intArr;
		}
	}
	static int rowNum, colNum;
	static int board[][] = new int[1001][1001];
	static int max = 0;
	public static void main(String[] args) {
		
		Scan sc = new Scan();
		rowNum = sc.nextInt();
		colNum = sc.nextInt();
		
		
		
		for(int i=0; i<rowNum; i++){
			
			board[i] = sc.nextRow();
			
			for(int j=0; j<colNum; j++){
				
				if(board[i][j] == 0 ) continue;
				
				if(i > 0 && j > 0){
					if(board[i-1][j-1] > 0 && board[i][j-1] > 0 && board[i-1][j] > 0)
						board[i][j] = Math.min(board[i-1][j-1], Math.min(board[i][j-1], board[i-1][j]))+1;
				}
				
				max = max < board[i][j] ? board[i][j] : max;
			}
		}
		
		System.out.println(max*max);
	}
}


















