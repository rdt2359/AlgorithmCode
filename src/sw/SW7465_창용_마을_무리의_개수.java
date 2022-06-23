package sw;
import java.io.*;
import java.util.StringTokenizer;

public class SW7465_창용_마을_무리의_개수 {
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
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				union(a, b, array);
			}
			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				if (array[i] == i) {
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
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
