package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ15652_N과_M_4 {

	static int N;
	static int M;
	static int[] save;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		save = new int[M];
		recusive(0, 1);
		System.out.println(sb);
	}

	public static void recusive(int cnt, int index) {

		if (cnt == M) {
			for (int i = 0; i < save.length; i++) {
				sb.append(save[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = index; i <= N; i++) {
			save[cnt] = i;
			recusive(cnt + 1, i);
		}
	}
}