import java.io.*;
import java.util.*;

public class q99_boj2162_선분그룹 {
	static class Segment {
		long x1, y1, x2, y2;

		public Segment(long x1, long y1, long x2, long y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}

	static int parent[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Segment[] s = new Segment[N + 1];
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = -1;
		}
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			s[i] = new Segment(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()),
					Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
			for (int j = 1; j < i; j++) {
				if (isCross(s[i].x1, s[i].y1, s[i].x2, s[i].y2, s[j].x1, s[j].y1, s[j].x2, s[j].y2)) {
					union(i, j);
				}
			}
		}
		int group = 0;
		int max = 0;
		for (int i = 1; i <= N; i++) {
			if (parent[i] < 0) {
				group++;
				max = Math.min(max, parent[i]);
			}
		}
		System.out.println(group);
		System.out.println(max * -1);
	}

	static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
		long temp = (x1 * y2 + x2 * y3 + x3 * y1) - (x1 * y3 + x3 * y2 + x2 * y1);
		if (temp > 0)
			return 1;
		else if (temp < 0)
			return -1;
		return 0;
	}

	static boolean isCross(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
		int abc = ccw(x1, y1, x2, y2, x3, y3);
		int abd = ccw(x1, y1, x2, y2, x4, y4);
		int cda = ccw(x3, y3, x4, y4, x1, y1);
		int cdb = ccw(x3, y3, x4, y4, x2, y2);
		if (abc * abd == 0 && cda * cdb == 0) {
			if (Math.min(x1, x2) <= Math.max(x3, x4) && Math.min(x3, x4) <= Math.max(x1, x2)
					&& Math.min(y1, y2) <= Math.max(y3, y4) && Math.min(y3, y4) <= Math.max(y1, y2))
				return true;
			return false;
		} else if (abc * abd <= 0 && cda * cdb <= 0) {
			return true;
		}
		return false;
	}

	static int find(int a) {
		if (parent[a] < 0)
			return a;
		return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return;
		parent[a] += parent[b];
		parent[b] = a;
	}
}
