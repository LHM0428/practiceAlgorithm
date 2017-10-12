package baekjoon2133;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	static int[] sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int N = sc.nextInt();
		sum = new int[31];
		sum[0] = 1;
		sum[2] = 3;
		for(int i=4; i<=N; i+=2){
			sum[i] = sum[i-2]*3;
			for(int j=4;j<=i; j+=2)
				sum[i] += 2*sum[i-j];
			
		}
		
		System.out.println(sum[N]);
	}
}
