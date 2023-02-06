import java.io.*;
import java.util.*;

public class q57_boj1916_최소비용구하기 {
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
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<Node>[] adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		boolean[] visited = new boolean[N + 1];
		int[] cost = new int[N + 1];
		for (int i = 1; i <= M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adj[from].add(new Node(to, weight));
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (visited[curr.idx])
				continue;
			visited[curr.idx] = true;
			for (Node n : adj[curr.idx]) {
				if (cost[n.idx] > cost[curr.idx] + n.w) {
					cost[n.idx] = cost[curr.idx] + n.w;
					pq.add(new Node(n.idx, cost[n.idx]));
				}
			}
		}
		System.out.println(cost[end]);
	}
}
