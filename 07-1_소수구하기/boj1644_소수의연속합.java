import java.util.ArrayList;
import java.util.Scanner;

public class boj1644_소수의연속합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 2; i <= N; i++) {
			arr[i] = i;
		}
		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (arr[i] == 0)
				continue;
			for (int j = i * 2; j <= N; j += i) {
				arr[j] = 0;
			}
		}
		for (int i = 2; i <= N; i++) {
			if (arr[i] != 0)
				list.add(i);
		}
		int left = 0;
		int right = 0;
		int sum = 2;
		int ans = 0;
		while (right != list.size()) {
			if (sum == N) {
				ans++;
				sum -= list.get(left);
				left++;
			} else if (sum > N) {
				sum -= list.get(left);
				left++;
			} else {
				right++;
				if (right >= list.size())
					break;
				sum += list.get(right);
			}
		}
		System.out.println(ans);
	}
}
