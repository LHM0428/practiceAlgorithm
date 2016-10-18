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
		System.out.print("�� �� �õ��Ͻðڽ��ϱ�? ");
		int T = sc.nextInt();
		for(int i=0; i<T; i++){
			System.out.println(T);
			System.out.print("�� ���� ���ڸ� �Է��Ͻðڽ��ϱ�? ");
			int length = sc.nextInt();
			int[] arr = new int[length];
			
			System.out.println(length+"���� ���ڸ� �Է��ϼ���.");
			for(int j=0; j<length; j++) arr[j]=sc.nextInt();
			
			System.out.print("� ���ڸ� ã�� �ͽ��ϱ�? ");
			int find = sc.nextInt();
//			idx = BSearch(arr, find); // ����Ž��
			idx = BSearchRecur(arr, 0, length-1, find);//����Լ�
			
			if(idx<0) System.out.println("Ž�� ����");
			else System.out.println("ã���� �ϴ� ������ �ε��� : "+idx);
		}
	}

}
