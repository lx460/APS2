import java.io.*;
import java.util.*;

public class q78_boj2775_부녀회장이될테야 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[][] D = new int[15][15];
		for (int i = 0; i < 15; i++) {
			D[0][i] = i;
			D[i][1] = 1;
		}

		for (int i = 1; i < 15; i++) {
			for (int j = 2; j < 15; j++) {
				D[i][j] = D[i][j - 1] + D[i - 1][j];
			}
		}
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());
			int N = Integer.parseInt(br.readLine());
			sb.append(D[K][N]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
