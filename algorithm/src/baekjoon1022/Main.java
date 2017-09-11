package baekjoon1022;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		int r1 = sc.nextInt();
		int c1 = sc.nextInt();
		int r2 = sc.nextInt();
		int c2 = sc.nextInt();
		int max = Math.max(Math.abs(r1), Math.abs(c1));
		max = Math.max(max, Math.abs(r2));
		max = Math.max(max, Math.abs(c2));
		int[][] square = new int[max * 2 + 2][max * 2 + 2];
		int num = 1;
		square[max+1][max+1] = num++;
		int row = max+1;
		int col = max+1;
		for (int k = 0; k < max; k++) {
			col += 1;
			for (int j = 0; j < 4; j++) {
				for(int i=0; i<2*(k+1); i++){
					switch(j) {
					case 0 :
						if(i!=0) row = row-1;
						break;
					case 1:
						col = col-1;
						break;
					case 2:
						row = row+1;
						break;
					case 3:
						col = col+1;
						break;
					}
					square[row][col] = num++;
				}
			}
		}
		int colS = max+1+c1;
		int colE = max+1+c2;
		int rowS = max+1+r1;
		int rowE = max+1+r2;;
		int log10 = 0;
		for(int j=rowS; j<=rowE; j++){
			for(int i=colS; i<=colE; i++){
				int a = (int) Math.log10(square[j][i]);
				log10 = Math.max(a, log10);
			}
		}
		for(int j=rowS; j<=rowE; j++){
			for(int i=colS; i<=colE; i++){
				int a = (int) Math.log10(square[j][i]);
				String space = "";
				for(int k=0; k<log10-a; k++) space = " "+space;
				System.out.print(space+square[j][i]+" ");
			}
			System.out.println();
		}
	}
}
