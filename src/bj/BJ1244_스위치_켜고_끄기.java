package bj;
import java.io.*;

public class BJ1244_스위치_켜고_끄기 {
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		boolean[] array = new boolean[N + 1];
		String[] ss = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			if (ss[i - 1].equals("1")) {
				array[i] = true;
			}
		}
		int studentNum = Integer.parseInt(br.readLine());
		for (int cc = 0; cc < studentNum; cc++) {
			ss = br.readLine().split(" ");
			int value = Integer.parseInt(ss[1]);
			if (ss[0].equals("1")) {
				for (int i = value; i <= N; i += value) {
					array[i] = !array[i];
				}
			} else {
				int index = 1;
				array[value] = !array[value];
				while (value - index >= 1 && value + index <= N && array[value - index] == array[value + index]) {
					array[value - index] = !array[value - index];
					array[value + index] = !array[value + index];
					index++;
				}
			}
		}
		int cnt = 0;
		for (int i = 1; i < array.length; i++) {
			if (cnt != 0 && cnt % 20 == 0) {
				sb.append("\n");
			}
			sb.append(array[i] ? "1" : "0").append(" ");
			cnt++;
		}
		System.out.println(sb);
	}
}
