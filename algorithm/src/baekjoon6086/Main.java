package baekjoon6086;

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
		public int nextChar(){
			char a = next().toCharArray()[0];
			if(a <= 'Z') return a - 'A';
			return a-'a'+26;
		}
	}
	static int N;
	static List<Integer>[] adj;
	static int[][] volumeOfPassedFlow, capacities;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scan sc = new Scan();
		int N = sc.nextInt();
		adj = new ArrayList[52];
		volumeOfPassedFlow = new int[52][52];
		capacities = new int[52][52];
		for(int i=0; i<52; i++)
			adj[i] = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++){
			int pipeA = sc.nextChar();
			int pipeB = sc.nextChar();
			int capacity = sc.nextInt();
			adj[pipeA].add(pipeB);
			adj[pipeB].add(pipeA);
			capacities[pipeA][pipeB] += capacity;
		}
		int total = 0;
		int source = 0;
		int target = 'Z' - 'A';
		
		while(true){
			int[] routes = new int[52];
			Arrays.fill(routes, 0, 52, -1);
			Queue<Integer> queue = new LinkedList<>();
			queue.add(source);
			while(!queue.isEmpty()){
				int current = queue.poll();
				for(int next : adj[current]){
					if(capacities[current][next] - volumeOfPassedFlow[current][next] > 0 &&
							routes[next]== -1){
						queue.add(next);
						routes[next] = current;
						if(next == target) break;
					}
				}
			}
			
			if(routes[target] == -1) break;//target에 도달하지 못했다면
			
			int flow = Integer.MAX_VALUE;
			for(int i=target; i!=source; i=routes[i]){
				flow = Math.min(flow, capacities[routes[i]][i] - volumeOfPassedFlow[routes[i]][i]);
			}
			
			for(int i=target; i!=source; i=routes[i]){
				volumeOfPassedFlow[routes[i]][i] += flow;
				volumeOfPassedFlow[i][routes[i]] -= flow;
			}
			total += flow;
		}
		System.out.println(total);
	}
}








































