package baekjoon6064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
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

	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testNum = sc.nextInt();
		for (int i = 0; i < testNum; i++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int lcm = M * N / gcd(M, N);

			int x = sc.nextInt();
			int y = sc.nextInt();

			int result = -1;
			int times = lcm / M;
			for (int j = 0; j < times; j++) {

				int checkY = (x + j * M) % N;
				if(checkY == 0 ) checkY=N;
				if (checkY == y) {
					result = x + j * M;
					System.out.println(result);
					break;
				}
			}
			if (result == -1)
				System.out.println(result);
		}
	}
}
