package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/4485
public class BJ4485_녹색_옷_입은_애가_젤다지 {
	static int maxValue = Integer.MIN_VALUE;
	static int N;
	static int M;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = 0;
		int cnt = 1;
		while ((N = Integer.parseInt(br.readLine())) != 0) {
			int[][] array = new int[N][N];
			int[][] save = new int[N][N];

			for (int i = 0; i < N; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					array[i][j] = Integer.parseInt(s[j]);
					save[i][j] = Integer.MAX_VALUE;
				}
			}

			save[0][0] = array[0][0];

			Queue<Point> queue = new LinkedList<>();
			queue.add(new Point(0, 0));
			while (!queue.isEmpty()) {
				Point p = queue.poll();
				for (int i = 0; i < 4; i++) {
					int nextX = p.x + dx[i];
					int nextY = p.y + dy[i];
					if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
						if (save[nextX][nextY] > save[p.x][p.y] + array[nextX][nextY]) {
							queue.add(new Point(nextX, nextY));
							save[nextX][nextY] = save[p.x][p.y] + array[nextX][nextY];
						}
					}
				}
			}
			sb.append("Problem " + cnt++ + ": " + save[N - 1][N - 1]).append("\n");
		}
		System.out.println(sb);
	}

	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}
