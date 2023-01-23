import java.io.*;

public class q39_boj1747_소수팰린드롬 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int length = 10000000;
		int[] arr = new int[length + 1];
		for (int i = 2; i <= length; i++) {
			arr[i] = i;
		}
		for (int i = 2; i <= Math.sqrt(length); i++) {
			if (arr[i] == 0)
				continue;
			for (int j = i * 2; j < length; j += i) {
				arr[j] = 0;
			}
		}
		for (int i = N; i <= length; i++) {
			if (arr[i] != 0) {
				String str = String.valueOf(i);
				StringBuilder sb = new StringBuilder(str);
				String reverse = sb.reverse().toString();
				if (str.equals(reverse)) {
					System.out.println(i);
					break;
				}
			}
		}
	}
}
