package algorithm1115;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Baekjoon2178 {
	public static class Miro{
		int x;
		int y;
		int cnt;
		public Miro() {
			// TODO Auto-generated constructor stub
		}
		public Miro(int x,int y,int cnt){
			this.x = x;
			this.y = y;
			this.cnt=cnt;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		
	}
	
	static int min =Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] miro = new int[N+1][M+1];
		for(int i=0; i<N; i++){
			Integer a = sc.nextInt();
			String k = a.toString();
			for(int j=0; j<M; j++){
				 miro[i][j]=k.charAt(j)-48;
			}
		}
		boolean[][] visit = new boolean[N+1][M+1];
		Queue<Miro> search = new LinkedList<>();
		search.add(new Miro(1,1,1));
		while(!search.isEmpty()){
			Miro goMiro = search.poll();
			int x = goMiro.getX();
			int y = goMiro.getY();
			if(miro[x+1][y]==1 && !visit[x+1][y]){
				search.add(new Miro(x+1, y, ++goMiro.cnt));
			}
			if(miro[x][y+1]==1 && !visit[x][y+1]){
				search.add(new Miro(x, y+1, ++goMiro.cnt));
			}
			if(miro[x+1][y]==1 && !visit[x+1][y]){
				search.add(new Miro(x+1, y, ++goMiro.cnt));
			}
			if(miro[x+1][y]==1 && !visit[x+1][y]){
				search.add(new Miro(x+1, y, ++goMiro.cnt));
			}
		}
	}
	
	public static void goThrough(int[][] miro, int n, int m, int cnt, boolean[][] visit){
		System.out.println(n+", "+m+"은 갈 수 있음"+miro[n][m]);
		visit[n][m]=true;
		boolean[][] k = visit;
		if(miro.length-2==n && miro[n].length-2==m){
			if(min>++cnt){
				min = cnt;
			}
		}
		
		
		
	}
}
