import java.io.*;
import java.util.*;

public class q38_boj1456_거의소수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		int length = 10000000;
		int cnt = 0;
		long[] arr = new long[length + 1];
		for (int i = 2; i <= length; i++) {
			arr[i] = i;
		}
		for (int i = 2; i <= Math.sqrt(length); i++) {
			if (arr[i] == 0)
				continue;
			for (int j = i + i; j <= length; j += i) {
				arr[j] = 0;
			}
		}
		for (int i = 2; i <= length; i++) {
			if (arr[i] != 0) {
				long tmp = arr[i];
				if (tmp > B)
					break;
				while ((double) arr[i] <= (double) B / (double) tmp) {
					if ((double) arr[i] >= (double) A / (double) tmp)
						cnt++;
					tmp *= arr[i];
				}
			}
		}
		System.out.println(cnt);

	}
}
