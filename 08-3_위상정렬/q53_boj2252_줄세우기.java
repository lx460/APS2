import java.io.*;
import java.util.*;

public class q53_boj2252_줄세우기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> A[] = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<>();
		}
		int[] indegree = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			A[S].add(E);
			indegree[E]++;
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0)
				q.add(i);
		}
		while (!q.isEmpty()) {
			int curr = q.poll();
			sb.append(curr).append(" ");
			for (int i : A[curr]) {
				indegree[i]--;
				if (indegree[i] == 0)
					q.add(i);
			}
		}
		System.out.println(sb.toString());
	}
}
