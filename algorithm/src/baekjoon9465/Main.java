package baekjoon9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Scan{
		private StringTokenizer tokenizer;
		private BufferedReader br;

		public Scan(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next(){
			while(tokenizer == null || !tokenizer.hasMoreTokens()){
				try {
					tokenizer = new StringTokenizer(br.readLine());

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return tokenizer.nextToken();
		}

		public int nextInt(){
			return Integer.parseInt(next());
		}
	}
	static int n;
	static int[][] sticker, result;
	public static void main(String[] args) {
		Scan sc = new Scan();
		int T = sc.nextInt();
		for(int i=0; i<T; i++){
			n = sc.nextInt();
			result = new int[2][n];
			sticker = new int[2][n];
			for(int j=0; j<2; j++){
				for(int k=0; k<n; k++){
					sticker[j][k] = sc.nextInt();
				}
			}
			result[0][0] = sticker[0][0];
			result[1][0] = sticker[1][0];
			result[0][1] = result[1][0]+sticker[0][1];
			result[1][1] = result[0][0]+sticker[1][1];
			for(int k=2; k<n; k++){
				check(k);
			}
			System.out.println(Math.max(result[0][n-1], result[1][n-1]));
			
		}
	}
	private static void check(int j) {
		//System.out.println(i+", "+j+" : "+result);
		int a = sticker[0][j]+result[1][j-1];
		int b = sticker[0][j]+result[1][j-2];
		if(a > b) result[0][j] = a;
		else result[0][j] = b;
		
		a = sticker[1][j]+result[0][j-1];
		b = sticker[1][j]+result[0][j-2];
		if(a > b) result[1][j] = a;
		else result[1][j] = b;
		

	}

}

