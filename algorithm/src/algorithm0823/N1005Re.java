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
		//���� Ƚ��
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++){
			//�ǹ� �� �ޱ�
			numBuildings = sc.nextInt();
			//��Ģ �� �ޱ�
			numRule = sc.nextInt();
			buildingRules = new int[numBuildings+1][numRule+1];
			path = new int[numBuildings+1];
			result = new int[numBuildings+1];
			for(int j=1; j<=numBuildings; j++){
				//j��° ���� 0���� ���� j���� �ǹ��� �Ǽ� �ð��� �����Ѵ�.
				buildingRules[j][0]=sc.nextInt();
			}
			for(int k=0; k<numRule; k++){
				int numBefore = sc.nextInt();//���� �ǹ�
				int numNext = sc.nextInt();//���� �ǹ�
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