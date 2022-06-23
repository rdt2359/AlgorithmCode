package sw;

// https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AX5MvY2anG4DFAX1&contestProbId=AV14nnAaAFACFAYD&probBoxId=AX7mER5amHEDFAVm+&type=PROBLEM&problemBoxTitle=0211&problemBoxCnt=3

import java.io.*;
import java.util.LinkedList;
import java.util.Stack;

public class SW1223_계산기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int c = 1; c <= 10; c++) {
			br.readLine();
			LinkedList<Character> list = new LinkedList<>();
			Stack<Character> temp = new Stack<>();
			char[] input = br.readLine().toCharArray();
			for (char ch : input) {
				if (ch != '*' && ch != '+') {
					list.add(ch);
				} else if (temp.isEmpty()) {
					temp.add(ch);
				} else if (ch == '+') {
					while (!temp.isEmpty()) {
						list.add(temp.pop());
					}
					temp.add(ch);
				} else if (ch == '*') {
					while (!temp.isEmpty() && temp.peek() == '*') {
						list.add(temp.pop());
					}
					temp.add(ch);
				}
			}
			while (!temp.isEmpty()) {
				list.add(temp.pop());
			}

			Stack<Integer> answer = new Stack<>();
			while (!list.isEmpty()) {
				if (list.peek() != '+' && list.peek() != '*') {
					answer.add(list.poll() - '0');
				} else {
					int a = answer.pop();
					int b = answer.pop();

					if (list.poll() == '+') {
						answer.add(a + b);
					} else {
						answer.add(a * b);
					}
				}
			}
			sb.append("#").append(c).append(" ").append(answer.pop()).append("\n");
		}
		System.out.println(sb);
	}
}
