package bj;

import java.io.*;
import java.util.StringTokenizer;

public class BJ1074_Z {
	static StringBuilder sb;
	static StringTokenizer st;
	static int[][] array;
	static int targetR, targetC, r, c, cnt;
	static int answerRow, answerCol;

	// 4등분
	// 재귀 어느정도 돌려야 문제되는지 4^15 = 1073741824
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		targetR = Integer.parseInt(s[1]);
		targetC = Integer.parseInt(s[2]);
		cnt = 0; // 현재 숫자
		recursive(N, 0, 0);
		System.out.println(cnt);
	}

	public static void recursive(int n, int row, int col) {
		if (n == 0) {
			return;
		} else {
			int size = (int) Math.pow(2, n) / 2; // 4분할 사각형의 크기
			if (targetR >= row && targetR < row + size && targetC >= col && targetC < col + size) {
				recursive(n - 1, row, col);
			} else if (targetR >= row && targetR < row + size && targetC >= col + size && targetC < col + size * 2) {
				cnt += size * size; // 누락 cnt 추가
				recursive(n - 1, row, col + size);
			} else if (targetR >= row + size && targetR < row + size * 2 && targetC >= col && targetC < col + size) {
				cnt += (size * size) * 2; // 누락 cnt 추가
				recursive(n - 1, row + size, col);
			} else if (targetR >= row + size && targetR < row + size * 2 && targetC >= col + size
					&& targetC < col + size * 2) {
				cnt += (size * size) * 3; // 누락 cnt 추가
				recursive(n - 1, row + size, col + size);
			}
		}
	}
}
