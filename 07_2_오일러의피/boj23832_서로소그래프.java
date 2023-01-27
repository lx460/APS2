import java.io.*;

public class boj23832_서로소그래프 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		if (N == 1) {
			System.out.println(0);
			System.exit(0);
		}
		for (int i = 2; i <= N; i++) {
			int result = i;
			int bot = i;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (bot % j == 0) {
					result = result - result / j;
				}
				while (bot % j == 0) {
					bot /= j;
				}
			}
			if (bot > 1)
				result = result - result / bot;
			sum += result;
		}
		System.out.println(sum);
	}
}
