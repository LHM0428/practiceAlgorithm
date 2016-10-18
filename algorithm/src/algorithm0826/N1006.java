package algorithm0826;

import java.io.*;
import java.util.*;
public class N1006 {
	static class Scan{
		BufferedReader br;
		StringTokenizer st;
		
		public Scan(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		public String next(){
			while(st == null || !st.hasMoreTokens()){
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
	
	static int[][] area;
	static boolean[][] accessible;
	static int n;
	static int numArea, dualArea=0;
	
	public static void main(String[] args){
		Scan sc = new Scan();
		int T = sc.nextInt();
		int result=0;
		while(T-->0){
			numArea = sc.nextInt();//n/2의 방의 수를 받는다.
			n = sc.nextInt();//소대원 수를 받는다.
			area = new int[2][numArea+2]; //구역에 해당하는 방의 수+2의 배열을 초기화 한다
			accessible = new boolean[2][numArea+2]; // 침투 가능한지 여부를 체크한다.
			
			for(int j=0;j<=1; j++){
				for(int i=1;i<=numArea; i++){
					area[j][i]=sc.nextInt();
					if(i==1){
						area[j][numArea+1]=area[j][0];
						accessible[j][numArea+1]=true;
					}
					if(i==numArea){
						area[j][0]=area[j][numArea];
						accessible[j][0]=true;
					}
					accessible[j][i]= true;
				}// 1~2*numArea까지 초기화
			}
		}
		maxNum();
		result = 2*numArea - dualArea;
		System.out.println(result);
	}
	
	public static int maxNum(){
		for(int j=0; j<=1; j++){
			for(int i=1; i<=numArea; i++){
				if(accessible[j][i]){
					System.out.println("check "+"("+j+", "+i+")");
					check(j,i);
				}
			}
		}
		return 0;
	}
	
	public static void check(int j, int i){
		int a=n+1,b=n+1,c=n+1;
		ArrayList<Integer[]> cnt = new ArrayList<>();
		if(accessible[j][i-1]){
			a = area[j][i]+area[j][i-1];
		}
		if(accessible[j][i+1]){
			b = area[j][i]+area[j][i+1];
		}
		if(j==0){
			if(accessible[1][i]){
				c = area[j][i]+area[1][i];
			}			
		}else{
			if(accessible[0][i]){
				c=area[j][i]+area[0][i];
			}
		}
		
		if(n>=a){
			Integer dual[] = new Integer[2];
			dual[0]=j;
			dual[1]=i-1;
			cnt.add(dual);
			System.out.println(j+","+(i-1)+"과 "+j+", "+i+" 구역과 함께");
		}
		if(n>=b){
			Integer dual[] = new Integer[2];
			dual[0]=j;
			dual[1]=i+1;
			cnt.add(dual);
			System.out.println(j+","+(i+1)+"과 "+j+", "+i+"구역과 함께");
		}
		if(n>=c){
			Integer dual[] = new Integer[2];
			if(j==1){
				dual[0]=0;
				dual[1]=i;
			}else{
				dual[0]=1;
				dual[1]=i;
			}
			cnt.add(dual);
			System.out.println((j+1)+","+i+"과 "+j+", "+i+"구역과 함께");
		}
		if(cnt.size()>1){
			System.out.println("두개 구역이 겹치는 경우");
			for(int k=0; k<cnt.size(); k++){
				if(cnt.get(k)[1]==0)
					check(cnt.get(k)[0], numArea);
				else if(cnt.get(k)[1]==numArea)
					check(cnt.get(k)[0], 1);
				else 
					check(cnt.get(k)[0],cnt.get(k)[1]);
			}
			check(i,j);
		}else if(cnt.size()==1){
				accessible[cnt.get(0)[0]][cnt.get(0)[1]]=false;
				accessible[j][i]=false;
				dualArea++;
				if(cnt.get(0)[1]==0){
					accessible[cnt.get(0)[0]][numArea]=false;
				}else if(cnt.get(0)[1]==numArea){
					accessible[cnt.get(0)[0]][1]=false;
				}
			System.out.println("두개 구역 침투");
		}else{
			accessible[j][i]=false;
			System.out.println(j+", "+i+" 한개 구역 침투");
		}
	}
}
