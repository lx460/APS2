import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static class time {
		int start;
		int end;

		public time(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		time[] arr = new time[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i] = new time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr, new Comparator<time>() {
			@Override
			public int compare(time o1, time o2) {
				if (o1.end == o2.end)
					return Integer.compare(o1.start, o2.start);
				else
					return Integer.compare(o1.end, o2.end);
			}
		});
		int nEnd = 0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if(arr[i].start>=nEnd) {
				cnt++;
				nEnd = arr[i].end;
			}
		}
		System.out.println(cnt);
	}
}
