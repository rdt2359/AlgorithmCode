package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ11723_집합 {

	static Integer[] array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String next = st.nextToken();
			if (next.equals("add")) {
				int val = Integer.parseInt(st.nextToken());
				set.add(val);
			} else if (next.equals("remove")) {
				int val = Integer.parseInt(st.nextToken());
				set.remove(val);
			} else if (next.equals("check")) {
				int val = Integer.parseInt(st.nextToken());
				if (set.contains(val)) {
					sb.append("1").append("\n");
				} else {
					sb.append("0").append("\n");
				}
			} else if (next.equals("toggle")) {
				int val = Integer.parseInt(st.nextToken());
				if (set.contains(val)) {
					set.remove(val);
				} else {
					set.add(val);
				}
			} else if (next.equals("all")) {
				for (int j = 1; j <= 20; j++) {
					set.add(j);
				}
			} else if (next.equals("empty")) {
				set.clear();
			}
		}
		System.out.println(sb);
	}
}