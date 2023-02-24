import java.io.*;
import java.util.*;

public class boj1780_종이의개수 {
	static int[] dr = { 0, 0, 0, 1, 1, 1, 2, 2, 2 };
	static int[] dc = { 0, 1, 2, 0, 1, 2, 0, 1, 2 };
	static int[][] map;
	static boolean[][] visited;
	static int[] cnt = new int[3];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		recur(0, 0, map[0][0], N);
		for (int i = 0; i < 3; i++) {
			System.out.println(cnt[i]);
		}

	}

	static void recur(int r, int c, int start, int N) {
		if (N == 0)
			return;
		if (!visited[r][c])
			cnt[map[r][c] + 1]++;
		visited[r][c] = true;
		outer: for (int i = r; i < r + N; i++) {
			for (int j = c; j < c + N; j++) {
				if (map[i][j] != start) {
					for (int k = 0; k < 9; k++) {
						int nr = r + dr[k] * N / 3;
						int nc = c + dc[k] * N / 3;
						recur(nr, nc, map[nr][nc], N / 3);
					}
					break outer;
				}
			}
		}
	}
}
