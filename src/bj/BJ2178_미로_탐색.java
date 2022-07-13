package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2178_미로_탐색 {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] array = new int[N][M];
		int[][] save = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(s[j]);
			}
		}

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		save[0][0] = 1;

		while (!q.isEmpty()) {
			int[] remove = q.remove();
			for (int i = 0; i < 4; i++) {
				int nextR = remove[0] + dr[i];
				int nextC = remove[1] + dc[i];
				if (0 <= nextR && nextR < N && 0 <= nextC && nextC < M && array[nextR][nextC] == 1
						&& save[nextR][nextC] == 0) {
					q.add(new int[] { nextR, nextC });
					save[nextR][nextC] = save[remove[0]][remove[1]] + 1;
				}
			}
		}
		System.out.println(save[N - 1][M - 1]);
	}
}