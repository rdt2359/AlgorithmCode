package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/16953
public class Bj16953_AtoB {

	static int a;
	static int b;
	static String as;
	static String bs;
	static long min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		as = st.nextToken();
		bs = st.nextToken();
		a = Integer.parseInt(as);
		b = Integer.parseInt(bs);

		min = Long.MAX_VALUE;
		function(as, 0);
		if (min == Long.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min + 1);
		}

	}

	public static void function(String numStr, int cnt) {
		long num = Long.parseLong(numStr);
		if (num >= b) {
			if (num == b && cnt < min) {
				min = cnt;
			}
			return;
		}

		if (Long.parseLong(numStr) * 2 <= b) {
			function(String.valueOf(Long.parseLong(numStr) * 2), cnt + 1);
		}
		if (Long.parseLong(numStr + "1") <= b) {
			function(String.valueOf(Long.parseLong(numStr + "1")), cnt + 1);
		}
	}

}