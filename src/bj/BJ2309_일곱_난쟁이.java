package bj;

import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/2309
public class BJ2309_일곱_난쟁이 {
	static StringBuilder sb;
	static StringTokenizer st;
	static int R;
	static int C;

	// 2명을 뽑아 전체에서 뺌
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int[] array = new int[9];
		boolean[] flag = new boolean[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			array[i] = Integer.parseInt(br.readLine());
			sum += array[i];
		}
		loop: for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - array[i] - array[j] == 100) {
					flag[i] = true;
					flag[j] = true;
					break loop;
				}
			}
		}
		ArrayList<Integer> answer = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			if (!flag[i]) {
				answer.add(array[i]);
			}
		}
		Collections.sort(answer);
		for (int value : answer) {
			sb.append(value).append("\n");
		}
		System.out.println(sb);
	}

}
