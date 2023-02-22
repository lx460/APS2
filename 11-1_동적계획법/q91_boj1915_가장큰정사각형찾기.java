import java.io.*;
import java.util.*;

public class q91_boj1915_가장큰정사각형찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[][] D = new long[n][m];
		long max = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				D[i][j] = Long.parseLong(String.valueOf(str.charAt(j)));
				if (D[i][j] == 1 && i > 0 && j > 0) {
					D[i][j] = Math.min(D[i - 1][j - 1], Math.min(D[i - 1][j], D[i][j - 1])) + D[i][j];
				}
				max = Math.max(max, D[i][j]);
			}
		}
		System.out.println(max * max);
	}
}
