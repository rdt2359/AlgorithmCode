package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15654_N과_M_5 {

	static int N;
	static int M;
	static Integer[] input;
	static boolean[] isUsed;
	static StringBuilder sb;
	static int[] save;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		save = new int[M];
		input = new Integer[N];
		isUsed = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		recusive(0);
		System.out.println(sb);
	}

	public static void recusive(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < save.length; i++) {
				sb.append(save[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!isUsed[i]) {
				isUsed[i] = true;
				save[cnt] = input[i];
				recusive(cnt + 1);
				isUsed[i] = false;
			}
		}
	}
}