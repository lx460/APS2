import java.io.*;
import java.util.*;

public class q65_boj17472_다리만들기2 {
	static int[] dr = { -1, 0, 1, 0 }; // 상우하좌
	static int[] dc = { 0, 1, 0, -1 }; // 상우하좌
	static boolean[][] visited;
	static int[][] map;
	static int N, M;
	static int cnt;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					dfs(i, j);
					map[i][j] = cnt;
					cnt++;
				}
			}
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		ArrayList<Edge> list = new ArrayList<>();
		parent = new int[cnt];
		for (int i = 1; i < cnt; i++) {
			parent[i] = i;
		}
		// 다리 연결해서 각 엣지마다 가장 적은수로 갱신
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int start = map[i][j];
				if (map[i][j] != 0) {
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						int length = 0;
						if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[i][j] == map[nr][nc])
							continue;
						for (;;) {
							nr += dr[k];
							nc += dc[k];
							length++;
							if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[i][j] == map[nr][nc])
								break;
							if (map[nr][nc] != 0 && map[nr][nc] != map[i][j]) {
								if (length >= 2) {
									list.add(new Edge(start, map[nr][nc], length));
//									System.out.println(i + " " + j);
//									System.out.println(nr + " " + nc);
								}
								break;
							}
						}
					}
				}
			}
		}
		Collections.sort(list);
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).start + " " + list.get(i).end + " " + list.get(i).distance);
//		}
		int cnt2 = 0;
		int result = 0;
		for (int i = 0; i < list.size(); i++) {
			if (find(list.get(i).start) != find(list.get(i).end)) {
				union(list.get(i).start, list.get(i).end);
				cnt2++;
				result += list.get(i).distance;
			}
			if (cnt2 == cnt - 2)
				break;
		}
		if (cnt2 != cnt - 2)
			result = -1;
		System.out.println(result);
	}

	static void dfs(int r, int c) {
		if (visited[r][c])
			return;
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M)
				continue;
			if (!visited[nr][nc] && map[nr][nc] == 1) {
				map[nr][nc] = cnt;
				dfs(nr, nc);
			}
		}
	}

	static class Edge implements Comparable<Edge> {
		int start, end, distance;

		public Edge(int start, int end, int distance) {
			this.start = start;
			this.end = end;
			this.distance = distance;
		}

		@Override
		public int compareTo(Edge o) {
			return this.distance - o.distance;
		}
	}

	static int find(int a) {
		if (parent[a] == a)
			return a;
		else
			return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			parent[b] = a;
		}
	}
}
