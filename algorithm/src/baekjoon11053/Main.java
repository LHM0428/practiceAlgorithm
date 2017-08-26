package baekjoon11053;

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
		int size = sc.nextInt();
		int[] numbers = new int[size+1];
		int[] length = new int[size+1];
		for(int i=1; i<=size; i++)
			numbers[i] = sc.nextInt();
		
		int max = 0;
		for(int i=1; i<=size; i++){
			int num = numbers[i];
			int min = 0;
			for(int j=0; j<i; j++){
				if(num > numbers[j]){
					if(length[j] > min)
						min = length[j];
				}
			}
			length[i] = min + 1;
			if(max < length[i]) max = length[i];
		}
		System.out.println(max);
	}
}




















