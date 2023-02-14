import java.io.*;
import java.util.*;

public class q72_boj10868_최솟값 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int sIdx = 0;
		int k = 0;
		while (N > Math.pow(2, k)) {
			k++;
		}
		sIdx = (int) Math.pow(2, k);
		int size = sIdx * 2;
		int[] tree = new int[size];
		Arrays.fill(tree, Integer.MAX_VALUE);
		for (int i = sIdx; i < sIdx + N; i++) {
			tree[i] = Integer.parseInt(br.readLine());
		}
		for (int i = sIdx - 1; i > 0; i--) {
			tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken()) + sIdx - 1;
			int end = Integer.parseInt(st.nextToken()) + sIdx - 1;
			int ans = Integer.MAX_VALUE;
			while (start <= end) {
				if (start % 2 == 1) {
					ans = Math.min(tree[start], ans);
					start++;
				}
				if (end % 2 == 0) {
					ans = Math.min(tree[end], ans);
					end--;
				}
				start /= 2;
				end /= 2;
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
}
