package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2579_계단_오르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		int[] save = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}

		save[0] = array[0];
		if (N >= 2) {
			save[1] = array[0] + array[1];
		}
		if (N >= 3) {
			save[2] = Math.max(array[0], array[1]) + array[2];
		}
		if (N >= 4) {
			for (int i = 3; i < N; i++) {
				save[i] = Math.max(save[i - 2], array[i - 1] + save[i - 3]) + array[i];
			}
		}
		System.out.println(save[N - 1]);

	}
}