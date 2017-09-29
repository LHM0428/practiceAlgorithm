package baekjoon13560;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.print.attribute.standard.NumberOfDocuments;

public class Main {
	static class Scan{
		private StringTokenizer tokenizer;
		private BufferedReader br;

		public Scan(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next(){
			while(tokenizer == null || !tokenizer.hasMoreTokens()){
				try {
					tokenizer = new StringTokenizer(br.readLine());

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return tokenizer.nextToken();
		}

		public int nextInt(){
			return Integer.parseInt(next());
		}
	}
	static int[] score;
	static int numOfTeams;
	public static void main(String[] args) {
		Scan sc = new Scan();
		numOfTeams = sc.nextInt();
		score = new int[numOfTeams];
		for(int i=0; i<numOfTeams; i++){
			score[i] = sc.nextInt();
		}
		Arrays.sort(score);
		int result = 1;
		int sumWin = 0;
		int sumLose = 0;
		for(int i=0; i<numOfTeams; i++){
			sumWin += score[i];
			sumLose += numOfTeams-1 - score[numOfTeams-1-i];
			int check = i*(i+1)/2;
			if(sumWin < check || sumLose < check){
				result = -1;
				break;
			}
				
		}
		System.out.println(result);
	}
}






























