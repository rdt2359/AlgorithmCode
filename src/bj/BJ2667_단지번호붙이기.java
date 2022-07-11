package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2667_단지번호붙이기 {
	static int N;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		int[][] array = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(s[j]);
			}
		}

		int index = 1;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (array[r][c] == 1) {
					index++;
					Queue<Point> q = new LinkedList<>();
					q.add(new Point(r, c));
					array[r][c] = index;
					while (!q.isEmpty()) {
						Point remove = q.remove();
						for (int i = 0; i < 4; i++) {
							int nextR = remove.r + dr[i];
							int nextC = remove.c + dc[i];

							if (0 <= nextR && nextR < N && 0 <= nextC && nextC < N && array[nextR][nextC] == 1) {
								array[nextR][nextC] = index;
								q.add(new Point(nextR, nextC));
							}
						}
					}
				}
			}
		}
		int cnt = index - 1;
		int[] save = new int[cnt];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (array[r][c] != 0) {
					save[array[r][c] - 2]++;
				}
			}
		}
		Arrays.sort(save);

		sb.append(cnt).append("\n");
		for (int i : save) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
}