import java.util.*;
import java.io.*;

public class q37_boj1929_소수구하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];
		for (int i = 2; i <= N; i++) {
			arr[i] = i;
		}
		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (arr[i] == 0)
				continue;
			for (int j = i * 2; j <= N; j = j + i) {
				arr[j] = 0;
			}
		}
		for (int i = M; i <= N; i++) {
			if (arr[i] != 0)
				sb.append(i).append("\n");
		}
		System.out.println(sb.toString());
	}
}
