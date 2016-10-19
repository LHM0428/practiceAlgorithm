package algorithm1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon2643 {

	static int numCP;
	static Rectangle[] rec;
	public static void main(String[] args) {
		Scan sc = new Scan();
		numCP = sc.nextInt(); // ColorPaper 숫자 입력
		rec = new Rectangle[numCP]; 
		int nums[] = new int[numCP];
		for (int i = 0; i < numCP; i++) {
			rec[i] = new Rectangle(sc.nextInt(), sc.nextInt());
			rec[i].swap();
		}
		int a =0;
		int result =0;
		for (int i = 0; i < numCP; i++) {
			a = findStack(i, nums);
			if(a>result) result =a;
		}
		System.out.println(result);
	}

	public static int findStack(int m, int[] nums) {
		if(nums[m]>0) return nums[m];
		
		int max = 1;
		int temp = 0 ;
		for (int i = 0; i < numCP ; i++) {
			if(i==m) continue;
			if(rec[m].garo>= rec[i].garo && rec[m].sero>=rec[i].sero)
				temp = findStack(i, nums)+1;
				if(temp>max){
					max = temp;
				}
			}
		return nums[m]=max;
	}
	
	static class Rectangle{
		int garo;
		int sero;
		public Rectangle(int garo, int sero) {
			this.garo = garo;
			this.sero = sero;
		}
		public void swap(){
			if(garo<sero){
				int temp = garo;
				garo = sero;
				sero = temp;
			}
		}
	}
	
	static class Scan {
		BufferedReader br;
		StringTokenizer st;

		public Scan() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
