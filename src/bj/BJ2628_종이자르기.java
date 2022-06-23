package bj;
import java.io.*;

public class BJ2628_종이자르기 {
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String[] ss = br.readLine().split(" ");
		int c = Integer.parseInt(ss[0]);
		int r = Integer.parseInt(ss[1]);
		boolean[] row = new boolean[r + 1];
		boolean[] col = new boolean[c + 1];
		int N = Integer.parseInt(br.readLine());
		for (int cc = 0; cc < N; cc++) {
			ss = br.readLine().split(" ");
			int index = Integer.parseInt(ss[1]);
			if (ss[0].equals("0")) {
				row[index] = true;
			} else {
				col[index] = true;
			}
		}
		int rowMax = 1;
		int colMax = 1;
		int rowCnt = 0;
		int colCnt = 0;

		for (int i = 1; i < row.length; i++) {
			rowCnt++;
			if (row[i]) {
				if (rowMax < rowCnt) {
					rowMax = rowCnt;
				}
				rowCnt = 0;
			}
		}
		if (rowMax < rowCnt) {
			rowMax = rowCnt;
		}

		for (int i = 1; i < col.length; i++) {
			colCnt++;
			if (col[i]) {
				if (colMax < colCnt) {
					colMax = colCnt;
				}
				colCnt = 0;
			}
		}
		if (colMax < colCnt) {
			colMax = colCnt;
		}
		System.out.println(rowMax * colMax);
	}
}
