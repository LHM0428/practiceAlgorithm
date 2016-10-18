package algorithm0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class N1005Re {
	private static int numBuildings, numRule;
	private static int[][] buildingRules;
	private static int finalBuilding;
	private static int result[], path[], isFirst[];
	static Queue<Integer> que;
	
    	static class FastScanner{
		private StringTokenizer tokenizer;
        private BufferedReader br;
        public FastScanner() {
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
	public static void main(String[] args){
		FastScanner sc = new FastScanner();
		//시행 횟수
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++){
			//건물 수 받기
			numBuildings = sc.nextInt();
			//규칙 수 받기
			numRule = sc.nextInt();
			buildingRules = new int[numBuildings+1][numRule+1];
			path = new int[numBuildings+1];
			result = new int[numBuildings+1];
			for(int j=1; j<=numBuildings; j++){
				//j번째 행의 0번쨰 열에 j번쨰 건물의 건설 시간을 저장한다.
				buildingRules[j][0]=sc.nextInt();
			}
			for(int k=0; k<numRule; k++){
				int numBefore = sc.nextInt();//이전 건물
				int numNext = sc.nextInt();//다음 건물
				int a = ++path[numNext];
				buildingRules[numNext][a]=numBefore;
			}
			
			finalBuilding = sc.nextInt();
			que = new LinkedList<>();
			que.offer(finalBuilding);
			for(int j=1; j<=numBuildings; j++){
				result[j] = buildingRules[finalBuilding][0];
			}
			System.out.println(calcTime());
			
		}
	}
	
	public static int calcTime(){
		Integer a = que.poll();
		while(a!=null){
			for(int i=1; i<=path[a]; i++){
				if(buildingRules[a][i]>0){
					int numBefore = buildingRules[a][i];
					if(result[numBefore]<result[a]+buildingRules[numBefore][0]){
						result[numBefore] = result[a]+buildingRules[numBefore][0];
						que.offer(numBefore);
					}
				}
			}
			a = que.poll();
		}
		int max=0;
		for(int i=1; i<result.length;i++){
			if(max < result[i]){
				max = result[i];
			}
		}
		return max;
	}
}