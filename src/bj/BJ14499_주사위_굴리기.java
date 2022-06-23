package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.StringTokenizer;

public class BJ14499_주사위_굴리기 {

	public static int[] dr = { 0, 0, 0, -1, 1 };
	public static int[] dc = { 0, 1, -1, 0, 0 }; // * 동 서 북 남

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] input = new int[N][M];
		int[] order = new int[K];
		int[] dice = new int[6];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < order.length; i++) {
			int nextR = r + dr[order[i]];
			int nextC = c + dc[order[i]];

			if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) {
				continue;
			}

			roll(dice, order[i]);

			if (input[nextR][nextC] == 0) {
				input[nextR][nextC] = dice[0];
			} else {
				dice[0] = input[nextR][nextC];
				input[nextR][nextC] = 0;
			}
			sb.append(dice[5]).append("\n");

			r = nextR;
			c = nextC;
		}
		System.out.println(sb);

	}
	// int[] dice = new int[6]
	// . 2 .
	// 3 0 1
	// . 4 .
	// . 5 .

	// 0: 아래 5:위

	public static void roll(int[] dice, int dir) {
		if (dir == 1) { // 동
			int temp = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[3];
			dice[3] = dice[0];
			dice[0] = temp;
		} else if (dir == 2) { // 서
			int temp = dice[1];
			dice[1] = dice[0];
			dice[0] = dice[3];
			dice[3] = dice[5];
			dice[5] = temp;
		} else if (dir == 3) { // 북
			int temp = dice[2];
			dice[2] = dice[5];
			dice[5] = dice[4];
			dice[4] = dice[0];
			dice[0] = temp;
		} else if (dir == 4) { // 남
			int temp = dice[2];
			dice[2] = dice[0];
			dice[0] = dice[4];
			dice[4] = dice[5];
			dice[5] = temp;
		}
	}

}