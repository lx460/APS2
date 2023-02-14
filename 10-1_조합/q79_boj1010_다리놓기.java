import java.io.*;
import java.util.*;

public class q79_boj1010_다리놓기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] D = new int[31][31];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 31; i++) {
			D[i][0] = 1;
			D[i][1] = i;
			D[i][i] = 1;
		}
		for (int i = 2; i < 31; i++) {
			for (int j = 2; j < i; j++) {
				D[i][j] = D[i - 1][j - 1] + D[i - 1][j];
			}
		}
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			sb.append(D[M][N]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
