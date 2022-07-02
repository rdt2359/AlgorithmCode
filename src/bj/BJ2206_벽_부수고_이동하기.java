package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2206_벽_부수고_이동하기 {

	static int N;
	static int M;
	static int[][] map;
	static int[][] save;
	static int[][] saveBreak;

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		save = new int[N][M];
		saveBreak = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				save[r][c] = Integer.MAX_VALUE;
				saveBreak[r][c] = Integer.MAX_VALUE;
			}
		}
		save[0][0] = 1;
		saveBreak[0][0] = 1;

		for (int r = 0; r < N; r++) {
			String[] s = br.readLine().split("");
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(s[c]);
			}
		}
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 1, false));

		while (!q.isEmpty()) {
			Point p = q.remove();

			for (int i = 0; i < 4; i++) {
				int nextR = p.r + dr[i];
				int nextC = p.c + dc[i];

				if (0 <= nextR && nextR < N && 0 <= nextC && nextC < M) {
					if (p.isBroke) {
						if (map[nextR][nextC] == 0 && p.move + 1 < saveBreak[nextR][nextC]) {
							saveBreak[nextR][nextC] = p.move + 1;
							q.add(new Point(nextR, nextC, p.move + 1, true));
						}
					} else {
						if (map[nextR][nextC] == 1 && p.move + 1 < saveBreak[nextR][nextC]) {
							saveBreak[nextR][nextC] = p.move + 1;
							q.add(new Point(nextR, nextC, p.move + 1, true));
						} else if (map[nextR][nextC] == 0 && p.move + 1 < save[nextR][nextC]) {
							save[nextR][nextC] = p.move + 1;
							q.add(new Point(nextR, nextC, p.move + 1, false));
						}
					}
				}
			}
		}
		int min = Math.min(save[N - 1][M - 1], saveBreak[N - 1][M - 1]);
		if (min == Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);
	}

	static class Point {
		int r;
		int c;
		int move;
		boolean isBroke;

		public Point(int r, int c, int move, boolean isBroke) {
			this.r = r;
			this.c = c;
			this.move = move;
			this.isBroke = isBroke;
		}
	}
}