import java.io.*;
import java.util.*;

public class boj1074_Z {
	static int[] zr = { 0, 0, 1, 1 };
	static int[] zc = { 0, 1, 0, 1 };
	static int ansr, ansc;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		ansr = Integer.parseInt(st.nextToken());
		ansc = Integer.parseInt(st.nextToken());
		int start = 0;
		Z(0, 0, start, N); //숲으로 나무만들기
	}

	static void Z(int r, int c, int start, int N) {
		if (N == 0)
			return;
		for (int i = 0; i < 4; i++) {
			int nr = r + zr[i] * (int) Math.pow(2, N - 1);
			int nc = c + zc[i] * (int) Math.pow(2, N - 1);
			int next = start + i * (int) Math.pow(2, 2 * (N - 1));
			if (nr == ansr && nc == ansc) {
				System.out.println(next);
				System.exit(0);
			}
			if (nr + (int) Math.pow(2, N - 1) > ansr && nc + (int) Math.pow(2, N - 1) > ansc) {
				Z(nr, nc, next, N - 1);
			}
		}
	}
}
