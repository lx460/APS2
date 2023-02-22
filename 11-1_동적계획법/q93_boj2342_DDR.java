import java.io.*;
import java.util.*;

public class q93_boj2342_DDR {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][][] D = new int[100001][5][5];
		int mp[][] = { { 0, 2, 2, 2, 2 }, { 2, 1, 3, 4, 3 }, { 2, 3, 1, 3, 4 }, { 2, 4, 3, 1, 3 }, { 2, 3, 4, 3, 1 } };
		int cnt = 1;
		int n;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				for (int j2 = 0; j2 < 100001; j2++) {
					D[j2][i][j] = 100001 * 4;
				}
			}
		}
		D[0][0][0] = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		while (true) {
			n = Integer.parseInt(st.nextToken());
			if (n == 0) {
				break;
			}
			for (int i = 0; i < 5; i++) {
				if (n == i)
					continue;
				for (int j = 0; j < 5; j++) {
					D[cnt][i][n] = Math.min(D[cnt][i][n], D[cnt - 1][i][j] + mp[j][n]);
				}
			}
			for (int i = 0; i < 5; i++) {
				if (n == i)
					continue;
				for (int j = 0; j < 5; j++) {
					D[cnt][n][i] = Math.min(D[cnt][n][i], D[cnt - 1][i][j] + mp[j][n]);
				}
			}
			cnt++;
		}
		cnt--;
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				ans = Math.min(ans, D[cnt][i][j]);
			}
		}
		System.out.println(ans);
	}
}
