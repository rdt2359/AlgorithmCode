package sw;
import java.io.*;
// 1206. [S/W 문제해결 기본] 1일차 - View  
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV134DPqAA8CFAYh

public class SW1206_View {
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		for (int c = 1; c <= 10; c++) {
			int n = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			int answer = 0;
			for (int i = 2; i < n - 2; i++) {
				int maxValue = Integer.MIN_VALUE;
				int target = Integer.parseInt(input[i]);
				int min2 = Integer.parseInt(input[i - 2]);
				int min1 = Integer.parseInt(input[i - 1]);
				int plus1 = Integer.parseInt(input[i + 1]);
				int plus2 = Integer.parseInt(input[i + 2]);
				if (maxValue < min2) {
					maxValue = min2;
				}
				if (maxValue < min1) {
					maxValue = min1;
				}
				if (maxValue < plus1) {
					maxValue = plus1;
				}
				if (maxValue < plus2) {
					maxValue = plus2;
				}

				if (target > maxValue) {
					answer += (target - maxValue);
				}
			}
			sb.append("#").append(c).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
