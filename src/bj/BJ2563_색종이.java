package bj;
import java.io.*;
import java.util.StringTokenizer;

public class BJ2563_색종이 {
	static StringBuilder sb;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		boolean[][] array = new boolean[100][100];
		for (int n = 0; n < N; n++) {
			String[] ss = br.readLine().split(" ");
			int row = Integer.parseInt(ss[0]);
			int col = Integer.parseInt(ss[1]);
			for (int i = row; i < row + 10; i++) {
				for (int j = col; j < col + 10; j++) {
					array[i][j] = true;
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (array[i][j]) {
					sum++;
				}
			}
		}

		System.out.println(sum);
	}
}
