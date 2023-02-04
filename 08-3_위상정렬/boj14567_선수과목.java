import java.io.*;
import java.util.*;

public class boj14567_선수과목 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] adj = new ArrayList[N + 1];
		int[] indegree = new int[N + 1];
		int[] depth = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			adj[start].add(end);
			indegree[end]++;
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0)
				q.offer(i);
		}
		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int i : adj[curr]) {
				depth[i] = depth[curr] + 1;
				indegree[i]--;
				if (indegree[i] == 0)
					q.offer(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(depth[i] + 1).append(" ");
		}
		System.out.println(sb.toString());
	}
}
