import java.io.*;
import java.util.*;

public class q75_boj11438_LCA2 {
	static boolean[] visited;
	static ArrayList<Integer>[] tree;
	static int[][] parent;
	static int[] depth;
	static int kmax;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		tree = new ArrayList[N + 1];
		depth = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		int temp = 1;
		kmax = 0;
		while (N >= temp) {
			temp *= 2;
			kmax++;
		}
		parent = new int[kmax + 1][N + 1];
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			tree[s].add(e);
			tree[e].add(s);
		}
		bfs(1);
		for (int i = 1; i <= kmax; i++) {
			for (int j = 1; j <= N; j++) {
				parent[i][j] = parent[i - 1][parent[i - 1][j]];
			}
		}
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(lca(a, b)).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int lca(int a, int b) {
		if (depth[a] > depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		for (int i = kmax; i >= 0; i--) {
			if (Math.pow(2, i) <= depth[b] - depth[a]) {
				if (depth[a] <= depth[parent[i][b]]) {
					b = parent[i][b];
				}
			}
		}
		for (int i = kmax; i >= 0; i--) {
			if (parent[i][a] != parent[i][b]) {
				a = parent[i][a];
				b = parent[i][b];
			}
		}
		int ans = a;
		if (a != b)
			ans = parent[0][ans];
		return ans;

	}

	static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		visited[n] = true;
		int size = 1;
		int level = 1;
		int cnt = 0;
		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int i : tree[curr]) {
				if (!visited[i]) {
					visited[i] = true;
					q.add(i);
					parent[0][i] = curr;
					depth[i] = level;
				}
			}
			cnt++;
			if (cnt == size) {
				size = q.size();
				level++;
				cnt = 0;
			}
		}
	}
}
