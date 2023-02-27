import java.io.*;
import java.util.*;

public class boj2579_계단오르기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stair = new int[N + 1];
		int[] D = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		D[1] = stair[1];
		if (N >= 2)
			D[2] = stair[1] + stair[2];
		for (int i = 3; i <= N; i++) {
			D[i] = Math.max(D[i - 2], D[i - 3] + stair[i - 1]) + stair[i];
		}
		System.out.println(D[N]);
	}
}
