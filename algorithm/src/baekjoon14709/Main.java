package baekjoon14709;

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
	static boolean[][] finger;
	static String SUCCESSE = "Wa-pa-pa-pa-pa-pa-pow!";
	static String FAIL = "Woof-meow-tweet-squeek";
	public static void main(String[] args) {
		Scan sc = new Scan();
		int N = sc.nextInt();
		finger = new boolean[6][6];
		for(int i=0; i<N; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			finger[a][b] = true;
			finger[b][a] = true;
		}
		String result = SUCCESSE;
		if(finger[1][3] && finger[1][4] && finger[3][4]){
			for(int i=1; i<=5; i++){
				if(finger[2][i] || finger[5][i]){
					result = FAIL;
					break;
				}
			}
		}else{
			result = FAIL;
		}
		System.out.println(result);
	}
}

























