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
		}//Prime Number ã�� for����
		
		for(int i=0; i<primList.size(); i++){
			primeGroup[primList.get(i)]=1;
		}
		
		int N = sc.nextInt();
		while(N-->0){
			int beforePass, afterPass;
			int result = -1;
			int visit[] = new int[10001];
			ArrayList<Couple> list = new ArrayList<>();
			
			beforePass = sc.nextInt();//ó�� �Ҽ�
			afterPass = sc.nextInt();//�ٲ� �Ҽ�
			
			list.add(new Couple(beforePass, 0));
			visit[beforePass] = 1;
			
			while(!list.isEmpty()){
				Couple temp = list.get(0);
				int[] digit = new int[4];//�� �ڸ� ���� ���� ����
				int tempNum = temp.primeNum;
				int[] d = {1000,100,10,1};//�� �ڸ����� ���ϰ� ���ϱ� ���� �迭
				
				if(tempNum==afterPass){//list�� �ִ� �Ҽ��� �ٲٰ��� �ϴ� �Ҽ��� ���ٸ� ��
					result=temp.count;
					break;
				}
				
				for(int i=0; i<4; i++){//�� �ڸ� �� ���� ���� ����
					digit[i] = tempNum/d[i];
					tempNum = tempNum%d[i];
				}
				
				list.remove(0);//����Ʈ���� ����
				
				for(int i=0; i<4; i++){
					tempNum = temp.primeNum - digit[i]*d[i];//�Ҽ��� �ڸ� ���� �ش��ϴ� ���� 0���� ����� 
					for(int j=0; j<=9; j++){
						int compareNum = tempNum + j*d[i];//�Ҽ����� �ƴ��� ���غ��� ���� 0���� ���� �ڸ� �����ٰ� �� ����
						if(i==0 && j==0)
							continue;
						
						if(primeGroup[compareNum]==1 && visit[compareNum]==0){
							//primeGroup�� ��ġ�Ͽ� �Ҽ��̰�, ������ �ٲ� ���� ���� �Ҽ����
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
