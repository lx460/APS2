import java.io.*;
import java.util.*;

public class boj9020_골드바흐의추측 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		boolean[] isPrime = new boolean[10001];
		isPrime[0] = true;
		isPrime[1] = true;
		for (int i = 2; i <= Math.sqrt(10000); i++) {
			if (isPrime[i]) {
				continue;
			}
			for (int j = i * 2; j <= 10000; j += i) {
				isPrime[j] = true;
			}
		}
		for (int i = 1; i <= T; i++) {
			int n = Integer.parseInt(br.readLine());
			int left = n / 2;
			int right = n / 2;
			while (isPrime[left] || isPrime[right]) {
				left--;
				right++;
			}
			sb.append(left).append(" ").append(right).append("\n");
		}
		System.out.println(sb.toString());
	}
}
