package bj;
import java.io.*;
import java.util.*;

public class BJ2605_줄_세우기 {
	static StringBuilder sb;
	static StringTokenizer st;
	static int[][] array;
	static int targetR, targetC, r, c;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		List<Integer> list = new LinkedList<>();
		list.add(1);
		for (int studentNum = 2; studentNum <= n; studentNum++) {
			list.add(studentNum - Integer.parseInt(s[studentNum - 1]) - 1, studentNum);
		}
		for (int i : list) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}
