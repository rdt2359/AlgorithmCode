package bj;
import java.io.*;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2578
public class BJ2578_빙고 {
	static StringBuilder sb;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int[][] bingo = new int[5][5];
		boolean[][] check = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(s[j]);
			}
		}

		for (int i = 0; i < 5; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				int call = Integer.parseInt(s[j]);
				int[] index = findIndex(bingo, call);
				check[index[0]][index[1]] = true;
				if (checkBingo(check) >= 3) {
					System.out.println(i * 5 + j + 1);
					System.exit(0);
				}
			}
		}

	}

	public static int[] findIndex(int[][] bingo, int num) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (bingo[i][j] == num) {
					return new int[] { i, j };
				}
			}
		}
		return null;
	}

	public static int checkBingo(boolean[][] check) {
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			boolean flag1 = true;
			boolean flag2 = true;
			for (int j = 0; j < 5; j++) {
				if (!check[i][j]) {
					flag1 = false;
				}
				if (!check[j][i]) {
					flag2 = false;
				}
			}
			if (flag1) {
				sum++;
			}
			if (flag2) {
				sum++;
			}
		}

		boolean flag3 = true;
		boolean flag4 = true;
		for (int j = 0; j < 5; j++) {
			if (!check[j][j]) {
				flag3 = false;
			}
			if (!check[j][4 - j]) {
				flag4 = false;
			}
		}
		if (flag3) {
			sum++;
		}
		if (flag4) {
			sum++;
		}
		return sum;
	}
}
