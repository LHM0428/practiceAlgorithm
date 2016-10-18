package algorithm0829;

import java.io.*;
import java.util.*;

public class BSearch {
	
	static class Scan{
		BufferedReader br;
		StringTokenizer st;
		
		public Scan(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		public String next(){
			while(st==null || !st.hasMoreTokens()){
				try{
					st = new StringTokenizer(br.readLine());
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		public int nextInt(){
			return Integer.parseInt(next());
		}
	}
	
	public static int BSearch(int[] arr, int target){
		int first = 0;
		int last = arr.length-1;
		int mid;
		
		while(first<= last){
			mid = (first+last)/2;
			if(target == arr[mid]){
				return mid;
			}else{
				if(target > arr[mid]){
					first = mid+1;
				} else {
					last = mid-1;
				}
			}
		}
		return -1;
	}
	
	public static int BSearchRecur(int[] arr, int first, int last, int target){

		if(first>last) return -1;
		int mid = (first+last)/2;
		
		if(arr[mid]==target) return mid;
		else if(target > arr[mid]){
			return BSearchRecur(arr, mid+1, last, target);
		}else{
			return BSearchRecur(arr, first, mid-1, target);
		}
	}
	
	public static void main(String[] arge){
		Scan sc = new Scan();
		int idx;
		System.out.print("몇 번 시도하시겠습니까? ");
		int T = sc.nextInt();
		for(int i=0; i<T; i++){
			System.out.println(T);
			System.out.print("몇 개의 숫자를 입력하시겠습니까? ");
			int length = sc.nextInt();
			int[] arr = new int[length];
			
			System.out.println(length+"개의 숫자를 입력하세요.");
			for(int j=0; j<length; j++) arr[j]=sc.nextInt();
			
			System.out.print("어떤 숫자를 찾고 싶습니까? ");
			int find = sc.nextInt();
//			idx = BSearch(arr, find); // 이진탐색
			idx = BSearchRecur(arr, 0, length-1, find);//재귀함수
			
			if(idx<0) System.out.println("탐색 실패");
			else System.out.println("찾고자 하는 숫자의 인덱스 : "+idx);
		}
	}

}
