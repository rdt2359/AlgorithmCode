package bj;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ1158_요세푸스_문제 {
	static StringBuilder sb;
	static StringTokenizer st;
	static int[][] array;
	static int[] dc = { 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String[] ss = br.readLine().split(" ");
		int N = Integer.parseInt(ss[0]);
		int K = Integer.parseInt(ss[1]);

		sb.append("<");

		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		int index = K - 1;
		while (list.size() > 0) {
			sb.append(list.remove(index)).append(", ");
			index = index + K - 1;
			while (list.size() != 0 && index >= list.size()) {
				index = index - list.size();
			}
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb);
	}
}
