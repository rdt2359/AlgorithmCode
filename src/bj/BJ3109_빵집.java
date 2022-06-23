package bj;
import java.io.*;

public class BJ3109_빵집 {
	static StringBuilder sb;
	static int[] dr = { -1, 0, 1 };
	static int[] dc = { 1, 1, 1 };
	static int R;
	static int C;
	static int sum;
	static boolean[][] canVisit;
	static boolean flag;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String[] ss = br.readLine().split(" ");
		R = Integer.parseInt(ss[0]);
		C = Integer.parseInt(ss[1]);
		canVisit = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String[] ss2 = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				if (ss2[j].equals(".")) {
					canVisit[i][j] = true;
				}
			}
		}

		for (int r = 0; r < R; r++) {
			flag = false;
			check(r, 0);
		}
		System.out.println(sum);
	}

	public static void check(int row, int col) {
		if (col == C - 1) {
			sum++;
			flag = true;
			return;
		}
		for (int i = 0; i < 3; i++) {
			if (!flag) {
				int nextRow = row + dr[i];
				int nextCol = col + dc[i];
				if (nextRow >= 0 && nextRow < R && nextCol >= 0 && nextCol < C && canVisit[nextRow][nextCol]) {
					canVisit[nextRow][nextCol] = false;
					check(nextRow, nextCol);
				}
			}
		}
	}

}
