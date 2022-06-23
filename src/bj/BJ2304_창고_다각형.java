package bj;
import java.io.*;

public class BJ2304_창고_다각형 {
	static StringBuilder sb;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int left = Integer.MAX_VALUE;
		int right = Integer.MIN_VALUE;
		int maxPos = Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		int[] array = new int[1001];
		for (int i = 0; i < N; i++) {
			String[] ss = br.readLine().split(" ");
			int L = Integer.parseInt(ss[0]);
			int H = Integer.parseInt(ss[1]);
			if (H > max) {
				maxPos = L;
				max = H;
			}
			if (L < left) {
				left = L;
			}
			if (L > right) {
				right = L;
			}
			array[L] = H;
		}

		int value = -1;
		int sum = 0;
		for (int i = left; i < maxPos; i++) {
			if (value < array[i]) {
				value = array[i];
			}
			sum += value;
		}
		value = -1;
		for (int i = right; i >= maxPos; i--) {
			if (value < array[i]) {
				value = array[i];
			}
			sum += value;
		}
		System.out.println(sum);
	}
}
