import java.io.*;
import java.util.*;

public class q47_boj1325_효율적인해킹 {
	static ArrayList<Integer>[] A;
	static int N, M;
	static boolean[] visited;
	static int[] answer;
	static int max = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new ArrayList[N + 1];
		answer = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			A[S].add(E);
		}
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			visited[i] = true;
			BFS(i);
		}
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, answer[i]);
		}
		for (int i = 1; i <= N; i++) {
			if (answer[i] == max)
				sb.append(i + " ");
		}
		System.out.println(sb.toString());
	}

	static void BFS(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		visited[n] = true;
		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int i : A[curr]) {
				if (!visited[i]) {
					visited[i] = true;
					answer[i]++;
//					max = Math.max(max, answer[i]);
					q.add(i);
				}
			}
		}
	}

	static void DFS(int n) {

		for (int i : A[n]) {
			if (!visited[i]) {
				visited[i] = true;
				answer[i]++;
//				max = Math.max(max, answer[i]);
				DFS(i);
			}
		}
	}
}
