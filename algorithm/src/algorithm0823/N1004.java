package algorithm0823;

import java.util.*;

public class N1004 {
	
	public static Scanner sc;
	public static double startX, startY, endX, endY;
	public static int cnt;
	public static void main(String[] args){
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++){
			double cX, cY, r;
			int numPlanet;
			cnt=0;
			startX = sc.nextDouble();
			startY = sc.nextDouble();
			endX = sc.nextDouble();
			endY = sc.nextDouble();
			numPlanet = sc.nextInt();
			for(int j=0; j<numPlanet; j++){
				cX = sc.nextDouble();
				cY = sc.nextDouble();
				r = sc.nextDouble();
				cnt += numPassingBy(cX, cY, r);
			}
			System.out.println(cnt);
		}
	}
	
	public static int numPassingBy(double cX, double cY, double r){
		double lengthS = Math.sqrt(Math.pow(startX-cX, 2)+Math.pow(startY-cY,2));
		double lengthE = Math.sqrt(Math.pow(endX-cX, 2)+Math.pow(endY-cY, 2));
		int cnt=0;
		if(r>lengthS && r>lengthE){
			return cnt;
		}else if(r>lengthE){
			cnt++;
		}else if(r>lengthS){
			cnt++;
		}
		return cnt;
	}
}
