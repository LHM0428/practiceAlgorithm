package baekjoon2316;

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
	
	static int numCities, numRoads;
	static int[][] capacities, volumeOfPassedFlow;
	static List<Integer>[] roads;
	static int MAX = 800;
	static int source = 1, target = 4;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scan sc = new Scan();
		numCities = sc.nextInt();
		numRoads = sc.nextInt();
		roads = new ArrayList[MAX+1];
		capacities = new int[MAX+1][MAX+1];
		volumeOfPassedFlow = new int[MAX+1][MAX+1];
		for(int i=1; i<=numCities; i++){
			roads[i*2-1] = new ArrayList<Integer>();
			roads[i*2] = new ArrayList<Integer>();
			roads[i*2-1].add(i*2);
			capacities[i*2-1][i*2] = 1;
		}
		capacities[1][2] = Integer.MAX_VALUE;
		capacities[3][4] = Integer.MAX_VALUE;
		for(int i=0; i<numRoads; i++){
			int current = sc.nextInt();
			int next = sc.nextInt();
			roads[current*2].add(next*2-1);
			roads[next*2].add(current*2-1);
			capacities[current*2][next*2-1] = 1;
		}
		
		int result = 0;
		int[] routes = new int[MAX+1];
		while(true){
			Arrays.fill(routes, 0, MAX+1, -1);
			Queue<Integer> queue = new LinkedList<>();
			queue.add(source);
			while(!queue.isEmpty()){
				int current = queue.poll();
				for(int next : roads[current]){
					if(capacities[current][next] - volumeOfPassedFlow[current][next] > 0
							&& routes[next] == -1){
						routes[next] = current;
						//System.out.println(current+" -> "+next);
						queue.add(next);
						if(next == target) break;
					}
				}
				
			}
			
			if(routes[target] == -1) break;
			
			for(int i=target; i!=source; i=routes[i]){
				//System.out.println(i+" -> "+ routes[i]);
				volumeOfPassedFlow[routes[i]][i]++;
				volumeOfPassedFlow[i][routes[i]]--;
			}
			result++;
		}
		System.out.println(result);
	}
}







































