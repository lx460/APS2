import java.io.*;
import java.util.*;

public class q89_boj13398_연속합2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		int[] left = new int[n + 1];
		int[] right = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		left[1] = arr[1];
		right[n] = arr[n];
		int result = left[1];
		for (int i = 2; i <= n; i++) {
			left[i] = Math.max(arr[i], left[i - 1] + arr[i]);
			result = Math.max(left[i], result);
		}
		for (int i = n - 1; i >= 1; i--) {
			right[i] = Math.max(arr[i], right[i + 1] + arr[i]);
		}
		for (int i = 1; i <= n - 1; i++) {
			result = Math.max(result, left[i - 1] + right[i + 1]);
		}
		System.out.println(result);
	}
}
