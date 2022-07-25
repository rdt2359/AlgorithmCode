package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11659_구간_합_구하기_4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] array = new int[N + 1];
		long[] save = new long[N + 1];

		st = new StringTokenizer(br.readLine());
		array[1] = Integer.parseInt(st.nextToken());
		save[1] = array[1];
		for (int i = 2; i <= N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			save[i] = save[i - 1] + array[i];
		}
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			sb.append(save[j] - save[i - 1]).append("\n");
		}
		System.out.println(sb);
	}
}