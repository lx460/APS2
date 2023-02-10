import java.io.*;
import java.util.*;

public class q67_boj11725_트리의부모찾기 {
	static ArrayList<Integer>[] adj;
	static int[] ans;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N + 1];
		ans = new int[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			adj[start].add(end);
			adj[end].add(start);
		}
		dfs(1);
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(ans[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void dfs(int num) {
		if (visited[num])
			return;
		visited[num] = true;
		for (int i : adj[num]) {
			if (!visited[i]) {
				ans[i] = num;
				dfs(i);
			}
		}
	}
}
