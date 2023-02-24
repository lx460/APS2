import java.io.*;
import java.util.*;

public class boj1992_쿼드트리 {
	static int[][] map;
	static int size;
	static boolean visited[][];
	static StringBuilder sb;
	static int[] dr = { 0, 0, 1, 1 };
	static int[] dc = { 0, 1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		size = N;
		int ans = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
				ans += map[i][j];
			}
		}

		if (ans == N * N || ans == 0) {
			sb.append(map[0][0]);
		} else
			quadtree(0, 0, map[0][0], N);
		System.out.println(sb.toString());
	}

	static void quadtree(int r, int c, int start, int N) {
		if (N == 0)
			return;

		outer: for (int i = r; i < r + N; i++) {
			for (int j = c; j < c + N; j++) {
				if (start != map[i][j]) {
					sb.append("(");
					for (int k = 0; k < 4; k++) {
						int nr = r + dr[k] * N / 2;
						int nc = c + dc[k] * N / 2;
						quadtree(nr, nc, map[nr][nc], N / 2);
						if (!visited[nr][nc]) {
							visited[nr][nc] = true;
							sb.append(map[nr][nc]);
						}
					}
					sb.append(")");
					break outer;
				}
			}
		}

	}
}
