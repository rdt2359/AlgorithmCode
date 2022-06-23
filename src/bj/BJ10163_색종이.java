package bj;

import java.io.*;
import java.util.StringTokenizer;

public class BJ10163_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[][] array = new int[1002][1002];
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int cc = Integer.parseInt(st.nextToken());
			int rr = Integer.parseInt(st.nextToken());
			for (int j = r; j < r + rr; j++) {
				for (int k = c; k < c + cc; k++) {
					array[j][k] = i;
				}
			}
		}
		int[] save = new int[N + 1];
		for (int i = 0; i < 1002; i++) {
			for (int j = 0; j < 1002; j++) {
				save[array[i][j]]++;
			}
		}
		for (int i = 1; i < save.length; i++) {
			sb.append(save[i]).append("\n");
		}
		System.out.println(sb);
	}

}