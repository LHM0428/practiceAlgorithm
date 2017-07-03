package baekjoon11399;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numPerson = scan.nextInt();
		int[] arrTimes = new int[numPerson];
		for(int i=0; i<numPerson; i++){
			arrTimes[i] = scan.nextInt();
		}
		
		Arrays.sort(arrTimes);
		int[] arrSum = arrTimes;
		int totalSum = arrTimes[0];
		for(int i=1; i<numPerson; i++){
			arrSum[i] += arrSum[i-1];
			totalSum += arrSum[i];
		}
		System.out.println(totalSum);
		
	}
}
