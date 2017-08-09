package baekjoon1049;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numGuitarLine = sc.nextInt();
		int brand = sc.nextInt();
		int[] setPrice = new int[brand];
		int[] individualPrice = new int [brand];
		for(int i=0; i<brand; i++){
			setPrice[i] = sc.nextInt();
			individualPrice[i] = sc.nextInt();
		}
		int totalPrice = 0;
		Arrays.sort(setPrice);
		Arrays.sort(individualPrice);
		if(setPrice[0]>individualPrice[0]*6){
			totalPrice = individualPrice[0]*numGuitarLine;
		}else{
			totalPrice += numGuitarLine/6*setPrice[0];
			int numRest = numGuitarLine%6;
			if(setPrice[0]>individualPrice[0]*numRest){
				totalPrice += individualPrice[0]*numRest;
			}else{
				totalPrice += setPrice[0];
			}
		}
		System.out.println(totalPrice);
	}
}
