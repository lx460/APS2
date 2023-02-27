import java.io.*;
import java.util.*;

public class boj9375_패션왕신해빈 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			HashMap<String, Integer> fashion = new HashMap<>();
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();
				String str = st.nextToken();
				if (fashion.containsKey(str)) {
					fashion.put(str, fashion.get(str) + 1);
				} else {
					fashion.put(str, 1);
				}
			}
			int result = 1;
			for (int i : fashion.values()) {
				result *= (i + 1);
			}
			sb.append(result - 1).append("\n");
		}
		System.out.println(sb.toString());
	}
}
