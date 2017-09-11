package baekjoon1012;

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
		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
	static int h;
	static int v;
	static int numWorms;
	public static void main(String[] args) {
		Scan sc = new Scan();
		int testCase = sc.nextInt();
		for(int i=0; i<testCase; i++){
			h = sc.nextInt();
			v = sc.nextInt();
			int[][] cabbageFarm = new int[h][v];
			int[][] checkFarm = new int[h][v];
			int numCabbages = sc.nextInt();
			numWorms = 0;
			for(int j=0; j<numCabbages; j++){
				cabbageFarm[sc.nextInt()][sc.nextInt()] = 1;
			}
			for(int j=0; j<h; j++){
				for(int k=0; k<v; k++){
					checkWorm(j, k, cabbageFarm, checkFarm, false);
				}
			}
			System.out.println(numWorms);
		}
	}
	private static void checkWorm(int j, int k, int[][] cabbageFarm, int[][] checkFarm, boolean isPreCountWorm) {
		if(checkFarm[j][k] == 0 && cabbageFarm[j][k] == 1){
			checkFarm[j][k] = 1;
			if(!isPreCountWorm) numWorms++;
			if(j+1 < h) checkWorm(j+1, k, cabbageFarm, checkFarm, true);
			if(k+1 < v) checkWorm(j, k+1, cabbageFarm, checkFarm, true);
			if(j-1 >= 0) checkWorm(j-1, k, cabbageFarm, checkFarm, true);
			if(k-1 >= 0) checkWorm(j, k-1, cabbageFarm, checkFarm, true);
		}
	}
}














