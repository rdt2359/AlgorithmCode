package sw;
import java.io.*;
import java.util.StringTokenizer;

//https://www.acmicpc.net/submit/7576
public class SW7272_안경이_없어 {
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		for (int cc = 1; cc <= N; cc++) {
			sb.append("#").append(cc).append(" ");
			String[] ss = br.readLine().split(" ");
			if (ss[0].length() != ss[1].length()) {
				sb.append("DIFF").append("\n");
			} else {
				boolean flag = true;
				for (int i = 0; i < ss[0].length(); i++) {
					if (!compare(ss[0].charAt(i), ss[1].charAt(i))) {
						flag = false;
						sb.append("DIFF").append("\n");
						break;
					}
				}
				if (flag) {
					sb.append("SAME").append("\n");
				}
			}
		}
		System.out.println(sb);
	}

	public static boolean compare(char c1, char c2) {
		String s1 = "CEFGHIJKLMNSTUVWXYZ";
		String s2 = "ADOPQR";
		String s3 = "B";

		int c1Value = -1;
		int c2Value = -1;
		for (int i = 0; i < s1.length(); i++) {
			if (c1 == s1.charAt(i)) {
				c1Value = 1;
			}
			if (c2 == s1.charAt(i)) {
				c2Value = 1;
			}
		}
		for (int i = 0; i < s2.length(); i++) {
			if (c1 == s2.charAt(i)) {
				c1Value = 2;
			}
			if (c2 == s2.charAt(i)) {
				c2Value = 2;
			}
		}
		for (int i = 0; i < s3.length(); i++) {
			if (c1 == s3.charAt(i)) {
				c1Value = 3;
			}
			if (c2 == s3.charAt(i)) {
				c2Value = 3;
			}
		}
		if (c1Value == c2Value) {
			return true;
		} else {
			return false;
		}
	}
}