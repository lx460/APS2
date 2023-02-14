import java.io.*;
import java.util.*;

public class q74_boj11437_LCA {
	static class Node {
		int parent, depth;

		public Node(int parent, int depth) {
			this.parent = parent;
			this.depth = depth;
		}
	}

	static boolean[] visited;
	static ArrayList<Integer>[] tree;
	static Node[] nodes;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		tree = new ArrayList[N + 1];
		nodes = new Node[N + 1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
			nodes[i] = new Node(0, 0);
		}
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			tree[s].add(e);
			tree[e].add(s);
		}
		bfs(1);
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
		if (nodes[a].depth < nodes[b].depth) {
			int temp = a;
			a = b;
			b = temp;
		}
		while (nodes[a].depth != nodes[b].depth) {
			a = nodes[a].parent;
		}
		while (a != b) {
			a = nodes[a].parent;
			b = nodes[b].parent;
		}
		return a;

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
					nodes[i].parent = curr;
					nodes[i].depth = level;
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
