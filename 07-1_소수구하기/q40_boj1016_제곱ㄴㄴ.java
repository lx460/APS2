import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q40_boj1016_제곱ㄴㄴ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		int ans = (int) (max-min+1);
		long i = 2;
		boolean[] check = new boolean[(int) (max-min+1)];
		
		while(i*i <= max) {
			long num = min/(i*i);
			if(min%(i*i) != 0)
				num++;
			
			while(num*(i*i)<=max) {
				if(!check[(int) (num*(i*i)-min)]) {
					check[(int) (num*(i*i)-min)] = true;
					ans--;
				}
				num++;
			}
			i++;
		}
		System.out.println(ans);
	}
}
