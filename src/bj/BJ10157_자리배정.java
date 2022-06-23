package bj;
import java.io.*;

//https://www.acmicpc.net/problem/10157
public class BJ10157_자리배정 {
	static StringBuilder sb;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] ss = br.readLine().split(" ");
		int C = Integer.parseInt(ss[0]);
		int R = Integer.parseInt(ss[1]);
		int K = Integer.parseInt(br.readLine());
		int array[][] = new int[R][C];
		int rot = 0;
		int curR = R - 1;
		int curC = 0;
		array[curR][curC] = 1;
		int k = 2;
		if (K > R * C) {
			sb.append("0");
		} else {
			while (k <= K) {
				int tempR = curR + dr[rot];
				int tempC = curC + dc[rot];
				if (tempR >= 0 && tempR < R && tempC >= 0 && tempC < C && array[tempR][tempC] == 0) {
					array[tempR][tempC] = k;
					curR = tempR;
					curC = tempC;
					k++;
				} else {
					rot = (rot + 1) % 4;
				}
			}
			sb.append(curC + 1).append(" ").append(R - curR);
		}
		System.out.println(sb);
	}
}
