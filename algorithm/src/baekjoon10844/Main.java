package baekjoon10844;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int length = sc.nextInt();
		int[][] number = new int[10][length+1];
		int divider = 1000000000;
		for(int i=1; i<=9; i++){
			number[i][1] = 1;
		}
		for(int i=2; i<=length; i++){
			for(int j=0; j<=9; j++){
				int a = 0;
				if(j-1 >= 0) a += number[j-1][i-1];
				if(j+1 <= 9) a += number[j+1][i-1];
				
				number[j][i] = a%divider;
			}
		}
		int result = 0;
		for(int i=0; i<=9; i++){
			result = (result+number[i][length])%divider;
		}
		System.out.println(result);
	}
}
