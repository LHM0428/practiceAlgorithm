package algorithm1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon3020 {
	
	public static void main(String[] args) {
		Scan sc = new Scan();
		int N = sc.nextInt();
		int height = sc.nextInt();
		int oddBarrier[] = new int[height+1];
		int evenBarrier[] = new int[height+1];
		int totalOddBarrier[] = new int[height+1];
		int totalEvenBarrier[] = new int[height+1];
		int numBarrier[] = new int[height+1];
		int oddM = 0;
		int evenM = 0;
		int min = N;
		int result = 0;
		
		for(int i=1; i<=N/2; i++){
			int odd = sc.nextInt();
			int even = sc.nextInt();
			oddBarrier[odd]++;
			evenBarrier[even]++;
			if(oddM<odd)
				oddM=odd;
			if(evenM<even)
				evenM=even;
		}
		 
		for(int i=oddM; i>=1; i--)
			totalOddBarrier[i] = oddBarrier[i]+totalOddBarrier[i+1];
		for(int i=evenM; i>=1; i--)
			totalEvenBarrier[i] = evenBarrier[i]+totalEvenBarrier[i+1];
			
		for(int i=1; i<=height; i++){
			if(i==1)
				numBarrier[i]=totalOddBarrier[1];
			else if(i==height)
				numBarrier[i]=totalEvenBarrier[1];
			else
				numBarrier[i]=totalEvenBarrier[height-i+1]+totalOddBarrier[i];
			
			if(numBarrier[i]==min){
				result++;
			}else if(numBarrier[i]<min){
				result = 1;
				min = numBarrier[i];
			}
		}
		System.out.print(min+" "+result);
	}

	public static class Scan{
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
}
