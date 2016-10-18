package algorithm1018;

import java.util.Scanner;

public class BackJoon5582 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String a = sc.nextLine();
		String b = sc.nextLine();
		char[] aChar = a.toCharArray();
		char[] bChar = b.toCharArray();
		
		int aLength = a.length();
		int bLength = b.length();
		int max = 0;
		int[][] length = new int[aLength][bLength];
		
		for(int i=0; i<aLength; i++){
			for(int j=0; j<bLength; j++){
				if(aChar[i]==bChar[j]){
					if(i==0 || j==0){
						length[i][j] = 1;
					}else{
						length[i][j] = length[i-1][j-1]+1;
					}
				}
				if(max < length[i][j])
					max = length[i][j];
			}
		}
		System.out.println(max);
	}
}
