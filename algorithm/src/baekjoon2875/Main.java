package baekjoon2875;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int girlStudents = sc.nextInt();
		int boyStudents = sc.nextInt();
		int internShip = sc.nextInt() - girlStudents%2;
		int numTeam = 0;
		girlStudents = girlStudents-girlStudents%2 ;
		while(girlStudents > 0 && boyStudents > 0){
			girlStudents = girlStudents-2;
			boyStudents--;
			numTeam++;
		}
		System.out.println(numTeam);
		internShip = internShip - (girlStudents + boyStudents);
		while(internShip > 0){
			numTeam--;
			internShip = internShip - 3;
		}
		System.out.println(numTeam);
	}
}
