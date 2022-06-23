package sw;
import java.io.*;
import java.util.StringTokenizer;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWVWgkP6sQ0DFAUO&categoryId=AWVWgkP6sQ0DFAUO&categoryType=CODE&problemTitle=5356&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
public class SW5356_의석이의_세로로_말해요 {
	static int[] dr = { 0, -1, 0, 1, 1, 1, -1, -1 };
	static int[] dc = { 1, 0, -1, 0, -1, 1, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int C = Integer.parseInt(br.readLine());
		for (int cc = 1; cc <= C; cc++) {
			sb.append("#").append(cc).append(" ");
			String[][] array = new String[5][15];
			int maxLength = -1;
			for (int i = 0; i < 5; i++) {
				String[] ss = br.readLine().split("");
				for (int j = 0; j < ss.length; j++) {
					array[i][j] = ss[j];
				}
				if (ss.length > maxLength) {
					maxLength = ss.length;
				}
			}
			for (int c = 0; c < maxLength; c++) {
				for (int r = 0; r < 5; r++) {
					if (array[r][c] != null) {
						sb.append(array[r][c]);
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}