package baekjoon11722;

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
		int[] length = new int[l+1];
		int max = 0;
		for(int i=1;i<=l;i++)
			numbers[i] = sc.nextInt();
		
		for(int i=1; i<=l; i++){
			int num = numbers[i];
			int min = 0;
			for(int j=1; j<i; j++){
				if(num < numbers[j]){
					//System.out.println("min : "+min+", number["+j+"] : "+numbers[j]+", num :"+num);
					if(min < length[j]) min = length[j];
				}
			}
			length[i] = min + 1;
			//System.out.println(length[i]);
			if( max < length[i] ) max = length[i];
		}
		System.out.println(max);
	}
}



























