package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2573
public class BJ2573_빙산 {

	public static int[] dr = { 0, 0, -1, 1 };
	public static int[] dc = { 1, -1, 0, 0 };

	static int R;
	static int C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int[][] input = new int[R][C]; // 입력
		int[][] melt = new int[R][C]; // 해당 칸이 얼마나 녹는지 저장
		boolean[][] save = new boolean[R][C]; // 임시 저장 배열

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				input[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (input[r][c] == 0) { // 바다의 경우 바다가 아닌 4위치 녹는값 1 증가
					for (int i = 0; i < 4; i++) {
						int nextR = r + dr[i];
						int nextC = c + dc[i];
						if (0 <= nextR && nextR < R && 0 <= nextC && nextC < C && input[nextR][nextC] != 0) {
							melt[nextR][nextC]++;
						}
					}
				}
			}
		}

		int answer = 0;
		while (true) {
			answer++;
			boolean hasIce = false;
			// 빙산 녹이는 처리
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (melt[r][c] != 0) {
						hasIce = true;
						input[r][c] = input[r][c] - melt[r][c] >= 0 ? input[r][c] - melt[r][c] : 0;

						if (input[r][c] == 0) {
							melt[r][c] = 0;
							save[r][c] = true;
						}
					}
				}
			}

			if (!hasIce) {
				sb.append("0");
				break;
			}

			// 바다로 변한 위치 처리
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (save[r][c]) {
						for (int i = 0; i < 4; i++) {
							int nextR = r + dr[i];
							int nextC = c + dc[i];
							if (0 <= nextR && nextR < R && 0 <= nextC && nextC < C && input[nextR][nextC] != 0) {
								melt[nextR][nextC]++;
							}
						}
					}
				}
			}
			// 덩어리 확인
			boolean[][] visited = new boolean[R][C];
			int cnt = 0;
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (input[r][c] != 0 && !visited[r][c]) {
						dfs(r, c, visited, input);
						cnt++;
					}
				}
			}

			if (cnt >= 2) {
				sb.append(answer);
				break;
			}

			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					save[r][c] = false;
				}
			}
		}

		System.out.println(sb);
	}

	public static void dfs(int r, int c, boolean[][] visited, int[][] input) {
		for (int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			if (0 <= nextR && nextR < R && 0 <= nextC && nextC < C && input[nextR][nextC] != 0
					&& !visited[nextR][nextC]) {
				visited[nextR][nextC] = true;
				dfs(nextR, nextC, visited, input);
			}
		}
	}
}