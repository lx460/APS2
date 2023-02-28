import java.io.*;
import java.util.*;

public class boj13549_숨바꼭질3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] visited = new boolean[100001];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int min = Integer.MAX_VALUE;
		Queue<Subin> q = new LinkedList<>();
		q.add(new Subin(N, 0));
		while (!q.isEmpty()) {
			Subin curr = q.poll();
			visited[curr.loc] = true;
			if (curr.loc == K)
				min = Math.min(min, curr.time);
			if (curr.loc * 2 <= 100000 && visited[curr.loc * 2] == false) {
				q.add(new Subin(curr.loc * 2, curr.time));
			}
			if (curr.loc + 1 <= 100000 && visited[curr.loc + 1] == false) {
				q.add(new Subin(curr.loc + 1, curr.time + 1));
			}
			if (curr.loc - 1 >= 0 && visited[curr.loc - 1] == false) {
				q.add(new Subin(curr.loc - 1, curr.time + 1));
			}
		}
		System.out.println(min);
	}

	static class Subin {
		int loc, time;

		public Subin(int loc, int time) {
			this.loc = loc;
			this.time = time;
		}
	}
}
