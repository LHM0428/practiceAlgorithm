package baekjoon1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
	static int num, result;
	static int[][] applicants;
	static ArrayList<Integer> list;
	public static void main(String[] args) {
		Scan sc = new Scan();
		int testCase = sc.nextInt();
		for(int i=0; i<testCase; i++){
			num = sc.nextInt();
			applicants = new int[num][2];
			result = 1;
			list = new ArrayList<>();
			for(int j=0; j<num; j++){
				applicants[j][0] = sc.nextInt();
				applicants[j][1] = sc.nextInt();
			}
			Arrays.sort(applicants, new Comparator<int []>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[0] > o2[0]) return 1;
					else return -1;
				}
			});
			if(applicants[0][1] == 1)
				System.out.println(result);
			else{
				firstCheck();
				System.out.println(result);
			}
		}
	}
	private static void firstCheck() {
		for(int i=1; i<num; i++){
			if(applicants[0][1] > applicants[i][1]){
				result++;
				list.add(i);
			}
		}
		check();
	}
	private static void check() {
		while(list.size()>1){
			int first = list.get(0);
			list.remove(0);
			for(int i=0; i<list.size(); i++){
				int a = list.get(i);
				if(applicants[first][1] < applicants[a][0]){
					result--;
					list.remove(i);
				}
			}
		}
	}
}
