package bj;

import java.io.*;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/16926
public class BJ16926_배열돌리기1 {
	static StringBuilder sb;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String[] input1 = br.readLine().split(" ");
		int N = Integer.parseInt(input1[0]);
		int M = Integer.parseInt(input1[1]);
		int R = Integer.parseInt(input1[2]);
		int cnt = Math.min(N, M) / 2;
		int[][] array = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] input2 = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(input2[j]);
			}
		}
		for (int r = 0; r < R; r++) {
			for (int i = 0; i < cnt; i++) {
				int temp = array[i][i];
				// left
				for (int j = i; j < M - i - 1; j++) {
					array[i][j] = array[i][j + 1];
				}
				// up
				for (int j = i; j < N - i - 1; j++) {
					array[j][M - i - 1] = array[j + 1][M - i - 1];
				}
				// right
				for (int j = M - i - 1; j > i; j--) {
					array[N - i - 1][j] = array[N - i - 1][j - 1];
				}
				// down
				for (int j = N - i - 1; j > i; j--) {
					array[j][i] = array[j - 1][i];
				}
				array[i + 1][i] = temp;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(array[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}