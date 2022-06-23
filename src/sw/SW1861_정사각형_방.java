package sw;
import java.io.*;
import java.util.StringTokenizer;

//https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AX5MvY2anG4DFAX1&contestProbId=AV5LtJYKDzsDFAXc&probBoxId=AX7mER5amHEDFAVm+&type=PROBLEM&problemBoxTitle=0211&problemBoxCnt=3
public class SW1861_정사각형_방 {
	
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int C = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int cc = 1; cc <= C; cc++) {
			N = Integer.parseInt(br.readLine());
			int[][] array = new int[N][N];
			int[][] check = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					array[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = Integer.MIN_VALUE;
			int value = -1;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int ret = dfs(r, c, array, check, 1);
					if (ret > max) {
						max = ret;
						value = array[r][c];
					} else if (ret == max && value > array[r][c]) {
						value = array[r][c];
					}
				}
			}
			sb.append("#").append(cc).append(" ").append(value).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	public static int dfs(int r, int c, int[][] array, int[][] check, int cnt) {
		for (int i = 0; i < 4; i++) {
			if (r + dr[i] >= 0 && r + dr[i] < N && c + dc[i] >= 0 && c + dc[i] < N) {
				if (array[r][c] + 1 == array[r + dr[i]][c + dc[i]]) {
					cnt = dfs(r + dr[i], c + dc[i], array, check, cnt + 1);
				}
			}
		}
		return cnt;
	}
}
