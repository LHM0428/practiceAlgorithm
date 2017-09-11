package baekjoon1007;
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
	static double[][] point;
	static int numPoints;
	public static void main(String[] args) {
		Scan sc = new Scan();
		int testCase = sc.nextInt();
		for (int i = 0; i < testCase; i++) {
			numPoints = sc.nextInt();
			 point = new double[numPoints][2];
			for (int j = 0; j < numPoints; j++) {
				point[j][0] = sc.nextDouble();
				point[j][1] = sc.nextDouble();
			}
			System.out.printf("%.6f\n", calc(0, 0, 0, 0));
		}
	}

	private static double calc(int numChoice ,int idx, double sumX, double sumY) {
		if(numChoice > numPoints/2 || numPoints - idx < numPoints/2 - numChoice){
			return Double.MAX_VALUE;
		}else if(numPoints == idx){
			return Math.sqrt(sumX*sumX+sumY*sumY);
		}else{
			return Math.min(calc(numChoice+1, idx+1, sumX+point[idx][0], sumY+point[idx][1]), 
					calc(numChoice, idx+1, sumX-point[idx][0], sumY-point[idx][1]));
		}
	}

}
