package baekjoon2188;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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
	}
	
	static int numCows, numCattleSheds, cnt=0;
	static int MAX_COW = 200;
	static int MAX_NUM = 200*2+2;
	static int source = MAX_NUM-2;
	static int target = MAX_NUM-1;
	static int[][] capacities, volumeOfPassedFlow;
	static List<Integer>[] links;
	static boolean[] isEntered;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scan sc = new Scan();
		numCows = sc.nextInt();
		numCattleSheds = sc.nextInt();
		links = new ArrayList[MAX_NUM];
		capacities = new int[MAX_NUM][MAX_NUM];
		volumeOfPassedFlow = new int[MAX_NUM][MAX_NUM];
		
		for(int i=0; i<MAX_NUM; i++)
			links[i] = new ArrayList<Integer>();
		
		for(int i=0; i<numCows; i++){
			int si = sc.nextInt();
			for(int j=0; j<si; j++){
				//cow : 0 ~ 199 , cattleShed : 200 ~ 399, source : 400, target : 401
				int cs = sc.nextInt() + MAX_COW - 1;
				links[i].add(cs);
				links[cs].add(i);
				capacities[i][cs] = 1;
			}
			capacities[source][i] = 1;
			links[source].add(i);
			links[i].add(source);
		}
		
		for(int i=MAX_COW; i<MAX_COW+numCattleSheds; i++){
			capacities[i][target] = 1;
			links[i].add(target);
			links[target].add(i);
		}
		int cnt = 0;
		while(true){
			int[] routes = new int[MAX_NUM];
			Arrays.fill(routes, 0, MAX_NUM, -1);
			Queue<Integer> queue = new LinkedList<>();
			queue.add(source);
			while(!queue.isEmpty()){
				int current = queue.poll();
				for(int next : links[current]){
					if(capacities[current][next] - volumeOfPassedFlow[current][next] > 0
							&& routes[next] == -1){
						queue.add(next);
						routes[next] = current;
						if(next == target) break;
					}
				}
				
			}
			if(routes[target] == -1) break;
			for(int i=target; i!=source; i=routes[i]){
				volumeOfPassedFlow[routes[i]][i]++;
				volumeOfPassedFlow[i][routes[i]]--;
			}
			cnt++;
		}
		System.out.println(cnt);
			
	}
}
