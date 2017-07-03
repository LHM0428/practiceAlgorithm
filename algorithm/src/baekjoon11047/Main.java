package baekjoon11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Scan {
		private StringTokenizer tokenizer;
		private BufferedReader br;

		public Scan() {
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
	
	
	static int[] coins;
	static int money;
	static int numCoin;
	static int totalNumCoins;
	public static void getNumOfCoins(int money, int coinOrder){
		int rest = money%coins[coinOrder];
		int quotient = money/coins[coinOrder];
		if(quotient==0) getNumOfCoins(money, coinOrder-1);
		else if(rest!=0){
			totalNumCoins += quotient;
			getNumOfCoins(rest, coinOrder-1);
		}else{
			totalNumCoins += money/coins[coinOrder];
		}
	}

	public static void main(String[] args) {
		Scan sc = new Scan();
		numCoin = sc.nextInt();
		money = sc.nextInt();
		coins = new int[numCoin+1];
		
		for(int i=1; i<=numCoin; i++){
			coins[i] = sc.nextInt();
		}
		totalNumCoins = 0;
		getNumOfCoins(money, numCoin);
		System.out.println(totalNumCoins);
		
	}
}




























