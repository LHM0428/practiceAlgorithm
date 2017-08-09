package baekjoon10610;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String numStr = sc.nextLine();
		char[] numChar = numStr.toCharArray();
		int sum = 0;
		int result = -1;
		String resultStr = "";
		Arrays.sort(numChar);
		if(numChar[0]!='0') System.out.println(result);
		else{
			for(char i : numChar){
				sum += i-'0';
			}
			if(sum%3==0){
				for(char i : numChar){
					resultStr = i+resultStr;
				}
				System.out.println(resultStr);
			}else{
				System.out.println(result);
			}
		}
	}
}
