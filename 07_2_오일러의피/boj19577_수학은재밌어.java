import java.io.*;

public class boj19577_수학은재밌어 {
	static int oi(int num) {
		int result = num;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				result = result - result / i;
				while (num % i == 0) {
					num /= i;
				}
			}
		}
		if (num > 1)
			result = result - result / num;
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = -1;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				if (n / i != i) {
					if (n/i * oi(n/i) == n) {
						ans = n/i;
						break;
					}
				} else {
					if(i * oi(i) == n) {
						ans = i;
						break;
					}
				}
			}
		}
		System.out.println(ans);
	}

}
