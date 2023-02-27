import java.io.*;
import java.util.*;

public class boj5525_IOIOI {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String checkStr = br.readLine();
		int cnt = 0;
		int res = 0;
		for (int i = 1; i < M - 1; i++) {
			if (checkStr.charAt(i - 1) == 'I' && checkStr.charAt(i) == 'O' && checkStr.charAt(i + 1) == 'I') {
				cnt++;
				if (cnt == N) {
					cnt--;
					res++;
				}
				i++;
			} else {
				cnt = 0;
			}
		}
		System.out.println(res);
	}
}
