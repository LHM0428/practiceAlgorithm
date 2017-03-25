package algorithm1028;

import java.util.Scanner;

public class Baekjoon1149 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] costColor = new int[n+1][4];
		int[][] sum = new int[n+1][4];
		for(int i=1; i<=n; i++){
			for(int j=1; j<=3; j++)
				costColor[i][j] = sc.nextInt();
		}
		sum[1][1] = costColor[1][1];
		sum[1][2] = costColor[1][2];
		sum[1][3] = costColor[1][3];
		
		if(n>1){
			for(int i=2; i<=n; i++){
				
				if(sum[i-1][2] < sum[i-1][3]){
					sum[i][1] = sum[i-1][2] + costColor[i][1];
				}else{
					sum[i][1] = sum[i-1][3] + costColor[i][1];
				}
				
				if(sum[i-1][1] < sum[i-1][3]){
					sum[i][2] = sum[i-1][1] + costColor[i][2];
				}else
					sum[i][2] = sum[i-1][3] + costColor[i][2];
				
				if(sum[i-1][1] < sum[i-1][2])
					sum[i][3] = sum[i-1][1] + costColor[i][3];
				else
					sum[i][3] = sum[i-1][2] + costColor[i][3];
			}
		}
		int result = Integer.MAX_VALUE;
		for(int i=1; i<=3; i++){
			result = Math.min(sum[n][i], result);
		}
		System.out.println(result);
	}
}
