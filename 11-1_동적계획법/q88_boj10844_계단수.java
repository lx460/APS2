import java.io.*;
import java.util.*;

public class q88_boj10844_계단수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long mod = 1000000000;
		int N = Integer.parseInt(br.readLine());
		long[][] D = new long[N + 1][10];
		for (int i = 1; i <= 9; i++) {
			D[1][i] = 1;
		}
		for (int i = 2; i <= N; i++) {
			D[i][0] = D[i - 1][1];
			D[i][9] = D[i - 1][8];
			for (int j = 1; j <= 8; j++) {
				D[i][j] = (D[i - 1][j - 1] + D[i - 1][j + 1]) % mod;
			}
		}
		long sum = 0;
		for (int i = 0; i <= 9; i++) {
			sum = (sum + D[N][i]) % mod; //(a+b) % mod = ((a%m)+(b%m))%m
		}
		System.out.println(sum);
	}
}
