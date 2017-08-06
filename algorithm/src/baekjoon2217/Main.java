package baekjoon2217;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numRope = sc.nextInt();
		int[] weight = new int[numRope+1];
		for(int i=1; i<=numRope; i++){
			weight[i] = sc.nextInt();
		}
		Arrays.sort(weight);
		int totalWeight;
		int max =  weight[numRope];
		for(int i=1; i<numRope; i++){
			totalWeight = weight[i]*(numRope-(i-1));
			if(totalWeight>max) max = totalWeight;
		}
		System.out.println(max);
	}
}
