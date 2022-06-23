package bj;
import java.io.*;

public class BJ2669_직사각형_네개의_합집합의_면적_구하기 {
	static StringBuilder sb;
	static boolean[] isUsed;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		boolean[][] array = new boolean[101][101];
		for (int c = 0; c < 4; c++) {
			String[] ss = br.readLine().split(" ");
			int c1 = Integer.parseInt(ss[0]);
			int r1 = Integer.parseInt(ss[1]);
			int c2 = Integer.parseInt(ss[2]);
			int r2 = Integer.parseInt(ss[3]);
			for (int i = c1; i < c2; i++) {
				for (int j = r1; j < r2; j++) {
					array[i][j] = true;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (array[i][j]) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
