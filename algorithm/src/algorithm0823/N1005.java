package algorithm0823;

import java.util.*;
import java.io.*;

public class N1005 {
	private static int numBuildings, numRule;
	private static int[][] buildingRules;
	private static int finalBuilding;
	private static int result[], path[], isFirst[];
	static Queue que;
	
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
			isFirst = new int[numBuildings+1];
			System.out.println(isFirst[0]);
			for(int j=1; j<=numBuildings; j++){
				//j번째 행의 0번쨰 열에 j번쨰 건물의 건설 시간을 저장한다.
				buildingRules[j][0]=sc.nextInt();
			}
			for(int k=0; k<numRule; k++){
				int numBefore = sc.nextInt();//이전 건물
				int numNext = sc.nextInt();//다음 건물
				int a = ++path[numBefore];
				buildingRules[numBefore][a]=numNext;
				isFirst[numNext]=1;//시작위치가 될수 없는 것들에 1을 넣어준다.
			}
			finalBuilding = sc.nextInt();
			
			System.out.println(calcTime());
		}
	}
	
	public static int calcTime(){
		int max=0;
		que = new Queue(numRule);
		for(int i=1; i<=numBuildings; i++){
			if(isFirst[i]==0){
				que.enQueue(i);
				System.out.println("queue 시작 점 들어가는 것 : "+i);
				result[i]=buildingRules[i][0];
				System.out.println("처음 초기 결과 ["+i+"] : "+result[i]);
			}
		}
		//BFS
		while(!que.isEmpty()){
			int a = que.deQueue();
			System.out.println("que에서 꺼낸 값 :"+a);
			if(a==finalBuilding) {
				for(int i=1; i<result.length;i++){
					if(max < result[i]){
						max = result[i];
					}
				}
			}else{
				System.out.println("path["+a+"] = "+path[a]);
				for(int i=1; i<=path[a]; i++){
					if(buildingRules[a][i]>0){
						int numNext = buildingRules[a][i];
						System.out.println("다음에 queue에 들어갈 숫자 : "+numNext);
						if(result[numNext]<result[a]+buildingRules[numNext][0]){
							result[numNext] = result[a]+buildingRules[numNext][0];
							que.enQueue(numNext);
						}
					}
				}
			}
		}
		return max;
	}
	
	static class Queue {
	     
	    private int[] queue;
	    private int size = 0;
	    private int rear = -1;
	    private int front = -1;
	     
	    Queue(int size) {
	        this.size = size;
	        //사이즈 만큼 큐 생성
	        this.queue = new int[size];
	    }
	     
	    public void enQueue(int element) {
	        queue[++rear] = element;
	    }
	     
	    public int deQueue() {
	         
	        ++front;
	        int temp = queue[front];
	         
	        //help gc;
	        queue[front] = 0;
	         
	        //비어있다면 다시 원점으로 초기화
	        if (isEmpty()) {
	            rear = -1;
	            front = -1;
	        }
	         
	        return temp;
	    }
	     
	    public boolean isFull() {
	        return rear == size-1 ? true : false;
	    }
	     
	    public boolean isEmpty() {
	        return front == rear ? true : false;
	    }
	     
	    public int getSize() {
	        return size;
	    }
	     
	}
}
