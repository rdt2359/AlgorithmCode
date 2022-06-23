package bj;
import java.io.*;

public class BJ1992_쿼드트리 {
	static int N;
	static int[][] array;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		array = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] ss = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(ss[j]);
			}
		}
		System.out.println(function(N, 0, 0));
	}

	public static String function(int size, int startRow, int startCol) {
		if (size == 1) {
			return String.valueOf(array[startRow][startCol]);
		}
		String a1 = function(size / 2, startRow, startCol);
		String a2 = function(size / 2, startRow, startCol + size / 2);
		String a3 = function(size / 2, startRow + size / 2, startCol);
		String a4 = function(size / 2, startRow + size / 2, startCol + size / 2);
		if ((a1.equals("1") || a1.equals("0")) && a1.equals(a2) && a2.equals(a3) && a3.equals(a4)) {
			return a1;
		} else {
			return "(" + a1 + a2 + a3 + a4 + ")";
		}
	}

}
