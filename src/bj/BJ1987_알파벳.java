package bj;
import java.io.*;
import java.util.HashSet;

public class BJ1987_알파벳 {
	static StringBuilder sb;

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int R;
	static int C;
	static HashSet<Character> set;
	static char[][] map;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] ss = br.readLine().split(" ");
		R = Integer.parseInt(ss[0]);
		C = Integer.parseInt(ss[1]);
		set = new HashSet<>();
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			char[] cc = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = cc[j];
			}
		}
		set.add(map[0][0]);
		function(0, 0, 1);
		System.out.println(answer);

	}

	public static void function(int row, int col, int sum) {
		for (int i = 0; i < 4; i++) {
			int nextR = row + dr[i];
			int nextC = col + dc[i];
			if (0 <= nextR && nextR < R && 0 <= nextC && nextC < C) {
				char getChar = map[nextR][nextC];
				if (set.contains(getChar)) {
					if (sum > answer) {
						answer = sum;
					}
				} else {
					set.add(getChar);
					function(nextR, nextC, sum + 1);
					set.remove(getChar);
				}
			}
		}
	}

}
