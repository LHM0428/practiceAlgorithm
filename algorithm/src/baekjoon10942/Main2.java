package baekjoon10942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
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
	
	public static void main(String[] args) {

		Scan sc = new Scan();
		
		int N = sc.nextInt();
		int[] numbers = new int[N+1];
		int[][] pelindrome = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++){
			numbers[i] = sc.nextInt();
			pelindrome[i][i] = 1;
			if(numbers[i-1] == numbers[i])
				pelindrome[i-1][i] = 1;
		}
		
		for(int i=2; i<=N; i++){
			for(int j=i+1; j<=N; j++){
				if(numbers[j-i] == numbers[j] && pelindrome[j-i+1][j-1] > 0){
					pelindrome[j-i][j] = 1;
				}
			}
		}
		int M = sc.nextInt();
		
		
		for(int i=1; i<=M; i++){
			System.out.println(pelindrome[sc.nextInt()][sc.nextInt()]);
		}
		
	}
}








































