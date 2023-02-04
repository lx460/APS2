import java.io.*;
import java.util.*;

public class boj9470_Strahler순서 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int K = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			ArrayList<Integer>[] adj = new ArrayList[M + 1];
			int[] depth = new int[M + 1];
			int[] indegree = new int[M + 1];
			int[] maxCnt = new int[M + 1];
			for (int i = 1; i <= M; i++) {
				adj[i] = new ArrayList<>();
			}
			for (int i = 1; i <= P; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				adj[A].add(B);
				indegree[B]++;
			}
			Queue<Integer> q = new LinkedList<>();
			for (int i = 1; i <= M; i++) {
				if (indegree[i] == 0) {
					q.offer(i);
					depth[i] = 1;
					maxCnt[i] = 1;
				}
			}
			while (!q.isEmpty()) {
				int curr = q.poll();
				if (maxCnt[curr] >= 2)
					depth[curr]++;
				for (int i : adj[curr]) {
					indegree[i]--;
					if (indegree[i] == 0) {
						q.offer(i);
					}
					if (depth[i] < depth[curr]) {
						depth[i] = depth[curr];
						maxCnt[i] = 1;
					} else if (depth[i] == depth[curr]) {
						maxCnt[i]++;
					}
				}
			}
			sb.append(K).append(" ").append(depth[M]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
