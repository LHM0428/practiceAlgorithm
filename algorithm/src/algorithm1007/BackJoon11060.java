package algorithm1007;

import java.io.*;
import java.util.StringTokenizer;

public class BackJoon11060 {
	static class Scan{
		BufferedReader br;
		StringTokenizer st;
		
		public Scan(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		public String next(){
			while(st==null || !st.hasMoreTokens()){
				try{
					st = new StringTokenizer(br.readLine());
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		public int nextInt(){
			return Integer.parseInt(next());
		}
	}
	
	static int[] rock = new int[1001];

	public static void main(String[] args){
		Scan sc = new Scan();
		
		int arrive = sc.nextInt();
		rock[1]=1;
		for(int i=1; i<=arrive; i++){
			
			int jump = sc.nextInt();
			
			for(int j=1; j<=jump && j+i<=1000; j++){
				if(rock[i+j]>rock[i]+1 || rock[i+j]==0)
					rock[i+j]=rock[i]+1;
			}
		}
		if(rock[arrive]==0)System.out.println(0);
		else
			System.out.println(rock[arrive]-1);
		
	}
}
