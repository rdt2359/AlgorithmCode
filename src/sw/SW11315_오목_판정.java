package sw;

import java.io.*;
import java.util.StringTokenizer;

//https://www.acmicpc.net/submit/7576
public class SW11315_오목_판정 {
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int cc = 1; cc <= T; cc++) {
			int N = Integer.parseInt(br.readLine());
			boolean[][] array = new boolean[N][N];

			for (int r = 0; r < N; r++) {
				String[] ss = br.readLine().split("");
				for (int c = 0; c < N; c++) {
					if (ss[c].equals("o")) {
						array[r][c] = true;
					}
				}
			}
			boolean flag = true;
			loop: for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (check(r, c, N, array)) {
						sb.append("#").append(cc).append(" YES").append("\n");
						flag = false;
						break loop;
					}
				}
			}
			if (flag) {
				sb.append("#").append(cc).append(" NO").append("\n");
			}
		}
		System.out.println(sb);
	}

	public static boolean check(int r, int c, int N, boolean[][] array) {
		boolean isGood = false;

		// 가로 체크
		if (r + 4 < N) {
			isGood = true;
			for (int i = 0; i < 5; i++) {
				if (!array[r + i][c]) {
					isGood = false;
					break;
				}
			}
		}
		if (isGood) {
			return true;
		}

		// 세로 체크
		if (c + 4 < N) {
			isGood = true;
			for (int i = 0; i < 5; i++) {
				if (!array[r][c + i]) {
					isGood = false;
					break;
				}
			}
		}
		if (isGood) {
			return true;
		}

		// 대각선 1 체크
		if (r + 4 < N && c + 4 < N) {
			isGood = true;
			for (int i = 0; i < 5; i++) {
				if (!array[r + i][c + i]) {
					isGood = false;
					break;
				}
			}
		}
		if (isGood) {
			return true;
		}

		// 대각선 2 체크
		if (r + 4 < N && c - 4 >= 0) {
			isGood = true;
			for (int i = 0; i < 5; i++) {
				if (!array[r + i][c - i]) {
					isGood = false;
					break;
				}
			}
		}
		if (isGood) {
			return true;
		}

		return false;
	}

}