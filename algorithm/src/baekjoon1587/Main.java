package baekjoon1587;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	
	static int numA,numB,numLink;
	static ArrayList<Integer>[] links;
	static int[] matchA, matchB;
	static boolean[] check;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scan sc = new Scan();
		numA = sc.nextInt();
		numB = sc.nextInt();
		numLink = sc.nextInt();
		int result = numA/2 + numB/2;
        if(numA%2==1 && numB%2==1){
            for(int i=0; i<numLink; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                if(a%2==1 && b%2==1){
                    result++;
                    break;
                }
            }
        }
        System.out.println(result);
	}
}
