import java.io.*;
import java.util.*;

public class q36_boj1541_잃어버린괄호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		int ans = 0;
		boolean first = true;
		while (st.hasMoreTokens()) {
			int num = 0;
			StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");
			while (st2.hasMoreTokens()) {
				num += Integer.parseInt(st2.nextToken());
			}
			if (first) {
				ans += num;
				first = false;
			} else
				ans -= num;
		}
		System.out.println(ans);
	}
}
