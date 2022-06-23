package sw;
import java.io.*;
import java.util.StringTokenizer;

//https://www.acmicpc.net/submit/7576
public class SW7236_저수지의_물의_총_깊이_구하기 {
	static int[] dr = { 0, -1, 0, 1, 1, 1, -1, -1 };
	static int[] dc = { 1, 0, -1, 0, -1, 1, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int C = Integer.parseInt(br.readLine());
		for (int cc = 1; cc <= C; cc++) {
			int N = Integer.parseInt(br.readLine());
			boolean[][] array = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					if (st.nextToken().equals("W")) {
						array[r][c] = true;
					}
				}
			}
			int max = 1;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (array[r][c]) {
						int cnt = 0;
						for (int i = 0; i < 8; i++) {
							int tempR = r + dr[i];
							int tempC = c + dc[i];
							if (0 <= tempR && tempR < N && 0 <= tempC && tempC < N && array[tempR][tempC]) {
								cnt++;
							}
						}
						if (cnt > max) {
							max = cnt;
						}
					}
				}
			}
			sb.append("#").append(cc).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

}