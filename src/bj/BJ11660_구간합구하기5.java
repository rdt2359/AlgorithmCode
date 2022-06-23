package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/16953
public class BJ11660_구간합구하기5 {

	static int a;
	static int b;
	static String as;
	static String bs;
	static long min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] array = new int[N][N];
		int[][] save = new int[N][N];
		ArrayList<int[]> points = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				save[i][j] = i == 0 ? array[i][j] : array[i][j] + save[i - 1][j];
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			points.add(new int[] { Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1 });
		}

		for (int[] point : points) {
			int x1 = point[0];
			int y1 = point[1];
			int x2 = point[2];
			int y2 = point[3];
			int sum = 0;
			for (int i = y1; i <= y2; i++) {
				int temp = x1 == 0 ? 0 : save[x1 - 1][i];
				sum += (save[x2][i] - temp);
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

}