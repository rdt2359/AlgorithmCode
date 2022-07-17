package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1780_종이의_개수 {
	static int[][] array;
	static int[] save = new int[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		array = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		recursive(N, 0, 0);
		sb.append(save[0]).append("\n").append(save[1]).append("\n").append(save[2]).append("\n");

		System.out.println(sb);
	}

	public static void recursive(int val, int r, int c) {
		int[] tempSave = new int[3];
		for (int i = r; i < r + val; i++) {
			for (int j = c; j < c + val; j++) {
				if (array[i][j] == -1) {
					tempSave[0]++;
				} else if (array[i][j] == 0) {
					tempSave[1]++;
				} else if (array[i][j] == 1) {
					tempSave[2]++;
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			if (tempSave[i] == val * val) {
				save[i]++;
				return;
			}
		}

		int nextVal = val / 3;
		recursive(nextVal, r, c);
		recursive(nextVal, r, c + nextVal);
		recursive(nextVal, r, c + nextVal * 2);

		recursive(nextVal, r + nextVal, c);
		recursive(nextVal, r + nextVal, c + nextVal);
		recursive(nextVal, r + nextVal, c + nextVal * 2);

		recursive(nextVal, r + nextVal * 2, c);
		recursive(nextVal, r + nextVal * 2, c + nextVal);
		recursive(nextVal, r + nextVal * 2, c + nextVal * 2);

	}
}