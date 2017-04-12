package baekjoon1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	}
	
	static int numComputer = 1;
	public static void main(String[] args) {
		Scan sc = new Scan();
		int numComputers = sc.nextInt();
		int numRelations = sc.nextInt();
			
		ArrayList<Integer>[] trustLink = new ArrayList[numComputers+1];
		for(int i=1; i<=numComputers; i++){
			trustLink[i] = new ArrayList<Integer>();
		}
		int targetCom = 0;
		int preCom = 0;
		for(int i=0; i<numRelations; i++){
			targetCom = sc.nextInt();
			int a = sc.nextInt();
			trustLink[a].add(targetCom);
		}
		int maxNum = -1;
		ArrayList<Integer> list = new ArrayList<>();
		Queue<Integer> go = new LinkedList<>();
		for(int i=1; i<=numComputers; i++){
			boolean hackingCheck[] = new boolean[numComputers+1];
			go.add(i);
			int cnt = 1;
			hackingCheck[i] = true;
			while(!go.isEmpty()){
				preCom = go.poll();
				int a = trustLink[preCom].size();
				for(int j=0; j<a; j++){
					targetCom = trustLink[preCom].get(j);
					if(!hackingCheck[targetCom]){
						hackingCheck[targetCom]=true;
						go.add(targetCom);
						cnt++;
					}
				}
			}
			if(maxNum < cnt){
				maxNum = cnt;
				list = new ArrayList<Integer>();
				list.add(i);
			} else if (maxNum == cnt) {
				list.add(i);
			}
		}
		for(int num : list){
			System.out.println(num);
		}
	}
}
