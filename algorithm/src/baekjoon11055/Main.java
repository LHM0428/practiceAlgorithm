package baekjoon11055;

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
		int length = sc.nextInt();
		int[] numbers = new int[length+1];
		int[] sumArr = new int[length+1];
		int max = 0;
		for(int i=1; i<=length; i++)
			numbers[i] = sc.nextInt();
		
		for(int i=1; i<=length; i++){
			int num = numbers[i];
			for(int j=0; j<i; j++){
				if(num > numbers[j]){
					if(num+sumArr[j] > sumArr[i])
						sumArr[i] = num + sumArr[j];
				}
			}
			if(max < sumArr[i]) max = sumArr[i];
		}
		System.out.println(max);
		
	}
}



























