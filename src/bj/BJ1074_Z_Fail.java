package bj;

import java.io.*;
import java.util.StringTokenizer;

public class BJ1074_Z_Fail {
	static StringBuilder sb;
	static StringTokenizer st;
	static int[][] array;
	static int targetR, targetC, r, c, cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		targetR = Integer.parseInt(s[1]);
		targetC = Integer.parseInt(s[2]);
		r = 0;
		c = 0;
		cnt = 0;
		int size = (int) Math.pow(2, N);
		array = new int[size][size]; // N = 15 10억
		recursive(N, 0, 0);

		System.out.println(array[targetR][targetC]);
	}

	// 4^15 = 1073741824
	public static void recursive(int n, int row, int col) {
		if (n == 1) {
			array[row][col] = cnt++;
			array[row + 1][col] = cnt++;
			array[row][col + 1] = cnt++;
			array[row + 1][col + 1] = cnt++;
		} else {
			int size = (int) Math.pow(2, n) / 2;
			recursive(n - 1, row, col);
			recursive(n - 1, row, col + size);
			recursive(n - 1, row + size, col);
			recursive(n - 1, row + size, col + size);
		}

	}
}
