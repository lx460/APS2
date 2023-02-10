import java.io.*;
import java.util.*;

public class q68_boj1068_트리 {
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	static int deleteNode;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N];
		visited = new boolean[N];
		int root = 0;
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int node = Integer.parseInt(st.nextToken());
			if (node != -1) {
				adj[i].add(node);
				adj[node].add(i);
			} else
				root = i;
		}
		deleteNode = Integer.parseInt(br.readLine());
		if(root == deleteNode)
			System.out.println(0);
		else {
			dfs(root);
			System.out.println(ans);
		}
			
	}

	static void dfs(int n) {
		if (visited[n])
			return;
		int son = 0;
		visited[n] = true;
		for (int i : adj[n]) {
			if (!visited[i] && i != deleteNode) {
				son++;
				dfs(i);
			}
		}
		if (son == 0)
			ans++;
	}
}
