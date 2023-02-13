import java.io.*;
import java.util.*;

public class q70_boj1991_트리순회 {
	static int[][] tree;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		tree = new int[26][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int node = st.nextToken().charAt(0) - 'A';
			int left = st.nextToken().charAt(0) - 'A';
			int right = st.nextToken().charAt(0) - 'A';
			tree[node][0] = left;
			tree[node][1] = right;
		}
		sb = new StringBuilder();
		preOrder(0);
		sb.append("\n");
		inOrder(0);
		sb.append("\n");
		postOrder(0);
		System.out.println(sb.toString());
	}

	static void preOrder(int now) {
		if (now < 0)
			return;
		sb.append((char) (now + 'A'));
		preOrder(tree[now][0]);
		preOrder(tree[now][1]);
	}

	static void inOrder(int now) {
		if (now < 0)
			return;
		inOrder(tree[now][0]);
		sb.append((char) (now + 'A'));
		inOrder(tree[now][1]);
	}

	static void postOrder(int now) {
		if (now < 0)
			return;
		postOrder(tree[now][0]);
		postOrder(tree[now][1]);
		sb.append((char) (now + 'A'));
	}
}
