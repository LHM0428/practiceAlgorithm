package baekjoon1010;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	static int west, east;
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int t = sc.nextInt();
		for(int i=0; i<t; i++){
			west = sc.nextInt();
			east = sc.nextInt();
			double a = 1;
			double b = 1;
			double c = 1;
			for(int j=1; j<=west; j++){
				a = a*j;
			}
			for(int j=1; j<=(east-west); j++){
				b = b*j;
			}
			for(int j=1; j<=east; j++){
				c = c*j;
			}
			System.out.println(Math.round(c/(a*b)));
		}
	}
}
