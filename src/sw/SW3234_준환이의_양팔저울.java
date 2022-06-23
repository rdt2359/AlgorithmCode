package sw;
import java.io.*;

public class SW3234_준환이의_양팔저울 {
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int cc = 1; cc <= T; cc++) {
			int N = Integer.parseInt(br.readLine());
			int[] array = new int[N];
			String[] ss = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				int input = Integer.parseInt(ss[i]);
				array[i] = input;
			}
			int sum = function(0, 0, 0, 0, array, N, 0);
			sb.append("#").append(cc).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}

	public static int function(int leftSum, int rightSum, int cnt, int check, int[] array, int N, int sum) {
		if (cnt == N) {
			return ++sum;
		}

		for (int i = 0; i < N; i++) {
			if ((check & 1 << i) == 0) {
				sum = function(leftSum + array[i], rightSum, cnt + 1, check | 1 << i, array, N, sum);
				if (leftSum >= rightSum + array[i]) {
					sum = function(leftSum, rightSum + array[i], cnt + 1, check | 1 << i, array, N, sum);
				}
			}
		}
		return sum;
	}

}