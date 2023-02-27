import java.io.*;
import java.util.*;

public class boj9461_파도반수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long[] seq = new long[101];
		seq[1] = 1;
		seq[2] = 1;
		seq[3] = 1;
		for (int i = 4; i < 101; i++) {
			seq[i] = seq[i - 2] + seq[i - 3];
		}
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			sb.append(seq[Integer.parseInt(br.readLine())]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
