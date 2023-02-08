import java.io.*;
import java.util.*;

public class q60_boj1219_오민식의고민 {
	static class Edge {
		int start, end, price;

		public Edge(int start, int end, int price) {
			this.start = start;
			this.end = end;
			this.price = price;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int sCity = Integer.parseInt(st.nextToken());
		int eCity = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		Edge[] edges = new Edge[E];
		long[] distance = new long[N];
		long[] money = new long[N];
		Arrays.fill(distance, Long.MIN_VALUE);
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(s, e, price);
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			money[i] = Long.parseLong(st.nextToken());
		}
		distance[sCity] = money[sCity];
		for (int i = 0; i < N + 100; i++) {
			for (int j = 0; j < E; j++) {
				int s = edges[j].start;
				int e = edges[j].end;
				int price = edges[j].price;
				if (distance[s] == Long.MIN_VALUE)
					continue;
				else if (distance[s] == Long.MAX_VALUE)
					distance[e] = Long.MAX_VALUE;
				else if (distance[e] < distance[s] + money[e] - price) {
					distance[e] = distance[s] + money[e] - price;
					if (i >= N - 1)
						distance[e] = Long.MAX_VALUE;
				}
			}
		}
		if (distance[eCity] == Long.MIN_VALUE)
			System.out.println("gg");
		else if (distance[eCity] == Long.MAX_VALUE)
			System.out.println("Gee");
		else
			System.out.println(distance[eCity]);
	}
}
