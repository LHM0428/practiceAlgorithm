package baekjoon10942;

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
	
	public static void main(String[] args) {

		Scan sc = new Scan();
		
		int N = sc.nextInt();
		int[] numbers = new int[N+1];
		int[][] pelindrome = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++){
			numbers[i] = sc.nextInt();
			pelindrome[i][1] = 1;
			if(numbers[i-1] == numbers[i])
				pelindrome[i-1][i] = 1;
		}
		
		for(int i=1; i<N-1; i++){
			if(numbers[i] == numbers[i+1])
				pelindrome[i][2] = 1;
			if(numbers[i] == numbers[i+2])
				pelindrome[i][3] = 1;
		}
		
		if(numbers[N-1]==numbers[N]) pelindrome[N-1][2] = 1;
		
			
		for(int length=4; length<=N; length+=2){
			
			for(int i=1; i+length-1<=N; i++){
				if(numbers[i]==numbers[i+length-1] && pelindrome[i+1][length-2] > 0)
					pelindrome[i][length] = 1;
			}
			
		}
			
		for(int length=5; length<=N; length+=2){
			
			for(int i=1; i+length-1<=N; i++){
				//System.out.println("number["+i+"]"+" : "+"number["+(i+length-1)+"] - "+numbers[i]+" , " + numbers[i+length-1]+"//"+pelindrome[i+1][length-2]);
				if(numbers[i]==numbers[i+length-1] && pelindrome[i+1][length-2] > 0){
					pelindrome[i][length] = 1;
				}
			}
			
		}
		int M = sc.nextInt();
		
		
		for(int i=1; i<=M; i++){
			int startPosition = sc.nextInt();
			int length = sc.nextInt() - startPosition + 1;
			System.out.println(pelindrome[startPosition][length]);
		}
		
	}
}








































