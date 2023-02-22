import java.io.*;
import java.util.*;

public class q92_boj1328_고층빌딩 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		long[][][] D = new long[N + 1][L + 1][R + 1];
		D[1][1][1] = 1;
		long mod = 1000000007;
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= L; j++) {
				for (int j2 = 1; j2 <= R; j2++) {
					D[i][j][j2] = ((D[i - 1][j][j2 - 1] + D[i - 1][j - 1][j2]) + D[i - 1][j][j2] * (i - 2)) % mod;
				}
			}
		}
		System.out.println(D[N][L][R]);
	}
}
