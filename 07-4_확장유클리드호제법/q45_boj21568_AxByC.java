import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q45_boj21568_AxByC {

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
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		long gcd = gcd(a, b);
		if (c % gcd != 0) {
			sb.append(-1);
		} else {
			int qu = (int) (c / gcd);
			long[] ret = excute(a, b);
			sb.append(ret[0] * qu + " " + ret[1] * qu);
		}
		System.out.println(sb.toString());
	}

	static long[] excute(long a, long b) {
		long[] ret = new long[2];
		if (b == 0) {
			ret[0] = 1;
			ret[1] = 0;
			return ret;
		}
		long q = a / b;
		long[] v = excute(b, a % b);
		ret[0] = v[1];
		ret[1] = v[0] - v[1] * q;
		return ret;
	}
}
