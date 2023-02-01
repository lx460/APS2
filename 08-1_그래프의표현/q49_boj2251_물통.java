import java.io.*;
import java.util.*;

public class q49_boj2251_물통 {
	static int[] from = { 0, 0, 1, 1, 2, 2 };
	static int[] to = { 1, 2, 0, 2, 0, 1 };
	static boolean[][] visited;
	static boolean[] answer;
	static int[] now;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		now = new int[3];
		visited = new boolean[201][201];
		answer = new boolean[201];
		now[0] = Integer.parseInt(st.nextToken());
		now[1] = Integer.parseInt(st.nextToken());
		now[2] = Integer.parseInt(st.nextToken());
		BFS();
		for (int i = 0; i < answer.length; i++) {
			if (answer[i])
				sb.append(i + " ");
		}
		System.out.println(sb.toString());
	}

	static void BFS() {
		Queue<AB> q = new LinkedList<>();
		q.add(new AB(0, 0));
		while (!q.isEmpty()) {
			AB curr = q.poll();
			for (int i = 0; i < 6; i++) {
				int[] next = { curr.A, curr.B, now[2] - curr.A - curr.B };
				next[to[i]] += next[from[i]];
				next[from[i]] = 0;
				if (next[to[i]] > now[to[i]]) {
					next[from[i]] = next[to[i]] - now[to[i]];
					next[to[i]] = now[to[i]];
				}
				if (!visited[next[0]][next[1]]) {
					visited[next[0]][next[1]] = true;
					q.add(new AB(next[0], next[1]));
					if (next[0] == 0)
						answer[next[2]] = true;
				}
			}
		}
	}

	static class AB {
		int A;
		int B;

		public AB(int A, int B) {
			this.A = A;
			this.B = B;
		}
	}
}
