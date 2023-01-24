
import java.io.*;
import java.util.*;

public class boj4948_베르트랑공준 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int length = 123456 * 2;
		int[] arr = new int[length + 1];
		for (int i = 2; i <= length; i++) {
			arr[i] = i;
		}
		for (int i = 2; i <= Math.sqrt(length); i++) {
			if (arr[i] == 0)
				continue;
			for (int j = i * 2; j <= length; j += i) {
				arr[j] = 0;
			}
		}
		for (;;) {
			int n = Integer.parseInt(br.readLine());
			int cnt = 0;
			if (n == 0)
				break;
			for (int i = n + 1; i <= 2 * n; i++) {
				if (arr[i] != 0)
					cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
}
