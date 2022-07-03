package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11054_가장_긴_바이토닉_부분_수열 {

	static int N;
	static int[] array;
	static int[] increase;
	static int[] decrease;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		array = new int[N];
		increase = new int[N];
		decrease = new int[N];
		Arrays.fill(increase, 1);
		Arrays.fill(decrease, 1);
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] > array[j] && increase[i] < increase[j] + 1) {
					increase[i] = increase[j] + 1;
				}
			}
		}

		for (int i = N - 2; i >= 0; i--) {
			for (int j = N - 1; j > i; j--) {
				if (array[i] > array[j] && decrease[i] < decrease[j] + 1) {
					decrease[i] = decrease[j] + 1;
				}
			}
		}

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			if (increase[i] + decrease[i] > max) {
				max = increase[i] + decrease[i];
			}
		}
		System.out.println(max - 1);

	}
}