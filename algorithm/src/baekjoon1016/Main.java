package baekjoon1016;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		long min = sc.nextLong();
		long max = sc.nextLong();
		int numOfnumbers = (int) (max - min + 1);
		long[] dividers = new long[1000002];
		int numOfDivder = 0;
		for(long j=2; j*j<=max; j++){
			dividers[numOfDivder] = j;
			numOfDivder++;
		}
		int cnt = 0;
		boolean[] result = new boolean[1000002];
		for(int j=0; j<numOfDivder; j++){
			long divider = dividers[j]*dividers[j];
			long dmin = min;
			if(min%divider != 0){
				dmin = (min/divider+1)*divider;
			}
			for(long i=dmin-min; i<numOfnumbers; i+=divider){
				if(!result[(int)(i)]){
					result[(int)(i)] = true;
					cnt++;
				}
			}
		}
		System.out.println(numOfnumbers-cnt);
	}
}
