package bj;

import java.io.*;
import java.util.Stack;

//https://www.acmicpc.net/problem/17413
public class BJ17413_단어_뒤집기_2 {

	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();

		Stack<Character> stack = new Stack<>(); // 뒤집을 단어 저장할 스택
		boolean tagFlag = false; 				//태그 안에 있는 문자 탐색 확인
		for (char c : input.toCharArray()) {
			if (c == ' ') { // 공백 문자 존재 시 stack 비움
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(" ");
			} else if (c == '<') { // 괄호 시작 : 괄호는 뒤집지 않음
				while (!stack.isEmpty()) { // 괄호 이전 문자 스택에 존재 시 스택 비움
					sb.append(stack.pop());
				}
				sb.append("<");
				tagFlag = true; // 공백 안 문자 처리 flag
			} else if (c == '>') {
				sb.append(">");
				tagFlag = false; // 공백 안 문자 처리 flag 
			} else {
				if (tagFlag) {
					sb.append(c); //flag true일 경우 문자열 바로 저장 
				} else {
					stack.add(c); //flag false일 경우 문자열 stack에 추가
				}
			}
		}
		while (!stack.isEmpty()) { // 스택에 데이터 있으면 뒤집어서 추가
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}
}
