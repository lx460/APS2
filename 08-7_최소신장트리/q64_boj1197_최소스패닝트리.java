import java.io.*;
import java.util.*;

public class q64_boj1197_최소스패닝트리 {
	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int c;

		public Edge(int start, int end, int c) {
			this.start = start;
			this.end = end;
			this.c = c;
		}

		@Override
		public int compareTo(Edge o) {
			return this.c - o.c;
		}
	}

	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		Edge[] arr = new Edge[E];
		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[i] = new Edge(s, e, w);
		}
		Arrays.sort(arr);
		int cnt = 0;
		int result = 0;
		for (int i = 0; i < E; i++) {
			if (find(arr[i].start) != find(arr[i].end)) {
				union(arr[i].start, arr[i].end);
				cnt++;
				result += arr[i].c;
			}
			if (cnt == V - 1)
				break;
		}
		System.out.println(result);
	}

	static int find(int a) {
		if (parent[a] == a) {
			return a;
		} else {
			return parent[a] = find(parent[a]);
		}
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			parent[b] = a;
		}
	}
}
