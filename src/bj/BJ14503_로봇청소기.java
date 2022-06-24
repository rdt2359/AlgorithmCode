package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.StringTokenizer;

public class BJ14503_로봇청소기 {

	public static int[] dr = { -1, 0, 1, 0 }; // 북 동 남 서
	public static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());

		int[][] input = new int[N][M];
		boolean[][] isCheck = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		root: while (true) {
			isCheck[r][c] = true; // 1. 현재 위치를 청소한다.

			int nextDir = 0;
			int nextR = 0;
			int nextC = 0;
			int cnt = 0;
			
			while (cnt != 4) { // 2. 현재 위치에서 다음을 반복하면서 인접한 칸을 탐색한다.
				nextDir = getLeft(dir);
				nextR = r + dr[nextDir];
				nextC = c + dc[nextDir];

				if (0 <= nextR && nextR < N && 0 <= nextC && nextC < M && input[nextR][nextC] == 0
						&& !isCheck[nextR][nextC]) { // a에서 빈 공간이 존재해서 1번으로 돌아가는 경우
					dir = nextDir;
					r = nextR;
					c = nextC;
					continue root;
				} else { // a에서 왼쪽으로 회전하는 경우
					dir = nextDir;
					cnt++;
				}
			}
			// b 1번 돌아가지 않고 후진하지 않고 2a가 연속 4번 실행
			nextDir = getBack(dir);
			nextR = r + dr[nextDir];
			nextC = c + dc[nextDir];
			if (0 > nextR || nextR >= N || 0 > nextC || nextC >= M || input[nextR][nextC] == 1) { // 벽이라면 멈춤
				break;
			} else { // 한칸 후진
				r = nextR;
				c = nextC;
			}
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (isCheck[i][j]) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}

	public static int getBack(int val) {
		return (val + 2) % 4;
	}

	// 북 동 남 서
	public static int getLeft(int val) {
		return (val + 3) % 4;
	}
}