import java.io.*;
import java.util.*;

public class q51_boj1976_여행가자 {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] city = new int[N + 1][N + 1];
		int[] route = new int[M + 1];
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= M; i++) {
			route[i] = Integer.parseInt(st.nextToken());
		}
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (city[i][j] == 1)
					union(i, j);
			}
		}
		int idx = find(route[1]);
		for (int i = 2; i <= M; i++) {
			if (idx != find(route[i])) {
				System.out.println("NO");
				System.exit(0);
			}
		}
		System.out.println("YES");
	}

	static int find(int a) {
		if (a == parent[a])
			return a;
		return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b)
			parent[b] = a;

	}
}
