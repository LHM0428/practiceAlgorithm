package baekjoon11054;

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
	}

	public static void main(String[] args) {
		Scan sc = new Scan();
		int l = sc.nextInt();
		int[] numbers = new int[l+1];
		int[][] length = new int[l+1][2];
		int max =0;
		
		for(int i=1; i<=l; i++)
			numbers[i] = sc.nextInt();
		
		for(int i=1; i<=l; i++){
			int num = numbers[i];
			int minLeft = 0;
			for(int j=0; j<i; j++){
				if(num > numbers[j])
					if(minLeft < length[j][0]) minLeft = length[j][0];
			}
			length[i][0] = minLeft + 1;
		}
		for(int i=l; i>0; i--){
			int num = numbers[i];
			int minRight = 0;
			for(int k=l; k>i; k--){
				if(num > numbers[k])
					if(minRight < length[k][1]) minRight = length[k][1];
			}
			length[i][1] = minRight + 1;
		}
		for(int i=1; i<=l; i++){
			System.out.println("[" +i+ "] : "+length[i][0]+", "+length[i][1]);
			int temp = length[i][0] + length[i][1];
			if(max < temp) max = temp;
		}
		System.out.println(max-1);
	}
}
































