package baekjoon1017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static boolean[] check;
	static int N;
	static int[] matchOdd, matchEven;
	static ArrayList<Integer>[] linkArr;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		List<Integer> evenList = new ArrayList<>();
		List<Integer> oddList = new ArrayList<>();
		linkArr = new ArrayList[N/2];
		check = new boolean[N/2];
		matchOdd = new int[N/2];
		matchEven = new int[N/2];
		
		for(int i=0; i<N/2; i++) linkArr[i] = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++){
			int a = sc.nextInt();
			(a%2==1? oddList : evenList).add(a);
		}
		
		if(oddList.size() != evenList.size()) {
			System.out.println(-1);
			return;
		}
		
		int size = oddList.size();
		boolean[] prime = new boolean[2000];
		Arrays.fill(prime, 0, 2000, true);
		
		for(int i=2; i*i<2000; i++)
			for(int j=i*i; j<2000; j+=i) prime[j] = false;
		
		for(int i=0; i<size; i++)
			for(int j=0; j<size; j++)
				if(prime[oddList.get(i)+evenList.get(j)])
					linkArr[i].add(j);
		
		List<Integer> result = new ArrayList<>();
		
		for(int evenIdx : linkArr[0]){
			Arrays.fill(matchEven, 0, N/2, -1);
			Arrays.fill(matchOdd, 0, N/2, -1);
			
			matchOdd[0] = evenIdx;
			matchEven[evenIdx] = 0;
			int cnt = 1;
			
			for(int oddIdx=1; oddIdx<size; oddIdx++){
				Arrays.fill(check, false);
				check[0] = true;
				if(dfs(oddIdx)) cnt++;
			}
			
			if(cnt==size) result.add(evenList.get(evenIdx));
		}
		if(result.isEmpty()) System.out.println(-1);
		else{
			Collections.sort(result);
			for(int c : result) System.out.print(c+" ");
			System.out.println();
		}
		
	}
	private static boolean dfs(int oddIdx) {
		if(check[oddIdx]) return false;
		check[oddIdx] = true;
		for(int evenIdx : linkArr[oddIdx]){
			if(matchEven[oddIdx] == -1 || dfs(matchEven[oddIdx])){
				matchOdd[evenIdx] = oddIdx;
				matchEven[oddIdx] = evenIdx;
				return true;
			}
		}
		return false;
	}
}
























