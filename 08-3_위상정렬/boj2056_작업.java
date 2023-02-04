import java.io.*;
import java.util.*;

public class boj2056_작업 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] adj = new ArrayList[N + 1];
		int[] buildTime = new int[N + 1];
		int[] indegree = new int[N + 1];
		int[] result = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			buildTime[i] = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= cnt; j++) {
				int end = Integer.parseInt(st.nextToken());
				adj[i].add(end);
				indegree[end]++;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0)
				q.add(i);
		}
		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int i : adj[curr]) {
				result[i] = Math.max(result[i], result[curr] + buildTime[curr]);
				indegree[i]--;
				if (indegree[i] == 0)
					q.add(i);
			}
		}
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, result[i] + buildTime[i]);
		}
		System.out.println(ans);
	}
}
