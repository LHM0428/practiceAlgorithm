package baekjoon11057;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[][] num = new int[length][10];
		for(int i=0; i<10; i++){
			num[0][i] = 1;
		}
		for(int i=1; i<length; i++){
			for(int j=0; j<10; j++){
				for(int k=j; k<10; k++)
				num[i][j] = (num[i][j]+num[i-1][k])%10007;
			}
		}
		int result = 0;
		for(int i=0; i<10; i++){
			result += num[length-1][i];
		}
		System.out.println(result%10007);
	}
}
