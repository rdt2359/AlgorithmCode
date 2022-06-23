package sw;
import java.io.*;
import java.util.StringTokenizer;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh

public class SW1210_Ladder1 {
	static StringBuilder sb;
	static StringTokenizer st;
	static int[][] array;
	static int[] dc = { 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			int[][] array = new int[100][100];
			br.readLine();
			for (int i = 0; i < 100; i++) {
				String[] ss = br.readLine().split(" ");
				for (int j = 0; j < 100; j++) {
					array[i][j] = Integer.parseInt(ss[j]);
				}
			}
			int col = -1;
			for (int i = 0; i < 100; i++) {
				if (array[99][i] == 2) {
					col = i;
				}
			}
			int row = 99;
			int dcc = dc[0];
			while (row != 0) {
				if (col - 1 >= 0 && dcc != dc[2] && array[row][col - 1] == 1) {
					col--;
					dcc = dc[1];
				} else if (col + 1 < 100 && dcc != dc[1] && array[row][col + 1] == 1) {
					col++;
					dcc = dc[2];
				} else {
					row--;
					dcc = dc[0];
				}
			}
			sb.append("#").append(tc).append(" ").append(col).append("\n");
		}
		System.out.println(sb);
	}
}
