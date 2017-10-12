package baekjoon13460;


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
		public int[] nextRow(int row){
			char[] a = next().toCharArray();
			int[] b = new int[a.length];
			int column = 0;
			for(char c : a){
				if(c =='#')
					b[column++] = WALL;
				else if(c =='.')
					b[column++] = SPACE;
				else if(c == 'R'){
					redPosition[0] = row;
					redPosition[1] = column;
					b[column++] = SPACE;
				}
				else if(c =='B'){
					bluePosition[0] = row;
					bluePosition[1] = column;					
					b[column++] = SPACE;
				}
				else{
					b[column++] = EXIT;
				}
			}
			return b;
		}
	}
	static int numRows, numColumns, result = Integer.MAX_VALUE;;
	static int[][] board;
	
	static int[] redPosition = new int[2];
	static int[] bluePosition = new int[2];
	static int[][][][][] dp = new int[11][11][11][11][11];
	
	static final int WALL = 0;
	static final int SPACE = 1;
	static final int EXIT = 7;
	static final int LIMIT = 10;
	
	static final int LEFT = 0;
	static final int RIGHT = 1;
	static final int UP = 2;
	static final int DOWN = 3;
	
	static final int KEEP = 0;
	static final int SUCCESS = 1;
	static final int FAIL = 2;
	
	static int check = KEEP;
	static final int MAX = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scan sc = new Scan();
		numRows = sc.nextInt();
		numColumns = sc.nextInt();
		
		board = new int[numRows][numColumns];
		
		for(int i=0; i<numRows; i++)
			board[i] = sc.nextRow(i);
		
		dfs(redPosition[0], redPosition[1], bluePosition[0], bluePosition[1],  0);
		
		
		if(dp[redPosition[0]][redPosition[1]][bluePosition[0]][bluePosition[1]][0]>LIMIT)
			System.out.println(-1);
		else
			System.out.println(dp[redPosition[0]][redPosition[1]][bluePosition[0]][bluePosition[1]][0]);
	}

	private static int dfs(int redRow, int redCol, int blueRow, int blueCol, int cnt) {
		int temp = MAX;
		
		if(dp[redRow][redCol][blueRow][blueCol][cnt] > 0){
			
			return dp[redRow][redCol][blueRow][blueCol][cnt];
		}
		
		if(cnt >= 10){
			
			return dp[redRow][redCol][blueRow][blueCol][cnt] = MAX;
		}
		
		for(int direction=0; direction<4; direction++){
			
			Position p = start(redRow, redCol, blueRow, blueCol, direction);
			
			if(check > KEEP) {
				
				if(check == SUCCESS){
					
					check = KEEP;
					dp[p.redRow][p.redCol][p.blueRow][p.blueCol][cnt+1] = cnt + 1;
					
					return dp[redRow][redCol][blueRow][blueCol][cnt] = cnt + 1;
				} else {
					
					check = KEEP;
					
					dp[p.redRow][p.redCol][p.blueRow][p.blueCol][cnt+1] = MAX;
					continue;
				}
			}
			
			temp = Math.min(temp, dfs(p.redRow, p.redCol, p.blueRow, p.blueCol, cnt+1));
		}
		
		return dp[redRow][redCol][blueRow][blueCol][cnt] = temp;
	}
	
	
	private static Position start(int redRow, int redCol, int blueRow, int blueCol, int direction) {
		
		Position startPosition = new Position(redRow, redCol, blueRow, blueCol);
		
		switch(direction){
		
			case LEFT :
				
				while(board[redRow][redCol-1] != WALL){
					redCol--;
					
					if(board[redRow][redCol] == EXIT){
						check = check > KEEP ? check : SUCCESS;
						break;
					}
				}
				
				while(board[blueRow][blueCol-1] != WALL){
					blueCol--;
					
					if(board[blueRow][blueCol] == EXIT){
						check = FAIL;
						break;
					}
				}
				
				if(check == KEEP && redRow == blueRow && redCol == blueCol){
					if(startPosition.redCol > startPosition.blueCol)
						redCol++;
					else
						blueCol++;
				}
				break;
				
			case RIGHT :
				
				while(board[redRow][redCol+1] != WALL){
					redCol++;
					
					if(board[redRow][redCol] == EXIT){
						check = check > KEEP ? check : SUCCESS;
						break;
					}
				}
				
				while(board[blueRow][blueCol+1] != WALL){
					blueCol++;
					
					if(board[blueRow][blueCol] == EXIT){
						check = FAIL;
						break;
					}
				}
				
				if(check == KEEP && redRow == blueRow && redCol == blueCol){
					if(startPosition.redCol > startPosition.blueCol)
						redCol--;
					else
						blueCol--;
				}
				break;
				
			case UP :
				
				while(board[redRow-1][redCol] != WALL){
					redRow--;
					
					if(board[redRow][redCol] == EXIT){
						check = check > KEEP ? check : SUCCESS;
						break;
					}
				}
				
				while(board[blueRow-1][blueCol] != WALL){
					blueRow--;
					
					if(board[blueRow][blueCol] == EXIT){
						check = FAIL;
						break;
					}
				}
				
				if(check == KEEP && redRow == blueRow && redCol == blueCol){
					if(startPosition.redRow > startPosition.blueRow)
						redRow++;
					else
						blueRow++;
				}
				break;
				
			case DOWN :
				while(board[redRow+1][redCol] != WALL){
					redRow++;
					
					if(board[redRow][redCol] == EXIT){
						check = check > KEEP ? check : SUCCESS;
						break;
					}
				}
				
				while(board[blueRow+1][blueCol] != WALL){
					blueRow++;
					
					if(board[blueRow][blueCol] == EXIT){
						check = FAIL;
						break;
					}
				}
				
				if(check == KEEP && redRow == blueRow && redCol == blueCol){
					if(startPosition.redRow > startPosition.blueRow)
						redRow--;
					else
						blueRow--;
				}
				break;
				
		
		}
		return new Position(redRow, redCol, blueRow, blueCol);
	}
	
	static class Position{
		int redRow, redCol, blueRow, blueCol;

		public Position(int redRow, int redCol, int blueRow, int blueCol) {
			this.redRow = redRow;
			this.redCol = redCol;
			this.blueRow = blueRow;
			this.blueCol = blueCol;
		}
		
	}
}













