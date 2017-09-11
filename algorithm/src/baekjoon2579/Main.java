package baekjoon2579;

import java.io.BufferedReader;
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
				try{
					tokenizer = new StringTokenizer(br.readLine());
				} catch (Exception e){
					e.printStackTrace();
				}
			}
			return tokenizer.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
	public static void main(String[] args) {
		Scan sc = new Scan();
		int numStairs = sc.nextInt();
		int stairs[] = new int[numStairs+2];
		int score[] = new int[numStairs+2];
		for(int i=1; i<=numStairs; i++)
			stairs[i] = sc.nextInt();
		
		score[1] = stairs[1];
		score[2] = stairs[2]+stairs[1];
		for(int i=3; i<=numStairs; i++){
			if(stairs[i-1]+stairs[i]+score[i-3]>stairs[i]+score[i-2]){
				score[i] = stairs[i-1]+stairs[i]+score[i-3];
			}else{
				score[i] = stairs[i]+score[i-2];
			}
			//System.out.println(i+" : "+score[i]);
		}
		System.out.println(score[numStairs]);
	}
}

















































