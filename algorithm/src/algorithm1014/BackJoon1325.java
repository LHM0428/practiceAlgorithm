package algorithm1014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BackJoon1325 {
	static class Scan {
		BufferedReader br;
		StringTokenizer st;

		public Scan() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}

	public static void main(String[] args) {

		Scan sc = new Scan();
		int N = sc.nextInt();
		
		int[] result = new int[N + 1];
		int max = 0;
		int size = 0;

		int M = sc.nextInt();
		ArrayList<Integer>[] trustLink = new ArrayList[N+1];
		for(int i=1; i<=N; i++){
			trustLink[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			trustLink[b].add(a);
		}

		for (int i = 1; i <= N; i++) {
			int[] hacking = new int[N + 1];
			int cnt = 0;
			Queue checkGo = new Queue(M+1);	
			hacking[i] = 1;
			cnt++;
			checkGo.enQueue(i);;

			while (!checkGo.isEmpty()) {
				int b = checkGo.deQueue();
				for(int j=0; j<trustLink[b].size(); j++){
					int temp = trustLink[b].get(j);
					if (hacking[temp] == 0) {
						hacking[temp] = 1;
						checkGo.enQueue(temp);
						cnt++;
					}
				}
			}
			if (max < cnt) {
				size = 0;
				max = cnt;
				result[size++] = i;
			} else if (max == cnt) {
				result[size++] = i;
			}
		}

		for (int i = 0; i < size; i++) {
			System.out.println(result[i]);
		}
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
