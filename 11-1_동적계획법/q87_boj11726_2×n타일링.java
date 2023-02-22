import java.io.BufferedReader;
import java.io.InputStreamReader;

public class q87_boj11726_2×n타일링 {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		arr[1] = 1;
		arr[2] = 2;
		for (int i = 3; i <= n; i++) {
			arr[i] = arr[i-2] + arr[i-1];
			arr[i] = arr[i]%10007;
		}
		System.out.println(arr[n]);
	}

}
