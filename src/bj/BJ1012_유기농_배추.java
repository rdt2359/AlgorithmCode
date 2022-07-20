package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1012_유기농_배추 {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] array = new int[M][N];

			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int a1 = Integer.parseInt(st.nextToken());
				int a2 = Integer.parseInt(st.nextToken());
				array[a1][a2] = 1;
			}
			int cnt = 0;
			for (int r = 0; r < M; r++) {
				for (int c = 0; c < N; c++) {
					if (array[r][c] == 1) {
						cnt++;
						array[r][c] = -1;
						Queue<int[]> q = new LinkedList<>();
						q.add(new int[] { r, c });
						while (!q.isEmpty()) {
							int[] remove = q.remove();
							for (int i = 0; i < 4; i++) {
								int nextR = remove[0] + dr[i];
								int nextC = remove[1] + dc[i];
								if (0 <= nextR && nextR < M && 0 <= nextC && nextC < N && array[nextR][nextC] == 1) {
									q.add(new int[] { nextR, nextC });
									array[nextR][nextC] = -1;
								}
							}
						}
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}