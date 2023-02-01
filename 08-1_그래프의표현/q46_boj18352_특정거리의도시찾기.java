import java.io.*;
import java.util.*;

public class q46_boj18352_특정거리의도시찾기 {
	static ArrayList<Integer>[] A;
	static int N, M, K, X;
	static int[] visited;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		A = new ArrayList[N + 1];
		list = new ArrayList<>();
		visited = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			A[S].add(E);
		}
		Arrays.fill(visited, -1);
		BFS(X);
		Collections.sort(list);
		if (list.isEmpty())
			sb.append(-1);
		else {
			for (int i : list) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	static void BFS(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		visited[n]++;
		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int i : A[curr]) {
				if (visited[i] == -1) {
					visited[i] = visited[curr] + 1;
					if (visited[i] == K)
						list.add(i);
					q.add(i);
				}
			}
		}
	}
}
