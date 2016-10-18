package algorithm1008;

import java.util.*;

public class BackJoon1963 {
	
	static int[] primeGroup = new int[10001];
	
	static class Couple{
		int primeNum;
		int count;
		
		public Couple(int primeNum, int count) {
			this.primeNum = primeNum;
			this.count = count;
		}
	}
	
	public static void main(String[] args){
		ArrayList<Integer> primList = new ArrayList<>();
		int checkPrime[] = new int[10001];
		Scanner sc = new Scanner(System.in);
		
		for(int i=2; i<=10000; i++){
			
			if(checkPrime[i]==0){
				int count = 1;
				primList.add(i);
				checkPrime[i*count++]=1;
				
				while(i*count<=10000){
					checkPrime[i*count++]=1;
				}
			}else
				continue;
		}//Prime Number 찾는 for구문
		
		for(int i=0; i<primList.size(); i++){
			primeGroup[primList.get(i)]=1;
		}
		
		int N = sc.nextInt();
		while(N-->0){
			int beforePass, afterPass;
			int result = -1;
			int visit[] = new int[10001];
			ArrayList<Couple> list = new ArrayList<>();
			
			beforePass = sc.nextInt();//처음 소수
			afterPass = sc.nextInt();//바꿀 소수
			
			list.add(new Couple(beforePass, 0));
			visit[beforePass] = 1;
			
			while(!list.isEmpty()){
				Couple temp = list.get(0);
				int[] digit = new int[4];//각 자릿 수별 숫자 저장
				int tempNum = temp.primeNum;
				int[] d = {1000,100,10,1};//각 자릿수를 구하고 비교하기 위한 배열
				
				if(tempNum==afterPass){//list에 있는 소수가 바꾸고자 하는 소수와 같다면 끝
					result=temp.count;
					break;
				}
				
				for(int i=0; i<4; i++){//각 자릿 수 별로 숫자 저장
					digit[i] = tempNum/d[i];
					tempNum = tempNum%d[i];
				}
				
				list.remove(0);//리스트에서 제거
				
				for(int i=0; i<4; i++){
					tempNum = temp.primeNum - digit[i]*d[i];//소수의 자릿 수에 해당하는 숫자 0으로 만들고 
					for(int j=0; j<=9; j++){
						int compareNum = tempNum + j*d[i];//소수인지 아닌지 비교해보기 위해 0으로 만든 자릿 수에다가 수 대입
						if(i==0 && j==0)
							continue;
						
						if(primeGroup[compareNum]==1 && visit[compareNum]==0){
							//primeGroup과 일치하여 소수이고, 이전에 바꾼 적이 없던 소수라면
							visit[compareNum]=1;
							list.add(new Couple(compareNum, temp.count+1));
						}
					}
				}
			}
		if(result==-1){
			System.out.println("Impossible");
		}
		else{
			System.out.println(result);
		}
		}
	}
}
