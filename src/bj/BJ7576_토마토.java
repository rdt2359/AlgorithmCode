package bj;

import java.io.*;
import java.util.*;

//https://www.acmicpc.net/submit/7576
public class BJ7576_토마토 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String[] ss = br.readLine().split(" ");
		int C = Integer.parseInt(ss[0]);
		int R = Integer.parseInt(ss[1]);
		int[][] array = new int[R][C];
		ArrayList<Tomato> list = new ArrayList<>();
		int zeroNum = 0;

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == 1) {
					list.add(new Tomato(i, j, -0)); // 시작 토마토 추가
				} else if (value == 0) {
					zeroNum++;
				}
				array[i][j] = value;
			}
		}
		if (zeroNum == 0) { // 처음부터 다 차있으면 0출력 후 종료
			System.out.println(0);
			System.exit(0);
		}

		Queue<Tomato> queue = new LinkedList<Tomato>();
		for (Tomato t : list) {
			queue.add(t);
		}
		while (!queue.isEmpty()) {
			Tomato t = queue.remove();
			for (int i = 0; i < 4; i++) {
				int nextR = t.r + dr[i];
				int nextC = t.c + dc[i];
				if (0 <= nextR && nextR < R && 0 <= nextC && nextC < C) {
					if (array[nextR][nextC] == 0) { // 토마토가 안익은경우 확인
						array[nextR][nextC] = t.day + 1; // 입력 배열 토마토를 익은 날짜로 변경
						queue.add(new Tomato(nextR, nextC, t.day + 1));
					}
				}
			}
		}

		int maxDay = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (array[i][j] > maxDay) {
					maxDay = array[i][j];
				}
				if (array[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}
		System.out.println(maxDay);
	}

	public static class Tomato {
		int r;
		int c;
		int day;

		public Tomato(int r, int c, int day) {
			this.r = r;
			this.c = c;
			this.day = day;
		}

	}
}