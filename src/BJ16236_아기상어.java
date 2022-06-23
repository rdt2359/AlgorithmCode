import java.io.*;
import java.util.*;

public class BJ16236_아기상어 {
	static StringBuilder sb;
	static boolean[] isUsed;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] array = new int[N][N];
		boolean[][] check = new boolean[N][N];
		int sharkR = 0;
		int sharkC = 0;
		int sharkSize = 2;
		int exp = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 9) {
					sharkR = i;
					sharkC = j;
				}
				array[i][j] = input;
			}
		}

		Queue<Shark> queue = new LinkedList<>();
		queue.add(new Shark(sharkR, sharkC, 0));
		check[sharkR][sharkC] = true;

		int cnt = 0;
		while (!queue.isEmpty()) {
			Shark shark = queue.remove();

			for (int i = 0; i < 4; i++) {
				int nextR = shark.r + dr[i];
				int nextC = shark.c + dc[i];
				if (0 <= nextR && nextR < N && 0 <= nextC && nextC < N && array[nextR][nextC] <= sharkSize
						&& !check[nextR][nextC]) {
					if (array[nextR][nextC] != 0 && array[nextR][nextC] < sharkSize) {
						int move = shark.move + 1;
						cnt += (move);
						array[nextR][nextC] = 0;
						exp++;
						if (exp == sharkSize) {
							exp = 0;
							sharkSize++;
						}
						// --- 초기화
						queue.clear();
						queue.add(new Shark(nextR, nextC, 0));
						for (int k = 0; k < N; k++) {
							for (int j = 0; j < N; j++) {
								check[k][j] = false;
							}
						}
						check[nextR][nextC] = true;
						array[nextR][nextC] = 9;
						array[sharkR][sharkC] = 0;
						sharkR = nextR;
						sharkC = nextC;
						break;
					} else {
						check[nextR][nextC] = true;
						queue.add(new Shark(nextR, nextC, shark.move + 1));
					}
				}
			}
		}
		System.out.println(cnt);
	}

	static class Shark {
		int r;
		int c;
		int move = 0;

		Shark(int r, int c, int move) {
			this.r = r;
			this.c = c;
			this.move = move;
		}
	}
}
