import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q59_boj11657_타임머신 {
	static class Edge {
		int start, end, w;

		public Edge(int start, int end, int w) {
			this.start = start;
			this.end = end;
			this.w = w;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Edge[] e = new Edge[M + 1];
		long[] d = new long[N + 1];
		Arrays.fill(d, Integer.MAX_VALUE);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int ed = Integer.parseInt(st.nextToken());
			int we = Integer.parseInt(st.nextToken());
			e[i] = new Edge(s, ed, we);
		}
		d[1] = 0;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Edge edge = e[j];
				if (d[edge.start] != Integer.MAX_VALUE && d[edge.end] > d[edge.start] + edge.w)
					d[edge.end] = d[edge.start] + edge.w;
			}
		}
		boolean check = false;
		for (int i = 0; i < M; i++) {
			Edge edge = e[i];
			if (d[edge.start] != Integer.MAX_VALUE && d[edge.end] > d[edge.start] + edge.w)
				check = true;
		}
		if (!check) {
			for (int i = 2; i <= N; i++) {
				if (d[i] == Integer.MAX_VALUE)
					sb.append(-1).append("\n");
				else
					sb.append(d[i]).append("\n");
			}
		} else
			sb.append(-1).append("\n");
		System.out.println(sb.toString());
	}
}
