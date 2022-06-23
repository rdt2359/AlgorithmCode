import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.StringTokenizer;

public class BJ14500_테트로미노 {

	public static int[] dr = { -1, 0, 1, 0 }; // 북 동 남 서
	public static int[] dc = { 0, 1, 0, -1 };

	static int[][] fr = { { 0, 1, 2, 1 }, { 0, 1, 2, 1 }, { 1, 1, 1, 0 }, { 0, 0, 0, 1 } };
	static int[][] fc = { { 0, 0, 0, 1 }, { 1, 1, 1, 0 }, { 0, 1, 2, 1 }, { 0, 1, 2, 1 } };

	static int M;
	static int N;
	static int max;
	static int[][] array;
	static boolean[][] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		array = new int[N][M];
		isVisited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = Integer.MIN_VALUE;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				isVisited[r][c] = true;
				bfs(r, c, 0, array[r][c]);
				isVisited[r][c] = false;
				fShape(r, c);
			}
		}
		System.out.println(max);

	}

	static void fShape(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int val = 0;
			for (int j = 0; j < 4; j++) {
				int nextR = r + fr[i][j];
				int nextC = c + fc[i][j];
				if (0 <= nextR && nextR < N && 0 <= nextC && nextC < M) {
					val += array[nextR][nextC];
				} else {
					break;
				}
				if (j == 3 && val > max) {
					max = val;
				}
			}
		}
	}

	static void bfs(int r, int c, int depth, int val) {
		if (depth == 3) {
			if (val > max) {
				max = val;
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			if (0 <= nextR && nextR < N && 0 <= nextC && nextC < M) {
				if (!isVisited[nextR][nextC]) {
					isVisited[nextR][nextC] = true;
					bfs(nextR, nextC, depth + 1, val + array[nextR][nextC]);
					isVisited[nextR][nextC] = false;
				}
			}
		}
	}
}