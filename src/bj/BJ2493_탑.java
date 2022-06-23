package bj;
import java.io.*;
import java.util.Stack;
//탑 https://www.acmicpc.net/problem/2493

public class BJ2493_탑 {
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		String[] ss = br.readLine().split(" ");
		int[] answer = new int[n];
		int[] input = new int[n];
		for (int i = 0; i < ss.length; i++) {
			input[i] = Integer.parseInt(ss[i]);
		}
		
		Stack<Data> stack = new Stack<>();
		stack.push(new Data(input[input.length - 1], input.length - 1));
		
		for (int i = input.length - 2; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek().value < input[i]) {
				Data temp = stack.pop();
				answer[temp.index] = i + 1; // 문제에서 Index는 1부터 시작
			}
			stack.push(new Data(input[i], i));
		}
		
		//정답 출력
		for (int a : answer) {
			sb.append(a).append(" ");
		}
		System.out.println(sb);
	}

	public static class Data {
		public int index;
		public int value;

		Data(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
}
