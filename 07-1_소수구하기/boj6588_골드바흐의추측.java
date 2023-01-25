import java.io.*;
import java.util.*;

public class boj6588_골드바흐의추측 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int length = 1000000;
		boolean[] isPrime = new boolean[length + 1];
		isPrime[0] = true;
		isPrime[1] = true;
		for (int i = 2; i <= Math.sqrt(length); i++) {
			if (isPrime[i])
				continue;
			for (int j = i * 2; j <= length; j += i) {
				isPrime[j] = true;
			}
		}
		for (;;) {
			int n = Integer.parseInt(br.readLine());
			boolean flag = false;
			if (n == 0)
				break;
			int left = 3;
			int right = n - 3;
			while (isPrime[left] || isPrime[right]) {
				left++;
				right--;
				if (left > length || right < 0) {
					flag = true;
					break;
				}
			}
			if (flag)
				sb.append("Goldbach's conjecture is wrong.").append("\n");
			else
				sb.append(n + " = ").append(left + " + ").append(right + "\n");
		}
		System.out.println(sb.toString());
	}
}
