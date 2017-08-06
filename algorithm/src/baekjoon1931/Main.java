package baekjoon1931;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if(a[1]-b[1] == 0) {
					return a[0]-b[0];
				} else {
					return a[1]-b[1];
				}
			}
		});
		
		int tmp = 0;
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			if(arr[i][0] >= tmp) {
				tmp = arr[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
}
