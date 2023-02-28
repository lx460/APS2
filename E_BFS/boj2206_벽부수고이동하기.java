import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2206_벽부수고이동하기 {
	static int map[][];
	static boolean visited[][][];
	static int min, N, M;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Node {
		int r, c, check, dis;

		public Node(int r, int c, int check, int dis) {
			this.r = r;
			this.c = c;
			this.check = check;
			this.dis = dis;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		min = Integer.MAX_VALUE;
		bfs();
		if (min == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(min);
		}
	}

	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 0, 1));
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			Node curr = q.poll();
			if (curr.r == N - 1 && curr.c == M - 1) {
				min = Math.min(curr.dis, min);
			}

			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (visited[nr][nc][curr.check]) {
						continue;
					}

					if (map[nr][nc] == 0) {
						visited[nr][nc][curr.check] = true;
						q.add(new Node(nr, nc, curr.check, curr.dis + 1));
					} else if (map[nr][nc] == 1 && curr.check == 0) {
						visited[nr][nc][1] = true;
						q.add(new Node(nr, nc, 1, curr.dis + 1));
					}
				}
			}
		}
	}
}
