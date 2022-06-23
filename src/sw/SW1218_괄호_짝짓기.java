package sw;
import java.io.*;
import java.util.Stack;

//[S/W 문제해결 기본] 4일차 - 괄호 짝짓기 https://swexpertacademy.com/main/talk/solvingClub/problemView.do
public class SW1218_괄호_짝짓기 {
	static StringBuilder sb;
	static int maxCal;
	static int num;
	static int maxScore;
	static int[] inputScore;
	static int[] inputCal;
	static boolean[] isUsed;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int cc = 1; cc <= 10; cc++) {
			br.readLine();
			String[] inputs = br.readLine().split("");
			Stack<String> stack = new Stack<String>();
			boolean isCorrect = true;
			for (String s : inputs) {
				if (s.equals("(") || s.equals("[") || s.equals("{") || s.equals("<")) {
					stack.push(s);
				} else {
					if (stack.isEmpty()) {
						isCorrect = false;
						break;
					}
					String peek = stack.peek();
					if (peek.equals("(") && s.equals(")")) {
						stack.pop();
					} else if (peek.equals("[") && s.equals("]")) {
						stack.pop();
					} else if (peek.equals("{") && s.equals("}")) {
						stack.pop();
					} else if (peek.equals("<") && s.equals(">")) {
						stack.pop();
					} else {
						isCorrect = false;
						break;
					}
				}
			}
			sb.append("#").append(cc).append(" ").append(isCorrect ? "1" : "0").append("\n");
		}
		System.out.println(sb);
	}
}
