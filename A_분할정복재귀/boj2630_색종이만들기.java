import java.io.*;
import java.util.*;

public class boj2630_색종이만들기 {
	static int[][] map;
	static boolean[][] visited;
	static int[] cnt;
	static int[] dr = { 0, 0, 1, 1 };
	static int[] dc = { 0, 1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		cnt = new int[2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		recur(0, 0, N, map[0][0]);
		System.out.println(cnt[0]);
		System.out.println(cnt[1]);
	}

	static void recur(int r, int c, int N, int start) {
		if (N == 0)
			return;
		if (!visited[r][c]) {
			cnt[map[r][c]]++;
		}
		visited[r][c] = true;

		outer: for (int i = r; i < r + N; i++) {
			for (int j = c; j < c + N; j++) {
				if (start != map[i][j]) {
					for (int k = 0; k < 4; k++) {
						int nr = r + dr[k] * N / 2;
						int nc = c + dc[k] * N / 2;
						recur(nr, nc, N / 2, map[nr][nc]);
					}
					break outer;
				}
			}
		}
	}
}
