package baekjoon14734;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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

		public Block[] nextRaw(int row) {
			char[] rowChar = next().toCharArray();
			Block intArr[] = new Block[rowChar.length];
			for(char c : rowChar){
				int i=0;
				switch(c){
				case '.':
					intArr[i] = new Block(row, i+1, SPACE);
					i++;
					break;
				case 'U':
				case 'D':
					intArr[i] = new Block(row, i+1, VERTICAL);;
					i++;
					break;
				case 'L':
				case 'R':
					intArr[i] = new Block(row, i+1, HORIZONTAL);
					i++;
					break;
				}
			}
			return intArr;
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
	
	static final int SPACE = -1;
	static final int VERTICAL = 1;
	static final int HORIZONTAL = 2;
	
	static Block[][] board = new Block[201][201];
	static int N;
	static ArrayList<Block> result = new ArrayList<>();
	static Queue<Block> temp = new LinkedList<>();
	public static void main(String[] args) {
		Scan sc = new Scan();
		N = sc.nextInt();
		for(int i=1; i<=N; i++){
			board[i] = sc.nextRaw(i);
		}
		
		check(board[1][1]);
	}

	private static void check(Block b) {
		int block = b.block;
		int row = b.row;
		int col = b.col;
		
		if(block > 1){
			if(row < N && doubleCheck(board[row+1][col])){
				result.add(b);
				board[row][col] = new Block(row, col, VERTICAL);
				board[row][col+1] = new Block(row, col+1, VERTICAL);
				board[row+1][col] = new Block(row+1, col, VERTICAL);
				board[row+1][col] = new Block(row+1, col+1, VERTICAL);
			}else if(row > 0 && doubleCheck(board[row-1][col])){
				result.add(b);
				board[row][col] = new Block(row, col, VERTICAL);
				board[row][col+1] = new Block(row, col+1, VERTICAL);
				board[row-1][col] = new Block(row-1, col, VERTICAL);
				board[row-1][col+1] = new Block(row-1, col+1, VERTICAL);
			}else{
				temp.add(b);
			}
		}
		
		if(col < N)
			check(board[row][col+1]);
		else
			check(board[row+1][1]);
		
	}
	
	private static boolean doubleCheck(Block block) {
		if(block.block > 1) return true;
		return false;
	}

	static class Block{
		int row, col, block;

		public Block(int row, int col, int block) {
			this.row = row;
			this.col = col;
			this.block = block;
		}
		
	}
}







































