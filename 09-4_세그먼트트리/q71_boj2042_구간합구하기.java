import java.io.*;
import java.util.*;

public class q71_boj2042_구간합구하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int sIdx = 0;
		int k = 0;
		while (N > Math.pow(2, k)) {
			k++;
		}
		sIdx = (int) Math.pow(2, k);
		int size = sIdx * 2;
		long[] tree = new long[size];
		for (int i = sIdx; i < sIdx + N; i++) {
			tree[i] = Long.parseLong(br.readLine());
		}
		for (int i = sIdx - 1; i > 0; i--) {
			tree[i] = tree[2 * i] + tree[2 * i + 1];
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if (a == 1) {
				int idx = sIdx + b - 1;
				long val = c - tree[idx];
				tree[idx] = c;
				idx /= 2;
				while (idx >= 1) {
					tree[idx] = tree[idx] + val;
					idx /= 2;
				}
			} // 바꾸기

			else {
				int start = b + sIdx - 1;
				int end = (int) c + sIdx - 1;
				long sum = 0;
				while (start <= end) {
					if (start % 2 == 1) {
						sum = sum + tree[start];
						start++;
					}
					if (end % 2 == 0) {
						sum = sum + tree[end];
						end--;
					}
					start = start / 2;
					end = end / 2;
				}
				sb.append(sum).append("\n");
			} // 구간합
		}
		System.out.println(sb.toString());
	}
}
