package bj;
import java.io.*;
import java.util.StringTokenizer;

public class BJ2491_수열 {
	static StringBuilder sb;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(s[i]);
		}
		int max = 1;
		int plusIdx = 0;
		int minusIdx = 0;
		int previousValue = array[0];
		for (int i = 1; i < N; i++) {
			if (array[i] >= previousValue && i - plusIdx + 1 > max) {
				max = i - plusIdx + 1;
			}
			if (array[i] <= previousValue && i - minusIdx + 1 > max) {
				max = i - minusIdx + 1;
			}

			if (array[i] > previousValue) {
				minusIdx = i;
			}
			if (array[i] < previousValue) {
				plusIdx = i;
			}

			previousValue = array[i];
		}
		System.out.println(max);
	}
}
