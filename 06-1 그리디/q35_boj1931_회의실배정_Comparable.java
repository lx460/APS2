import java.io.*;
import java.util.*;

public class q35_boj1931_회의실배정_Comparable {
	static class conference implements Comparable<conference> {
		int st, ed;

		public conference(int st, int ed) {
			this.st = st;
			this.ed = ed;
		}

		@Override
		public int compareTo(conference o) {
			if (this.ed - o.ed == 0)
				return this.st - o.st;
			return this.ed - o.ed;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		conference[] arr = new conference[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i] = new conference(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);
		int cnt = 0;
		int temp = 0;
		for (int i = 0; i < N; i++) {
			if(arr[i].st >= temp) {
				cnt++;
				temp = arr[i].ed;
			}
		}
		System.out.println(cnt);
		
	}
}
