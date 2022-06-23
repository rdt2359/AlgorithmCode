package sw;

import java.io.*;
import java.util.LinkedList;
import java.util.Stack;

public class SW1223_계산기3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int c = 1; c <= 10; c++) {
			br.readLine();
			LinkedList<Character> list = new LinkedList<>();
			Stack<Character> temp = new Stack<>();
			char[] input = br.readLine().toCharArray();
			boolean flag = false;
			for (char ch : input) {
				if (ch != '*' && ch != '+' && ch != '(' && ch != ')') {
					list.add(ch);
				} else if (temp.isEmpty()) {
					temp.add(ch);
				} else if (ch == '(') {
					flag = true;
					temp.add(ch);
				} else if (flag && (ch == '+' || ch == '*')) {
					temp.add(ch);
				} else if (ch == ')') {
					while (temp.peek() != '(') {
						list.add(temp.pop());
					}
					temp.pop();
					flag = false;
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
