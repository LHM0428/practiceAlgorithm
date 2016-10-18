package algorithm1006;

import java.util.*;

public class BackJoon9084 {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		int testNum = scan.nextInt();
		while(testNum-->0){
			int[] result = new int[10001];
			int coinNum = scan.nextInt();
			int[] coin = new int[coinNum+1];
			for(int i=1; i<=coinNum; i++){
				coin[i]= scan.nextInt();
			}
			int money = scan.nextInt();
			
			for(int i=1; i<=coinNum; i++){
				result[coin[i]]++;
				for(int j=coin[i]+1; j<=money; j++){
					result[j] = result[j]+ result[j-coin[i]];
				}
			}
			
			System.out.println(result[money]);
		}
	}
}
