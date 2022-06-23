package bj;
import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2527
public class BJ2527_직사각형 {
	static StringBuilder sb;

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int R;
	static int C;
	static HashSet<Character> set;
	static char[][] map;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int cc = 0; cc < 4; cc++) {
			st = new StringTokenizer(br.readLine());
			int s1MinX = Integer.parseInt(st.nextToken());
			int s1MinY = Integer.parseInt(st.nextToken());
			int s1MaxX = Integer.parseInt(st.nextToken());
			int s1MaxY = Integer.parseInt(st.nextToken());

			int s2MinX = Integer.parseInt(st.nextToken());
			int s2MinY = Integer.parseInt(st.nextToken());
			int s2MaxX = Integer.parseInt(st.nextToken());
			int s2MaxY = Integer.parseInt(st.nextToken());

			if (s1MaxX < s2MinX || s2MaxX < s1MinX || s1MaxY < s2MinY || s2MaxY < s1MinY) {
				sb.append("d");
			} else if (s1MaxX == s2MinX || s2MaxX == s1MinX) {
				if (s1MaxY == s2MinY || s2MaxY == s1MinY) {
					sb.append("c");
				} else {
					sb.append("b");
				}
			} else if (s1MaxY == s2MinY || s2MaxY == s1MinY) {
				if (s1MaxX == s2MinX || s2MaxX == s1MinX) {
					sb.append("c");
				} else {
					sb.append("b");
				}
			} else {
				sb.append("a");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
