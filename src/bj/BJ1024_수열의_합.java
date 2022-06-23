package bj;

import java.io.*;

public class BJ1024_수열의_합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int L = Integer.parseInt(s[1]);
		//정답 기록
		int answerStart = Integer.MIN_VALUE; // 정답의 시작 숫자
		int answerCnt = -1;

		for (int i = L; i <= 100; i++) {
			int middle = N / i;
			int sumCnt = 1; // 숫자를 더한 횟수
			int index = 1;
			int sum = middle;
			answerStart = middle;

			while (sumCnt < i) {
				sum += middle + index; // 우측값 더함
				sumCnt++;
				if (sumCnt < i) {
					sum += middle - index; // 좌측값 더함
					sumCnt++;
					answerStart = middle - index; // 정답 시작값 설정
					if (middle - index < 0) { // 예외처리 : 좌측값이 0이하일 경우 정답 X, 반복 취소
						sum = Integer.MIN_VALUE;
						break;
					}
				}
				index++;
			}
			if (sum == N) {
				answerCnt = i;
				break;
			}
		}

		if (answerCnt == -1) {
			sb.append("-1");
		} else {
			for (int i = 0; i < answerCnt; i++) {
				sb.append(answerStart + i).append(" ");
			}
		}
		System.out.println(sb);
	}
}
