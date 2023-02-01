import java.io.*;
import java.util.*;

public class boj1005_ACMcraft {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			ArrayList<Integer> adj[] = new ArrayList[N + 1];
			int[] buildTime = new int[N + 1];
			int[] indegree = new int[N + 1];
			int[] result = new int[N + 1];
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 1; j <= N; j++) {
				buildTime[j] = Integer.parseInt(st.nextToken());
			}

			for (int j = 1; j <= N; j++) {
				adj[j] = new ArrayList<>();
			}

			for (int j = 1; j <= K; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				adj[start].add(end);
				indegree[end]++;
			}

			Queue<Integer> q = new LinkedList<>();
			for (int j = 1; j <= N; j++) {
				if (indegree[j] == 0)
					q.add(j);
			}
			while (!q.isEmpty()) {
				int curr = q.poll();
				for (int j : adj[curr]) {
					indegree[j]--;
					result[j] = Math.max(result[j], result[curr] + buildTime[curr]);
					if (indegree[j] == 0)
						q.add(j);
				}
			}
			int W = Integer.parseInt(br.readLine());
			sb.append(result[W] + buildTime[W]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
