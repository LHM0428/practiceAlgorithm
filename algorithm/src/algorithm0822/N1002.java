package algorithm0822;

import java.util.Scanner;

public class N1002 {
	private static Scanner sc;
	public static void main(String[] args) {
		
		int T;
		double x1, y1, r1, x2, y2, r2;
		sc = new Scanner(System.in);
		System.out.println("몇번 시도 반복 하시겠습니까? ");
		T=sc.nextInt();
		
		for(int i = 0;i<T;i++)
		{
			x1 = sc.nextDouble();
			y1 = sc.nextDouble();
			r1 = sc.nextDouble();
			x2 = sc.nextDouble();
			y2 = sc.nextDouble();
			r2 = sc.nextDouble();
			if (Math.abs(x1) <= 10000 && Math.abs(x2) <= 10000 && Math.abs(y1) <= 10000 && Math.abs(y2) <= 10000
					&& r1 <= 10000 && r2 <= 10000 && r1 > 0 && r2 > 0) {
				double length = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
				System.out.println("길이 length : "+length+", 반지름 합 : "+(r1+r2));
				if (length > r1 + r2 || length < Math.abs(r1 - r2)) {
					System.out.println(0);
				} else if (length == r1 + r2 || length == Math.abs(r1 - r2)) {
					System.out.println(1);
				} else if (Math.abs(r1 - r2) < length && length < r1 + r2) {
					System.out.println(2);
				} else {
					System.out.println(-1);
				}
			}
		}
	}
}
