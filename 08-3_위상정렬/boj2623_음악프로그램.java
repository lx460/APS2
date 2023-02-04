import java.io.*;
import java.util.*;

public class boj2623_음악프로그램 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] adj = new ArrayList[N + 1];
		int[] indegree = new int[N + 1];
		ArrayList<Integer> answer = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = 0;
			int size = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= size; j++) {
				int end = Integer.parseInt(st.nextToken());
				if (start != 0) {
					adj[start].add(end);
					indegree[end]++;
				}
				start = end;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			int curr = q.poll();
			answer.add(curr);
			for (int i : adj[curr]) {
				indegree[i]--;
				if (indegree[i] == 0)
					q.add(i);
			}
		}
		if (answer.size() == N) {
			for (int i : answer) {
				sb.append(i).append("\n");
			}
		} else
			sb.append(0);
		System.out.println(sb.toString());
	}
}
