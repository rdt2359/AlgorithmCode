package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/16637
public class BJ16637_괄호_추가하기 {
	static int maxValue = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int[] num = new int[n / 2 + 1];
		char[] oper = new char[n / 2];
		int numCnt = 0;
		int operCnt = 0;
		for (char c : input.toCharArray()) {
			if (c == '+' || c == '-' || c == '*') {
				oper[operCnt++] = c;
			} else {
				num[numCnt++] = c - '0';
			}
		}

		recursive(0, num[0], num, oper, n);
		System.out.println(maxValue);
	}

	static int cal(int a, int b, char oper) {
		if (oper == '+') {
			return a + b;
		} else if (oper == '-') {
			return a - b;
		} else {
			return a * b;
		}
	}
	
	// 1~(2~3)~4~5~6~7 -> ?~4~5~6~7 
	// (1~2)~3~4~5~6~7 -> ?~3~4~5~6~7 
	static void recursive(int index, int result, final int[] num, final char[] oper, final int n) {
		if (index + 1 == num.length) {
			if (result > maxValue) {
				maxValue = result;
			}
		} else if (index + 1 < num.length) { // 최소 2개 숫자 남은 경우
			int val = 0;

			val = cal(result, num[index + 1], oper[index]); // 앞에 먼저 계산
			recursive(index + 1, val, num, oper, n);

			if (index + 2 < num.length) { // 3개 이상 숫자 남은 경우
				val = cal(result, cal(num[index + 1], num[index + 2], oper[index + 1]), oper[index]); // 뒤에 먼저 계산
				recursive(index + 2, val, num, oper, n);
			}
		}
	}

}