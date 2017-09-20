package baekjoon2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.print.attribute.standard.Sides;

public class Main {
	static class Scan {
		private StringTokenizer tokenizer;
		private BufferedReader br;

		public Scan() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
	static class Area {
		int x;
		int y;
		int height;
		public Area(int x, int y, int height) {
			super();
			this.x = x;
			this.y = y;
			this.height = height;
		}
	}
	
	static int N;
	static int[][] area;
	static boolean[][] isVisited;
	static Queue<Area> queue;
	static int maxHeight = 0;
	static int[] resultArr;
	public static void main(String[] args) {
		Scan sc = new Scan();
		N = sc.nextInt();
		area = new int[N][N];
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++){
				area[i][j] = sc.nextInt();
				if(maxHeight < area[i][j]) maxHeight = area[i][j];
			}
		resultArr = new int[maxHeight];
		int idx = maxHeight;
		while(--maxHeight > 0){
			isVisited = new boolean[N][N];
			for(int i=0; i<N; i++)
				for(int j=0; j<N; j++){
					if(maxHeight < area[i][j] && !isVisited[i][j]){
						checkArea(i,j);
						resultArr[maxHeight]++;
					}
				}
			System.out.println("result :"+resultArr[maxHeight]);
			System.out.println("================================");
		}
		int result = 1;
		for(int i=0; i<idx; i++){
			if(resultArr[i] > result) result = resultArr[i];
		}
		System.out.println(result);
			
	}
	private static void checkArea(int i, int j) {
		isVisited[i][j] = true;
		if(maxHeight >= area[i][j]) return;
		else {
			System.out.println(maxHeight+" : "+"( "+(i+1)+", "+(j+1)+" )");
			if(i+1 < N && !isVisited[i+1][j]) checkArea(i+1, j);
			if(i-1 > -1 && !isVisited[i-1][j]) checkArea(i-1, j);
			if(j+1 < N && !isVisited[i][j+1]) checkArea(i, j+1);
			if(j-1 > -1 && !isVisited[i][j-1]) checkArea(i, j-1);
		}
	}
}

































