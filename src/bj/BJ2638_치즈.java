package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2638_치즈 {

	static int N;
	static int M;
	static StringBuilder sb;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		int[][] array = new int[N][M];
		boolean[][] save = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		while (true) {
			chageAir(array);

			if (hasCheeze(array)) {
				break;
			}

			meltCheeze(array, save);

			cnt++;
		}
		System.out.println(cnt);
	}

	private static boolean[][] chageAir(int[][] array) {
		boolean[][] save = new boolean[N][M];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0 });
		save[0][0] = true;
		while (!queue.isEmpty()) {
			int[] remove = queue.remove();
			array[remove[0]][remove[1]] = -1;

			for (int i = 0; i < 4; i++) {
				int nextR = remove[0] + dr[i];
				int nextC = remove[1] + dc[i];
				if (0 <= nextR && nextR < N && 0 <= nextC && nextC < M && array[nextR][nextC] != 1
						&& !save[nextR][nextC]) {
					queue.add(new int[] { nextR, nextC });
					save[nextR][nextC] = true;
				}
			}
		}
		return save;
	}

	private static boolean[][] meltCheeze(int[][] array, boolean[][] save) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (array[i][j] == 1 && isCheezeMelt(i, j, array)) {
					save[i][j] = true;
				} else {
					save[i][j] = false;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (save[i][j]) {
					array[i][j] = -1;
				}
			}
		}
		return save;
	}

	private static boolean isCheezeMelt(int r, int c, int[][] array) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			if (0 <= nextR && nextR < N && 0 <= nextC && nextC < M && array[nextR][nextC] == -1) {
				cnt++;
			}
		}
		if (cnt >= 2) {
			return true;
		}
		return false;
	}

	private static boolean hasCheeze(int[][] array) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (array[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}

}