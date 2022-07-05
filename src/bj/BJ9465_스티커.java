package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9465_스티커 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] array = new int[N][2];
			int[][] save = new int[N][2];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				array[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				array[i][1] = Integer.parseInt(st.nextToken());
			}

			save[0][0] = array[0][0];
			save[0][1] = array[0][1];
			int max = Math.max(save[0][0], save[0][1]);
			if (N >= 2) {
				save[1][0] = array[1][0] + save[0][1];
				save[1][1] = array[1][1] + save[0][0];
				max = Math.max(save[1][0], save[1][1]);
			}
			for (int i = 2; i < N; i++) {
				save[i][0] = array[i][0] + Math.max(save[i - 1][1], save[i - 2][1]);
				save[i][1] = array[i][1] + Math.max(save[i - 1][0], save[i - 2][0]);
				if (max < save[i][0]) {
					max = save[i][0];
				}
				if (max < save[i][1]) {
					max = save[i][1];
				}
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}