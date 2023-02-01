import java.io.*;
import java.util.*;

public class q52_boj1043_거짓말 {
	static int[] parent;
	static int[] truePeople;
	static ArrayList<Integer>[] party;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		truePeople = new int[Integer.parseInt(st.nextToken())];
		for (int i = 0; i < truePeople.length; i++) {
			truePeople[i] = Integer.parseInt(st.nextToken());
		}
		parent = new int[N + 1];
		party = new ArrayList[M + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		for (int i = 1; i <= M; i++) {
			party[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine(), " ");
			int partySize = Integer.parseInt(st.nextToken());
			for (int j = 0; j < partySize; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		for (int i = 1; i <= M; i++) {
			int leader = party[i].get(0);
			for (int j = 1; j < party[i].size(); j++) {
				union(leader, party[i].get(j));
			}
		}
		int result = 0;
		for (int i = 1; i <= M; i++) {
			boolean isPossible = true;
			for (int j = 0; j < truePeople.length; j++) {
				if (find(truePeople[j]) == find(party[i].get(0))) {
					isPossible = false;
					break;
				}
			}
			if (isPossible)
				result++;
		}
		System.out.println(result);
	}

	static int find(int a) {
		if (a == parent[a])
			return a;
		return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b)
			parent[b] = a;
	}
}
