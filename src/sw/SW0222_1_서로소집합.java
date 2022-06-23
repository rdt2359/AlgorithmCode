package sw;
import java.io.*;
import java.util.StringTokenizer;

public class SW0222_1_서로소집합 {
	static StringBuilder sb;
	static boolean[] isUsed;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int cc = 1; cc <= T; cc++) {
			sb.append("#").append(cc).append(" ");
			String[] ss = br.readLine().split(" ");
			int n = Integer.parseInt(ss[0]);
			int m = Integer.parseInt(ss[1]);
			int[] array = new int[n + 1];

			for (int i = 1; i <= n; i++) {
				array[i] = i;
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int flag = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (flag == 0) {
					union(a, b, array);
				} else {
					int aRoot = findSet(a, array);
					int bRoot = findSet(b, array);
					if (aRoot == bRoot) {
						sb.append("1");
					} else {
						sb.append("0");
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static boolean union(int a, int b, int[] array) {
		int aRoot = findSet(a, array);
		int bRoot = findSet(b, array);
		if (aRoot == bRoot) {
			return false;
		}
		array[bRoot] = aRoot;
		return true;
	}

	public static int findSet(int a, int[] array) {
		if (a == array[a]) {
			return a;
		}
		return array[a] = findSet(array[a], array);
	}
}
