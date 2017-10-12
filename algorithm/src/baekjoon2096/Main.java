package baekjoon2096;

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
	public static void main(String[] args) {
		Scan sc = new Scan();
		
		N = sc.nextInt();
		
		int[] board = new int[3];
		int[] dpMax = new int[3];
		int[] dpMin = new int[3];
		int[] tempMax = new int[3];
		int[] tempMin = new int[3];
		
		for(int j=0; j<3; j++){
			int a = sc.nextInt();
			dpMax[j] = a;
			dpMin[j] = a;
		}
		
		for(int i=1; i<N; i++){
			for(int j=0; j<3; j++) 	{
				board[j] = sc.nextInt();
			}
			
			Arrays.fill(tempMax, 0, 3, 0);
			Arrays.fill(tempMin, 0, 3, 1000000);
			
			for(int column=0; column<3; column++){
				
				switch(column){
					case 0:
						for(int j=0; j<2; j++){
							tempMax[column] = Math.max(tempMax[column], dpMax[j]+board[column]);
							tempMin[column] = Math.min(tempMin[column], dpMin[j]+board[column]);
						}
						break;
						
					case 1:
						
						for(int j=0; j<3; j++){
							tempMax[column] = Math.max(tempMax[column], dpMax[j]+board[column]);
							tempMin[column] = Math.min(tempMin[column], dpMin[j]+board[column]);
						}
						break;
						
					case 2:
						
						for(int j=1; j<3; j++){
							tempMax[column] = Math.max(tempMax[column], dpMax[j]+board[column]);
							tempMin[column] = Math.min(tempMin[column], dpMin[j]+board[column]);
						}
						break;
				}
				
			}
			for(int k=0; k<3; k++){
				dpMax[k] = tempMax[k];
				dpMin[k] = tempMin[k];
			}
		}
		int max = Math.max(dpMax[0], Math.max(dpMax[1], dpMax[2]));
		int min = Math.min(dpMin[0], Math.min(dpMin[1], dpMin[2]));
		
		System.out.println(max + " " + min);
	}
}

























