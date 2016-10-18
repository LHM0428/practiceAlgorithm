package algorithm1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BackJoon1620 {

	public static class Scan{
		BufferedReader br;
		StringTokenizer st;

		public Scan() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
	
	public static void main(String[] args) {
		
		Scan sc = new Scan();
		int numPocketmon = sc.nextInt();
		int numProblem = sc.nextInt();
		
		String[] poketmon = new String[numPocketmon+1];
		HashMap<String, Integer> poketmonDic = new HashMap<>();
		for(int i=1; i<=numPocketmon; i++){
			poketmon[i] = sc.next();
			poketmonDic.put(poketmon[i], i);
		}
		
		for(int i=0; i<numProblem; i++){
			String str =sc.next();
			if(str.matches("[0-9]+")){
				int numberPoket = Integer.parseInt(str);
				System.out.println(poketmon[numberPoket]);
			}else{
				System.out.println(poketmonDic.get(str));
			}
		}
	}
}
























