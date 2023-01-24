import java.io.*;
import java.util.*;

public class boj15711_환상의짝꿍 {
	static boolean[] arr = new boolean[2000001];
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		isPrime(); // 여러번 너무 돌렸음
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			long sum = Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken());
			if (sum < 4) {
				sb.append("NO").append("\n");
			} else if (sum % 2 == 0) {
				sb.append("YES").append("\n");
			} else {
				if (check(sum - 2))
					sb.append("YES").append("\n");
				else
					sb.append("NO").append("\n");
			}
		}

		System.out.println(sb.toString());
	}

	static boolean check(long n) {
		if (n <= 2000000) {
			return !arr[(int) n];
		}
		for (int i = 0; i < list.size(); i++) {
			if (n % list.get(i) == 0)
				return false;
		}
		return true;

	}

	static void isPrime() {
		arr[0] = arr[1] = true;
		for (int i = 2; i <= 2000000; i++) {
			if (!arr[i]) {
				list.add(i);
			}
			for (int j = i * 2; j <= 2000000; j += i) {
				arr[j] = true;
			}
		}
	}
}
