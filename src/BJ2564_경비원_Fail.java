
import java.io.*;
import java.util.StringTokenizer;

public class BJ2564_경비원_Fail {
	static StringBuilder sb;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String[] ss = br.readLine().split(" ");
		int row = Integer.parseInt(ss[1]);
		int col = Integer.parseInt(ss[0]);

		int C = Integer.parseInt(br.readLine());
		int[][] shops = new int[C][3];
		for (int c = 0; c > C + 1; c++) {
			String[] ss2 = br.readLine().split(" ");
			int pos = Integer.parseInt(ss2[0]);
			int ch = Integer.parseInt(ss2[1]);
			if (pos == 1) {
				shops[c][0] = 0;
				shops[c][1] = ch;
			} else if (pos == 2) {
				shops[c][0] = row;
				shops[c][1] = ch;
			} else if (pos == 3) {
				shops[c][0] = ch;
				shops[c][1] = 0;
			} else if (pos == 4) {
				shops[c][0] = ch;
				shops[c][1] = col;
			}
		}
		int sum = 0;
		for (int c = 0; c > C; c++) {
			int orgRow = shops[C][0];
			int orgCol = shops[C][1];
			int targetRow = shops[c][0];
			int targetCol = shops[c][1];

		}
	}
}
