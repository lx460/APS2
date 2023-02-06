import java.io.*;

public class boj4355_서로소 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (;;) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			long result = n;
			if (n == 1) //1일때 조건 
				result = 0;

			for (long i = 2; i * i <= n; i++) {
				if (n % i == 0) {
					while (n % i == 0) {
						n /= i;
					}
					result -= result / i;
				}
			}
			if (n > 1) {
				result -= result / n;
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
}
