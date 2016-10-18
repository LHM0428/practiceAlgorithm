package algorithm1008;

import java.util.*;

public class BackJoon2294 {
	
	
	static int[] coin = new int[101];
	static int[] numOfCoin = new int[10001];
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		for(int i=1; i<=n; i++ ){
			coin[i]=sc.nextInt();
			if(coin[i]>10000)
				continue;
			
			numOfCoin[coin[i]]=1;
		}
		
		for(int i=1; i<=k; i++){
			for(int j=1; j<=n; j++){
				
				if(i-coin[j]<=0)
					continue;
				else{
					if(numOfCoin[i-coin[j]]==0)
						continue;
					else{
						if(numOfCoin[i]==0)
							numOfCoin[i]=numOfCoin[i-coin[j]]+1;
						else
							numOfCoin[i]=(numOfCoin[i]>(numOfCoin[i-coin[j]]+1))
											? numOfCoin[i-coin[j]]+1 : numOfCoin[i];
					}
				}
			}
		}
		if(numOfCoin[k]==0)
			System.out.println(-1);
		else
			System.out.println(numOfCoin[k]);
	}
}
