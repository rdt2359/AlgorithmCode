package bj;
import java.io.*;

public class BJ2635_수_이어가기 {
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int maxLength = 4;
		int secondValue = 1;
		for (int i = N - 1; i >= 1; i--) {
			int currentValue = N;
			int nextValue = i;
			int cnt = 2;
			while (currentValue - nextValue >= 0) {
				cnt++;
				int tmp = nextValue;
				nextValue = currentValue - nextValue;
				currentValue = tmp;
			}
			if (maxLength < cnt) {
				maxLength = cnt;
				secondValue = i;
			}
		}
		sb.append(maxLength).append("\n");
		int currentValue = N;
		int nextValue = secondValue;
		sb.append(N).append(" ");
		sb.append(secondValue).append(" ");
		while (currentValue - nextValue >= 0) {
			int tmp = nextValue;
			nextValue = currentValue - nextValue;
			currentValue = tmp;
			sb.append(nextValue).append(" ");
		}
		System.out.println(sb);
	}
}
