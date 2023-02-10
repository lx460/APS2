import java.io.*;
import java.util.*;

public class q69_boj14425_문자열집합 {
	static class Tnode {
		Tnode[] next = new Tnode[26];
		boolean isEnd;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Tnode root = new Tnode();
		while (N > 0) {
			String str = br.readLine();
			Tnode now = root;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (now.next[c - 'a'] == null) {
					now.next[c - 'a'] = new Tnode();
				}
				now = now.next[c - 'a'];
				if (i == str.length() - 1)
					now.isEnd = true;
			}
			N--;
		}
		int cnt = 0;
		while (M > 0) {
			String str = br.readLine();
			Tnode now = root;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (now.next[c - 'a'] == null) {
					now.next[c - 'a'] = new Tnode();
				}
				now = now.next[c - 'a'];
				if (i == str.length() - 1 && now.isEnd)
					cnt++;
			}
			M--;
		}
		System.out.println(cnt);

	}
}
