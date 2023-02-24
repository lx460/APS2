import java.io.*;
import java.util.*;

public class boj2447_별찍기10 {
	static StringBuilder sb;
	static char[][] star;
	static int[] dr = { 0, 0, 0, 1, 1, 1, 2, 2, 2 };
	static int[] dc = { 0, 1, 2, 0, 1, 2, 0, 1, 2 };
	static boolean visited[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		star = new char[N][N];
		visited = new boolean[N][N];
		StringBuilder sb = new StringBuilder();
		recur(0, 0, N, '*');
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(star[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static void recur(int r, int c, int N, char start) {
		if (N == 0)
			return;
		for (int i = 0; i < 9; i++) {
			int nr = r + dr[i] * N / 3;
			int nc = c + dc[i] * N / 3;
			if (!visited[nr][nc]) {
				if (start == ' ')
					star[nr][nc] = ' ';
				else {
					if (i == 4) {
						star[nr][nc] = ' ';
					} else {
						star[nr][nc] = '*';
					}
				}
			}
			visited[nr][nc] = true;
			recur(nr, nc, N / 3, star[nr][nc]);
		}
	}
}
