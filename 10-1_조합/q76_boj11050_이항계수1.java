import java.io.*;
import java.util.*;

public class q76_boj11050_이항계수1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			arr[i][1] = i;
			arr[i][0] = 1;
			arr[i][i] = 1;
		}
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
			}
		}
		System.out.println(arr[N][K]);
	}
}
