package baekjoon1699;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int num = sc.nextInt();
		int sum[] = new int[num+1];
		for(int i=1; i<=num; i++){
			for(int j=1; j*j<=i; j++){
				if(sum[i] > sum[i-j*j]+1 || sum[i] == 0)
					sum[i] = sum[i-j*j]+1;
			}
		}
		System.out.println(sum[num]);
	}
}
