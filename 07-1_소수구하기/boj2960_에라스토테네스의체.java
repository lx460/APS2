import java.io.*;
import java.util.*;

public class boj2960_에라스토테네스의체 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt = 0;
		boolean[] isPrime = new boolean[N + 1];
		for (int i = 2; i <= N; i++) {
			if (isPrime[i])
				continue;
			for (int j = i; j <= N; j += i) {
				if (!isPrime[j]) {
					isPrime[j] = true;
					cnt++;
					if (cnt == K) {
						System.out.println(j);
						break;
					}
				}
			}
		}

	}
}
