package baekjoon5582;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	static char[] longChar;
	static char[] shortChar;
	static int shortL;
	static int longL;
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		String a = sc.nextLine();
		String b = sc.nextLine();
		compLength(a, b);
		int [][] length = new int[shortL][longL];
		int max = 0;
		for(int i=0; i<longL; i++){
			for(int j=0; j<shortL; j++){
				if(shortChar[j]==longChar[i]){
					if(i==0 || j==0)
						length[j][i] = 1;
					else
						length[j][i] = length[j-1][i-1]+1;
				}
				if(max < length[j][i]) max = length[j][i];
			}
		}
		System.out.println(max);
	}
	public static void compLength(String a, String b){
		if(a.length() > b.length()){
			longChar = a.toCharArray();
			shortChar = b.toCharArray();
		}else{
			longChar = b.toCharArray();
			shortChar = a.toCharArray();
		}
		shortL = shortChar.length;
		longL = longChar.length;
	}
}




















