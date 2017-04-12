package baekjoon1152;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] strArr = str.split("\\s");
		int cnt = 0;
		for(int i=0; i<strArr.length; i++){
			if(!strArr[i].equals("")) cnt++;
		}
		System.out.println(cnt);
	}
}
