import java.io.*;
import java.util.*;

public class boj1766_문제집 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] adj = new ArrayList[N + 1];
		int[] indegree = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adj[from].add(to);
			indegree[to]++;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0)
				pq.add(i);
		}
		while (!pq.isEmpty()) {
			int curr = pq.poll();
			sb.append(curr + " ");
			for (int i : adj[curr]) {
				indegree[i]--;
				if (indegree[i] == 0)
					pq.add(i);
			}
		}
		System.out.println(sb.toString());
	}
}
