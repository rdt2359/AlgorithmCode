package bj;

import java.io.*;
import java.util.StringTokenizer;

//https://www.acmicpc.net/submit/7576
public class BJ17144_미세먼지안녕 {
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] room = new int[R][C];
		int air = -1;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int value = Integer.parseInt(st.nextToken());
				room[i][j] = value;
				if (value == -1) {
					air = i;
				}
			}
		}
		for (int i = 0; i < T; i++) {
			dustMove(room, R, C, air);
			airMove(room, R, C, air);
		}

		int sum = 2;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				sum += room[r][c];
			}
		}
		System.out.println(sum);
	}

	public static void dustMove(int[][] room, int R, int C, int air) {
		int[][] tempRoom = new int[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (room[r][c] == -1 || room[r][c] == 0) {
					continue;
				}
				int value = room[r][c];
				int moveValue = value / 5;
				int cnt = 0;
				for (int i = 0; i < 4; i++) {
					int nextR = r + dr[i];
					int nextC = c + dc[i];
					if (0 <= nextR && nextR < R && 0 <= nextC && nextC < C) {
						if (nextC == 0 && (nextR == air - 1 || nextR == air)) {
							continue;
						}
						cnt++;
						tempRoom[nextR][nextC] += moveValue;
					}
				}
				room[r][c] -= cnt * moveValue;
			}
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				room[r][c] += tempRoom[r][c];
			}
		}
	}
	
	public static void airMove(int[][] room, int R, int C, int air) {
		int up = air - 1;
		int down = air;
		
		// 시계 반대 순환
		for (int i = up - 1; i > 0; i--) {
			room[i][0] = room[i - 1][0];
		}
		for (int i = 0; i < C - 1; i++) {
			room[0][i] = room[0][i + 1];
		}
		for (int i = 0; i < up; i++) {
			room[i][C - 1] = room[i + 1][C - 1];
		}
		for (int i = C - 1; i > 1; i--) {
			room[up][i] = room[up][i - 1];
		}
		room[up][1] = 0;
		
		// 시계 순환
		for (int i = down + 1; i < R - 1; i++) {
			room[i][0] = room[i + 1][0];
		}
		for (int i = 0; i < C - 1; i++) {
			room[R - 1][i] = room[R - 1][i + 1];
		}
		for (int i = R - 1; i > down; i--) {
			room[i][C - 1] = room[i - 1][C - 1];
		}
		for (int i = C - 1; i > 1; i--) {
			room[down][i] = room[down][i - 1];
		}
		room[down][1] = 0;
	}

}