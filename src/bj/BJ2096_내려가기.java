package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2096_내려가기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] input = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
			input[i][2] = Integer.parseInt(st.nextToken());
		}

		int[][] minSave = new int[N][3];
		int[][] maxSave = new int[N][3];
		minSave[0][0] = input[0][0];
		minSave[0][1] = input[0][1];
		minSave[0][2] = input[0][2];

		maxSave[0][0] = input[0][0];
		maxSave[0][1] = input[0][1];
		maxSave[0][2] = input[0][2];

		for (int i = 1; i < N; i++) {
			minSave[i][0] = Math.min(minSave[i - 1][0], minSave[i - 1][1]) + input[i][0];
			minSave[i][1] = Math.min(Math.min(minSave[i - 1][0], minSave[i - 1][1]), minSave[i - 1][2]) + input[i][1];
			minSave[i][2] = Math.min(minSave[i - 1][1], minSave[i - 1][2]) + input[i][2];

			maxSave[i][0] = Math.max(maxSave[i - 1][0], maxSave[i - 1][1]) + input[i][0];
			maxSave[i][1] = Math.max(Math.max(maxSave[i - 1][0], maxSave[i - 1][1]), maxSave[i - 1][2]) + input[i][1];
			maxSave[i][2] = Math.max(maxSave[i - 1][1], maxSave[i - 1][2]) + input[i][2];
		}

		int min = Math.min(Math.min(minSave[N - 1][0], minSave[N - 1][1]), minSave[N - 1][2]);
		int max = Math.max(Math.max(maxSave[N - 1][0], maxSave[N - 1][1]), maxSave[N - 1][2]);

		System.out.println(max + " " + min);

	}
}