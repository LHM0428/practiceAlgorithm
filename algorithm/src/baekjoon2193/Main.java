package baekjoon2193;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		long[]sum = new long[91];
		sum[1] = 1;
		sum[2] = 1;
		for(int i=3; i<=num; i++){
			sum[i] = sum[i-1]+sum[i-2];
		}
		System.out.println(sum[num]);
	}
}
