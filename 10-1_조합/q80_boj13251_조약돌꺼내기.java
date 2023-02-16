import java.io.*;
import java.util.*;

public class q80_boj13251_조약돌꺼내기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		double[] stone = new double[M + 1];
		double[] percent = new double[M + 1]; // 확률
		double sum = 0;
		double ans = 0.0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			stone[i] = Double.parseDouble(st.nextToken());
			sum += stone[i];
		}
		int K = Integer.parseInt(br.readLine());
		for (int i = 1; i <= M; i++) {
			int cnt = 0;
			if (stone[i] >= K) {
				percent[i] = 1.0;
				for (int j = 0; j < K; j++) {
					percent[i] *= (stone[i] - j) / (sum - j);
				}
			}
			ans += percent[i];

		}
		System.out.println(ans);

	}
}
