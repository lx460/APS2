import java.io.*;
import java.util.*;

public class q56_boj1753_최단경로 {
	static class Node implements Comparable<Node> {
		int idx;
		int w;

		public Node(int idx, int w) {
			this.idx = idx;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		ArrayList<Node>[] adj = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adj[from].add(new Node(to, weight));
		}
		boolean[] visited = new boolean[V + 1];
		int[] route = new int[V + 1];
		Arrays.fill(route, Integer.MAX_VALUE);
		route[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (visited[cur.idx])
				continue;
			visited[cur.idx] = true;
			for (Node n : adj[cur.idx]) {
				if (route[n.idx] > route[cur.idx] + n.w) {
					route[n.idx] = route[cur.idx] + n.w;
					pq.add(new Node(n.idx, route[n.idx]));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (visited[i])
				sb.append(route[i]).append("\n");
			else
				sb.append("INF").append("\n");
		}
		System.out.println(sb.toString());
	}
}
