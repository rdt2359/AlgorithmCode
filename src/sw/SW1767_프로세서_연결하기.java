package sw;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AX5MvY2anG4DFAX1&contestProbId=AWBOKg-a6l0DFAWr&probBoxId=AX_ypNnKRDwDFAVy+&type=PROBLEM&problemBoxTitle=0404&problemBoxCnt=++1+
public class SW1767_프로세서_연결하기 {

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int N;
	static int maxCore;
	static int minLine;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int[][] isUsed = new int[N][N];
			ArrayList<Point> points = new ArrayList<>();
			maxCore = Integer.MIN_VALUE;
			minLine = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int value = Integer.parseInt(st.nextToken());
					if (value == 1) {
						isUsed[i][j] = 1;
						if (i != 0 && j != 0 && i != N - 1 && j != N - 1) {
							points.add(new Point(i, j));
						}
					}
				}
			}

			run(0, 0, 0, points, isUsed);
			sb.append("#").append(t).append(" ").append(minLine).append("\n");
		}
		System.out.println(sb);
	}

	static void run(int index, int core, int line, ArrayList<Point> points, int[][] isUsed) {
		if (index == points.size()) {
			if (core > maxCore || (core == maxCore && line < minLine)) {
				maxCore = core;
				minLine = line;
			}
			return;
		}

		int pr = points.get(index).r;
		int pc = points.get(index).c;

		for (int i = 0; i < 4; i++) {
			while (true) {
				pr += dr[i];
				pc += dc[i];
				if (0 <= pr && 0 <= pc && N > pr && N > pc && isUsed[pr][pc] != 0) { // 접근 불가
					break;
				} else if (0 > pr || 0 > pc || N <= pr || N <= pc) { // 마지막 접근 가능
					run(index + 1, core + 1, line, points, isUsed);
					break;
				}
				isUsed[pr][pc] = 2;
				line++;
			}

			while (true) {
				pr -= dr[i];
				pc -= dc[i];
				if (isUsed[pr][pc] == 1) {
					break;
				}
				isUsed[pr][pc] = 0;
				line--;
			}
		}
		run(index + 1, core, line, points, isUsed);
	}

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

}
