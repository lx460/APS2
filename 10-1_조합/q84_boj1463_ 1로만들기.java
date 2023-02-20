import java.io.BufferedReader;
import java.io.InputStreamReader;

public class q84_boj1463_ 1로만들기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		int[] arr = new int[1000001];
		
		for (int i = 2; i <= num; i++) {
			arr[i] = arr[i-1] +1;
			if(i%2 == 0) arr[i] = Math.min(arr[i], arr[i/2]+1);
			if(i%3 == 0) arr[i] = Math.min(arr[i], arr[i/3]+1);
		}
		
		System.out.println(arr[num]);
	}
}
