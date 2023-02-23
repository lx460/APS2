import java.io.*;
import java.util.*;

public class q98_boj17387_선분교차2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long x1 = Long.parseLong(st.nextToken());
		long y1 = Long.parseLong(st.nextToken());
		long x2 = Long.parseLong(st.nextToken());
		long y2 = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		long x3 = Long.parseLong(st.nextToken());
		long y3 = Long.parseLong(st.nextToken());
		long x4 = Long.parseLong(st.nextToken());
		long y4 = Long.parseLong(st.nextToken());
		int ans = 0;
		int ABC = CCW(x1, y1, x2, y2, x3, y3);
		int ABD = CCW(x1, y1, x2, y2, x4, y4);
		int CDA = CCW(x3, y3, x4, y4, x1, y1);
		int CDB = CCW(x3, y3, x4, y4, x2, y2);
		if (ABC * ABD == 0 && CDA * CDB == 0) {
			long maxX1 = Math.max(x1, x2);
			long minX1 = Math.min(x1, x2);
			long maxX2 = Math.max(x3, x4);
			long minX2 = Math.min(x3, x4);
			long maxY1 = Math.max(y1, y2);
			long minY1 = Math.min(y1, y2);
			long maxY2 = Math.max(y3, y4);
			long minY2 = Math.min(y3, y4);
			if (maxX1 >= minX2 && maxY1 >= minY2 && maxX2 >= minX1 && maxY2 >= minY1)
				ans = 1;
			else
				ans = 0;
		} else if (ABC * ABD <= 0 && CDA * CDB <= 0) {
			ans = 1;
		} else
			ans = 0;
		System.out.println(ans);
	}

	static int CCW(long x1, long y1, long x2, long y2, long x3, long y3) {
		long res = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);
		if (res > 0)
			return 1;
		else if (res == 0)
			return 0;
		else
			return -1;
	}

}
