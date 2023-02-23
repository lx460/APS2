import java.io.*;
import java.util.*;

public class q100_boj2166_다각형의면적 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double[][] xy = new double[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			xy[i][0] = Double.parseDouble(st.nextToken());
			xy[i][1] = Double.parseDouble(st.nextToken());
		}
		double ccw = 0;
		for (int i = 0; i < N; i++) {
			if (i != N - 1)
				ccw = ccw + (xy[i][0] * xy[i + 1][1] - xy[i + 1][0] * xy[i][1]);
			else
				ccw = ccw + (xy[i][0] * xy[0][1] - xy[0][0] * xy[i][1]);
		}
		ccw = Math.abs(ccw);
		ccw /= 2.0;
		System.out.printf("%.1f", ccw);
	}
}
