package bj;

import java.io.*;
import java.util.StringTokenizer;

//https://www.acmicpc.net/submit/7576
public class BJ14696_딱지놀이 {
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		for (int cc = 0; cc < N; cc++) {
			int[] playerA = new int[5];
			int[] playerB = new int[5];
			String[] ss1 = br.readLine().split(" ");
			for (int i = 1; i < ss1.length; i++) {
				playerA[Integer.parseInt(ss1[i])]++;
			}

			String[] ss2 = br.readLine().split(" ");
			for (int i = 1; i < ss2.length; i++) {
				playerB[Integer.parseInt(ss2[i])]++;
			}
			boolean flag = true;
			for (int i = 4; i > 0; i--) {
				if (playerA[i] > playerB[i]) {
					sb.append("A").append("\n");
					flag = false;
					break;
				} else if (playerA[i] < playerB[i]) {
					sb.append("B").append("\n");
					flag = false;
					break;
				}
			}
			if (flag) {
				sb.append("D").append("\n");
			}
		}
		System.out.println(sb);
	}

}