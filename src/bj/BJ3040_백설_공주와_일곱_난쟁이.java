package bj;

import java.io.*;
//https://www.acmicpc.net/problem/3040

public class BJ3040_백설_공주와_일곱_난쟁이 {
	static int N;
	static int minValue = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] input = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			int value = Integer.parseInt(br.readLine());
			input[i] = value;
			sum += value;
		}
		int answer1 = -1;
		int answer2 = -1;
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - input[i] - input[j] == 100) {
					answer1 = i;
					answer2 = j;
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			if (i != answer1 && i != answer2) {
				sb.append(input[i]).append("\n");
			}
		}
		System.out.println(sb);
	}
}
