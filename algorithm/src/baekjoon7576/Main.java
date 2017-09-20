package baekjoon7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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

	static class Position {
		public int x;
		public int y;
		public int date;

		public Position(int x, int y, int date) {
			this.x = x;
			this.y = y;
			this.date = date;
		}

		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + ", date=" + date + "]";
		}
		
	}

	static int M, N;
	static int[][] tomatoBox;
	static int cnt;
	static Queue<Position> queue;

	public static void main(String[] args) {
		Scan sc = new Scan();
		M = sc.nextInt();
		N = sc.nextInt();
		tomatoBox = new int[N][M];
		cnt = 0;
		queue = new LinkedList<>();
		for (int i = 0; i < N; i++){
			for (int j = 0; j < M; j++) {
				tomatoBox[i][j] = sc.nextInt();
				if (tomatoBox[i][j] == 1)
					queue.offer(new Position(i, j, 0));
			}
		}

		Position position = queue.poll();
		while (position != null) {
			if (position.date > cnt) cnt = position.date;
			beingMatureTomato(position);
			position = queue.poll();
		}
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if(tomatoBox[i][j] == 0) cnt = -1;
		
		System.out.println(cnt);
	}

	private static void beingMatureTomato(Position position) {
		int i = position.x;
		int j = position.y;
		int date = position.date;
		if (i + 1 < N && tomatoBox[i + 1][j] == 0) {
			tomatoBox[i + 1][j] = 1;
			queue.offer(new Position(i + 1, j, date + 1));
		}
		if (i - 1 > -1 && tomatoBox[i - 1][j] == 0) {
			tomatoBox[i - 1][j] = 1;
			queue.offer(new Position(i - 1, j, date + 1));
		}
		if (j + 1 < M && tomatoBox[i][j + 1] == 0) {
			tomatoBox[i][j + 1] = 1;
			queue.offer(new Position(i, j + 1, date + 1));
		}
		if (j - 1 > -1 && tomatoBox[i][j - 1] == 0) {
			tomatoBox[i][j - 1] = 1;
			queue.offer(new Position(i, j - 1, date + 1));
		}
	}
}
