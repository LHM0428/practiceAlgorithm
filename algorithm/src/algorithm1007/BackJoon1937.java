package algorithm1007;

import java.io.*;
import java.util.*;

public class BackJoon1937 {
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
	
	static int[][] wood = new int [501][501];
	static int[][] visit = new int [501][501];
	static int N;
	static int result=0;
	static int[] vectorX={0,1,0,-1};
	static int[] vectorY={1,0,-1,0};
	
	public static void main(String[] args){
	
		Scan sc = new Scan();
		N = sc.nextInt();
		
		for(int i=1; i<=N; i++)
			for(int j=1; j<=N; j++)
				wood[i][j]=sc.nextInt();
		
		for(int i=1; i<=N; i++)
			for(int j=1; j<=N; j++)
			{
				if(visit[i][j]==0){
					dfsWood(i,j);
				}
			}
		System.out.println(result);
	}
	
	
	public static void dfsWood(int x, int y){
		int nextX, nextY;
		int value=0;
		for(int i=0; i<4;i++){
			nextX = x + vectorX[i];
			nextY = y + vectorY[i];
			
			if(nextX>N || nextX<=0 || nextY>N || nextY<=0)
				continue;
			
			if(wood[nextX][nextY]>wood[x][y]){
				
				if(visit[nextX][nextY]==0)
					dfsWood(nextX,nextY);
				
				if(value<visit[nextX][nextY])
					value=visit[nextX][nextY];
			}
		}
		visit[x][y]=value+1;
		if(result<visit[x][y])
			result=visit[x][y];
	}
	
}
































