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
			isFirst = new int[numBuildings+1];
			System.out.println(isFirst[0]);
			for(int j=1; j<=numBuildings; j++){
				//j��° ���� 0���� ���� j���� �ǹ��� �Ǽ� �ð��� �����Ѵ�.
				buildingRules[j][0]=sc.nextInt();
			}
			for(int k=0; k<numRule; k++){
				int numBefore = sc.nextInt();//���� �ǹ�
				int numNext = sc.nextInt();//���� �ǹ�
				int a = ++path[numBefore];
				buildingRules[numBefore][a]=numNext;
				isFirst[numNext]=1;//������ġ�� �ɼ� ���� �͵鿡 1�� �־��ش�.
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
				System.out.println("queue ���� �� ���� �� : "+i);
				result[i]=buildingRules[i][0];
				System.out.println("ó�� �ʱ� ��� ["+i+"] : "+result[i]);
			}
		}
		//BFS
		while(!que.isEmpty()){
			int a = que.deQueue();
			System.out.println("que���� ���� �� :"+a);
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
						System.out.println("������ queue�� �� ���� : "+numNext);
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
	        //������ ��ŭ ť ����
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
	         
	        //����ִٸ� �ٽ� �������� �ʱ�ȭ
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
