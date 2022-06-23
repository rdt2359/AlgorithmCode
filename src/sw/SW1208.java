package sw;

import java.io.*;
import java.util.Arrays;

//[S/W 문제해결 기본] 1일차 - Flatten 
// https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AX5MvY2anG4DFAX1&contestProbId=AV139KOaABgCFAYh&probBoxId=AX7CcH16KvoDFAVm&type=PROBLEM&problemBoxTitle=0204&problemBoxCnt=3

public class SW1208 {

	static StringBuilder sb;
	static int nn;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int c = 1; c <= 10; c++) {
			int[] box = new int[100];
			int dump = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			for (int i = 0; i < 100; i++) {
				box[i] = Integer.parseInt(s[i]);
			}
			Arrays.sort(box);
			for (int i = 0; i < dump; i++) {
				int minIndex = 0;
				int maxIndex = 99;

				for (int j = 1; j < 100; j++) {
					if (box[0] == box[j]) {
						minIndex = j;
					} else {
						break;
					}
				}
				for (int j = 98; j >= 0; j--) {
					if (box[99] == box[j]) {
						maxIndex = j;
					} else {
						break;
					}
				}
				box[minIndex] += 1;
				box[maxIndex] -= 1;
			}
			sb.append("#").append(c).append(" ").append(box[99] - box[0]).append("\n");

		}
		System.out.println(sb);
	}
}