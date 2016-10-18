package algorithm0823;

import java.util.*;

public class N1003 {
	private static Scanner sc;
	
	public static void main(String[] args){
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++){
			int n = sc.nextInt();
			if(n>1)
				System.out.println(fibonacci(n-1)+" "+fibonacci(n));
			else if(n==1) {
				System.out.println(0+" "+1);
			} else if(n==0) {
				System.out.println(1+" "+0);
			}
		}
	}
	
	public static int fibonacci(int n) {
	    if (n==0) {
	        return 0;
	    } else if (n==1) {
	        return 1;
	    } else {
	        return fibonacci(n-1) + fibonacci(n-2);
	    }
	}

}
