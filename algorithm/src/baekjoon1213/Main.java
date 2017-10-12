package baekjoon1213;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		char[] nameArr = name.toCharArray();
		Arrays.sort(nameArr);
		int length = nameArr.length;
		int chance = length%2;
		int soloIdx = -1;
		int[] alphabet = new int[26];
		for(int i=0; i<length; i++){
			alphabet[nameArr[i]-'A']++;
		}
		for(int i=0; i<26; i++){
			if(alphabet[i]%2==1){
				soloIdx = i;
				chance--;
			}
		}
		if(chance<0){
			System.out.println("I'm Sorry Hansoo");
			return;
		}
		StringBuffer result = new StringBuffer("");
		for(int i=0; i<26; i++){
			if(i==soloIdx) alphabet[i]--;
			for(int j=0; j<alphabet[i]/2; j++)
				result.append((char) ('A'+i));
		}
		if(soloIdx>-1) result.append((char) ('A'+soloIdx));
		for(int i=25; i>-1; i--){
			for(int j=0; j<alphabet[i]/2; j++)
				result.append((char) ('A'+i));
		}
		
		System.out.println(result);
	}
}
