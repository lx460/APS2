import java.io.*;
import java.util.*;

public class q54_boj1516_게임개발 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list[] = new ArrayList[N + 1];
		int[] time = new int[N + 1];
		int[] indegree = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			time[i] = Integer.parseInt(st.nextToken());
			for (;;) {
				int num = Integer.parseInt(st.nextToken());
				if (num == -1)
					break;
				list[num].add(i);
				indegree[i]++;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0)
				q.add(i);
		}
		int[] result = new int[N + 1];
		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int i : list[curr]) {
				indegree[i]--;
				result[i] = Math.max(result[curr] + time[curr], result[i]);
				if (indegree[i] == 0)
					q.add(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(result[i] + time[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
