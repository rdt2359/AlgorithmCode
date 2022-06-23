package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/17143
public class BJ17143_낚시왕 {

	static int R;
	static int C;
	static int M;
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Shark[][] input = new Shark[R][C];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			input[r][c] = new Shark(r, c, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		int sum = 0;
		for (int c = 0; c < C; c++) {
			// 2
			sum += getShark(c, input);
			// 3
			input = moveShark(input);
		}
		System.out.println(sum);
	}

	private static Shark[][] moveShark(Shark[][] input) {
		Shark[][] move = new Shark[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (input[r][c] != null) {
					Shark shark = input[r][c];
					int speed = shark.speed;
					int dir = shark.dir;
					int cal = (dir == 1 || dir == 2) ? R * 2 - 2 : C * 2 - 2;
					speed = speed % cal;

					int row = shark.r;
					int col = shark.c;

					if (dir == 1 || dir == 2) { // 상하
						for (int s = speed; s > 0; s--) {
							int next = row + dr[dir];
							if (next == R || next == -1) {
								if (dir == 1) {
									dir = 2;
								} else if (dir == 2) {
									dir = 1;
								}
								next = row + dr[dir];
							}
							row = next;
						}
					} else {
						for (int s = speed; s > 0; s--) {
							int next = col + dc[dir];
							if (next == C || next == -1) {
								if (dir == 3) {
									dir = 4;
								} else if (dir == 4) {
									dir = 3;
								}
								next = col + dc[dir];
							}
							col = next;
						}
					}
					if (move[row][col] == null || move[row][col].size < shark.size) {
						move[row][col] = new Shark(row, col, shark.speed, dir, shark.size);
					}

				}
			}
		}
		return move;
	}

	public static int getShark(int col, Shark[][] input) {
		for (int r = 0; r < R; r++) {
			if (input[r][col] != null) {
				int size = input[r][col].size;
				input[r][col] = null;
				return size;
			}
		}
		return 0;
	}

	public static class Shark {
		int r;
		int c;
		int speed;
		int dir;
		int size;

		public Shark(int r, int c, int speed, int dir, int size) {
			super();
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}

		@Override
		public String toString() {
			return "S[s=" + speed + " " + getDir() + "]";
		}

		public String getDir() {
			if (dir == 1) {
				return "상";
			} else if (dir == 2) {
				return "하";
			} else if (dir == 3) {
				return "우";
			} else {
				return "좌";
			}
		}
	}
}