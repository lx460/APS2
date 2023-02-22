import java.io.*;
import java.util.*;

public class q97_boj11758_선분방향구하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] xy = new int[3][2];
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			xy[i][0] = Integer.parseInt(st.nextToken());
			xy[i][1] = Integer.parseInt(st.nextToken());
		}
		int ccw = (xy[0][0] * xy[1][1] + xy[1][0] * xy[2][1] + xy[2][0] * xy[0][1])
				- (xy[1][0] * xy[0][1] + xy[2][0] * xy[1][1] + xy[0][0] * xy[2][1]);
		int ans = 0;
		if (ccw < 0)
			ans = -1;
		else if (ccw == 0)
			ans = 0;
		else
			ans = 1;
		System.out.println(ans);
	}
}
