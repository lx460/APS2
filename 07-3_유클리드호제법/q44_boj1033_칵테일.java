import java.io.*;
import java.util.*;

public class q44_boj1033_칵테일 {
	static class node {
		int b;
		int p;
		int q;

		public node(int b, int p, int q) {
			this.b = b;
			this.p = p;
			this.q = q;
		}
	}

	static ArrayList<node>[] A;
	static long lcm;
	static boolean visited[];
	static long D[];

	static long gcd(long a, long b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		A = new ArrayList[N];
		visited = new boolean[N];
		D = new long[N];
		lcm = 1;
		for (int i = 0; i < N; i++) {
			A[i] = new ArrayList<node>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			A[a].add(new node(b, p, q));
			A[b].add(new node(a, q, p));
			lcm *= (p * q / gcd(p, q));
		}
		D[0] = lcm;
		DFS(0);
		long mgcd = D[0];
		for (int i = 1; i < N; i++) {
			mgcd = gcd(mgcd, D[i]);
		}
		for (int i = 0; i < N; i++) {
			sb.append(D[i]/ mgcd +" ");
		}
		System.out.println(sb.toString());
	}

	static void DFS(int n) {
		visited[n] = true;
		for (node i : A[n]) {
			int next = i.b;
			if (!visited[next]) {
				D[next] = D[n] * i.q / i.p;
				DFS(next);
			}
		}
	}
}
