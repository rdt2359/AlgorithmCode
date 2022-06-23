package sw;

import java.io.*;

//파리 퇴치 https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PzOCKAigDFAUq

public class SW2001 {
	static StringBuilder sb;
	static int nn;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int c = 1; c <= t; c++) {
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			int[][] array = new int[n][n];
			for (int i = 0; i < n; i++) {
				String[] ss = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					array[i][j] = Integer.parseInt(ss[j]);
				}
			}
			int max = Integer.MIN_VALUE;
			for (int i = 0; i <= n - m; i++) {
				for (int j = 0; j <= n - m; j++) {
					int temp = 0;
					for (int k = i; k < i + m; k++) {
						for (int l = j; l < j + m; l++) {
							temp += array[k][l];
						}
					}
					if (max < temp) {
						max = temp;
					}
				}
			}
			sb.append("#").append(c).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}
