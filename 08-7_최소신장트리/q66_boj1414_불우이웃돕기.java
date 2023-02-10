import java.io.*;
import java.util.*;

public class q66_boj1414_불우이웃돕기 {
	static class Edge implements Comparable<Edge> {
		int start, end, length;

		public Edge(int start, int end, int length) {
			this.start = start;
			this.end = end;
			this.length = length;
		}

		@Override
		public int compareTo(Edge o) {
			return this.length - o.length;
		}
	}

	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		int[][] room = new int[N + 1][N + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= N; j++) {
				if (str.charAt(j - 1) >= 'a' && str.charAt(j - 1) <= 'z')
					room[i][j] = str.charAt(j - 1) - 'a' + 1;
				else if (str.charAt(j - 1) >= 'A' && str.charAt(j - 1) <= 'Z')
					room[i][j] = str.charAt(j - 1) - 'A' + 27;
				if (i != j && room[i][j] > 0) {
					pq.add(new Edge(i, j, room[i][j]));
				}
				sum += room[i][j];
			}
		}
		int cnt = 0;
		int mSum = 0;
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
//			System.out.println(e.start + " " + e.end + " " + e.length);
			if (find(e.start) != find(e.end)) {
				cnt++;
				union(e.start, e.end);
				mSum += e.length;
			}
		}
		if (cnt == N - 1)
			System.out.println(sum - mSum);
		else
			System.out.println(-1);
	}

	static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b)
			parent[b] = a;
	}
}
