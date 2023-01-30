import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q43_boj1850_최대공약수 {
	static long gcd(long a, long b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		long cnt = gcd(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
		for(int i =1; i<=cnt; i++) {
			sb.append(1);
		}
		System.out.println(sb.toString());
	}
}
