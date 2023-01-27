import java.io.*;

public class boj4355_서로소 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (;;) {
			long n = Long.parseLong(br.readLine());
			if (n == 0)
				break;
			long result = n;
			for (long i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {
					result = result - result / i;
					while (n % i == 0)
						n /= i;
				}
			}
			if (n > 1)
				result = result - result / n;
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
}
