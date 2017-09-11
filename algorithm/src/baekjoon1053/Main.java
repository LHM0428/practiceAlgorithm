package baekjoon1053;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	static int length;
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		String str = sc.nextLine();
		char[] pelindrome = str.toCharArray();
		length = pelindrome.length;
		int result = getMinCount(pelindrome);
		
		for(int i=0; i<length-1; i++){
			for(int j=i+1; j<length; j++){
				if(pelindrome[i]!=pelindrome[j]){
					char[] swapPelindrome = str.toCharArray();
					char temp = swapPelindrome[i];
					swapPelindrome[i] = swapPelindrome[j];
					swapPelindrome[j] = temp;
					result = Math.min(result, getMinCount(swapPelindrome)+1);
				}
			}
		}
		System.out.println(result);
	}
	public static int getMinCount(char[] pelindrome){
		System.out.println(pelindrome);
		int[][] check = new int[length][length];
		for (int i = 0; i < length; i++) {
			check[i][i] = 0;
			if (i != length - 1) {
				check[i][i + 1] = pelindrome[i] == pelindrome[i + 1] ? 0 : 1;
			}
		}
		for (int i = 2; i < length; i++) {
			for (int j = 0; j < length - i; j++) {
				int min = check[j][j + i - 1] + 1;
				min = Math.min(check[j + 1][j + i] + 1, min);
				if (pelindrome[j] == pelindrome[j + i])
					min = Math.min(check[j + 1][j + i - 1], min);
				else
					min = Math.min(check[j + 1][j + i - 1] + 1, min);
				check[j][j + i] = min;
			}
		}
		return check[0][length-1];
	}
}
