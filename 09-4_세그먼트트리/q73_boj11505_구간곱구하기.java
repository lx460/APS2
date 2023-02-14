import java.io.*;
import java.util.*;

public class q73_boj11505_구간곱구하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int sIdx = 0;
		int k = 0;
		long mod = 1000000007;
		while (N > Math.pow(2, k)) {
			k++;
		}
		sIdx = (int) Math.pow(2, k);
		int size = sIdx * 2;
		long[] tree = new long[size];
		Arrays.fill(tree, 1);
		for (int i = sIdx; i < sIdx + N; i++) {
			tree[i] = Long.parseLong(br.readLine());
		}
		for (int i = sIdx - 1; i > 0; i--) {
			tree[i] = ((tree[2 * i] % mod) * (tree[2 * i + 1] % mod)) % mod;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()) + sIdx - 1;
			long c = Long.parseLong(st.nextToken());
			if (a == 1) // 바꾸기
			{
				long val = tree[b];
				tree[b] = c;
				b /= 2;
				while (b >= 1) {
					if (tree[b] == 0)
						tree[b] = 0;
					else
						tree[b] = tree[b] / val * (c % mod);
					b /= 2;
				}
			}
			long ans = 1;
			if (a == 2) // 구간곱
			{
				c = c + sIdx - 1;
				while (b <= c) {
					if (b % 2 == 1) {
						ans = ans * tree[b] % mod;
						b++;
					}
					if (c % 2 == 0) {
						ans = ans * tree[(int) c] % mod;
						c--;
					}
					b /= 2;
					c /= 2;
				}
				sb.append(ans).append("\n");
			}

		}
		System.out.println(sb.toString());
	}
}
