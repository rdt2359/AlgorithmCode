package sw;
import java.io.*;

//[S/W 문제해결 기본] 1일차 - 최빈수 구하기 https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV13zo1KAAACFAYh&categoryId=AV13zo1KAAACFAYh&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=JAVA&select-1=2&pageSize=10&pageIndex=3&&&&&&&&&&
public class SW1204_최빈수_구하기 {
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int ii = 1; ii <= N; ii++) {
			br.readLine();
			int[] score = new int[101];
			String[] ss = br.readLine().split(" ");
			for (String s : ss) {
				score[Integer.parseInt(s)] += 1;
			}
			int maxIndex = 0;
			int maxValue = Integer.MIN_VALUE;
			for (int i = 0; i < score.length; i++) {
				if (maxValue <= score[i]) {
					maxIndex = i;
					maxValue = score[i];
				}
			}
			sb.append("#").append(ii).append(" ").append(maxIndex).append("\n");
		}
		System.out.println(sb);
	}

}
