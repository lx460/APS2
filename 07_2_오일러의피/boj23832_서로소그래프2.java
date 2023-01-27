import java.io.*;

public class boj23832_서로소그래프2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		for (int i = 2; i <= N; i++) {
			if(arr[i] != 0) {
				continue;
			}
			for (int j = i; j <= N; j += i) {
				if (arr[j] == 0)
					arr[j] = j - j / i;
				else {
					arr[j] = arr[j] - arr[j] / i;
				}
			}
		}
		int sum = 0;
		for (int i = 2; i <= N; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}
}
