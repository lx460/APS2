import java.io.*;
import java.util.*;

public class q48_boj1707_이분그래프 {
	static ArrayList<Integer>[] list;
	static int[] check;
	static boolean[] visited;
	static boolean half;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			list = new ArrayList[V + 1];
			check = new int[V + 1];
			visited = new boolean[V + 1];
			half = false;
			for (int j = 1; j <= V; j++) {
				list[j] = new ArrayList<>();
			}
			for (int j = 1; j <= E; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				list[start].add(end);
				list[end].add(start);
			}
			for (int j = 1; j <= V; j++) {
				if (!half)
					DFS(j);
				else
					break;
			}
			if(!half)
				sb.append("YES").append("\n");
			else
				sb.append("NO").append("\n");
		}
		System.out.println(sb.toString());
	}

	static void DFS(int n) {
		visited[n] = true;
		for (int i : list[n]) {
			if (!visited[i]) {
				check[i] = (check[n] + 1) % 2;
				DFS(i);
			} else if (check[n] == check[i]) {
				half = true;
			}
		}
	}

}
