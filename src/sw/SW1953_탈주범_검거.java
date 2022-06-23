package sw;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AX5MvY2anG4DFAX1&contestProbId=AV15QRX6APsCFAYD&probBoxId=AYACDfaqE6sDFAVy+&type=PROBLEM&problemBoxTitle=0407&problemBoxCnt=++1+
public class SW1953_탈주범_검거 {

	static int[] dr = { 0, 0, 1, -1 }; // 1:왼쪽 2:오른쪽 3:아래 4:위
	static int[] dc = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[][] array = new int[N][M];
			boolean[][] isVisited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					array[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 1;

			Queue<Pipe> queue = new LinkedList<>();
			queue.add(new Pipe(R, C, array[R][C], 0));
			isVisited[R][C] = true;

			while (!queue.isEmpty()) {
				Pipe pipe = queue.remove();
				if (pipe.time == L - 1) {
					break;
				}
				for (int i : returnGo(pipe.shape)) {
					int nextR = pipe.r + dr[i];
					int nextC = pipe.c + dc[i];
					if (0 <= nextR && nextR < N && 0 <= nextC && nextC < M && array[nextR][nextC] != 0
							&& !isVisited[nextR][nextC]) {
						int[] nextGo = returnGo(array[nextR][nextC]);
						boolean flag = false;
						for (int n : nextGo) {
							if ((i == 0 && n == 1) || (i == 1 && n == 0) || (i == 3 && n == 2) || (i == 2 && n == 3)) {
								flag = true;
								break;
							}
						}
						if (flag) {
							queue.add(new Pipe(nextR, nextC, array[nextR][nextC], pipe.time + 1));
							isVisited[nextR][nextC] = true;
							cnt++;
						}
					}
				}

			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
//			for (int i = 0; i < N; i++) {
//				System.out.println();
//				for (int j = 0; j < M; j++) {
//					System.out.print(isVisited[i][j] ? 1 : 0);
//				}
//			}
//			System.out.println();
		}
		System.out.println(sb);
	}

	static class Pipe {
		int r;
		int c;
		int shape;
		int time;

		public Pipe(int r, int c, int shape, int time) {
			super();
			this.r = r;
			this.c = c;
			this.shape = shape;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Pipe [r=" + r + ", c=" + c + ", shape=" + shape + ", time=" + time + "]";
		}

	}

	// 0:왼쪽 1:오른쪽 2:아래 3:위
	public static int[] returnGo(int shape) {
		int[] ret = null;
		if (shape == 1) {
			ret = new int[] { 0, 1, 2, 3 };
		} else if (shape == 2) {
			ret = new int[] { 2, 3 };
		} else if (shape == 3) {
			ret = new int[] { 0, 1 };
		} else if (shape == 4) {
			ret = new int[] { 1, 3 };
		} else if (shape == 5) {
			ret = new int[] { 1, 2 };
		} else if (shape == 6) {
			ret = new int[] { 0, 2 };
		} else if (shape == 7) {
			ret = new int[] { 0, 3 };
		}
		return ret;
	}
}