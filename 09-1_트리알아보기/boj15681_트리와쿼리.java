import java.io.*;
import java.util.*;

public class boj15681_트리와쿼리 {
	static int N;
	static boolean[] visited;
	static int[] size;
	static ArrayList<Integer>[] adj;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		size = new int[N + 1];
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adj[from].add(to);
			adj[to].add(from);
		}
		dfs(R);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			sb.append(size[Integer.parseInt(br.readLine())]).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int dfs(int n) {
		if (size[n] != 0)
			return size[n];
		visited[n] = true;
		int cnt = 1;
		for (int i : adj[n]) {
			if (visited[i])
				continue;
			cnt += dfs(i);
		}
		size[n] = cnt;
		return size[n];
	}
}
