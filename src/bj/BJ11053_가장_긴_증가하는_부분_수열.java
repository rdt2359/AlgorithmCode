package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/16953
public class BJ11053_가장_긴_증가하는_부분_수열 {

	static int a;
	static int b;
	static String as;
	static String bs;
	static long min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		int save[] = new int[N];
		Arrays.fill(save, 1);
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (array[j] < array[i] && save[j] + 1 > save[i]) {
					save[i] = save[j] + 1;
				}
			}
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			if (save[i] > max) {
				max = save[i];
			}

		}
		System.out.println(max);
	}

}