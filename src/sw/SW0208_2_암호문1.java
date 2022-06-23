package sw;
import java.io.*;
import java.util.*;

//[S/W 문제해결 기본] 8일차 - 암호문1 https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AX5MvY2anG4DFAX1&contestProbId=AV14w-rKAHACFAYD&probBoxId=AX7XYZwa4esDFAVm&type=PROBLEM&problemBoxTitle=0208&problemBoxCnt=2

public class SW0208_2_암호문1 {
	static StringBuilder sb;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		for (int C = 1; C <= 10; C++) {
			int N = Integer.parseInt(br.readLine());
			String[] ss = br.readLine().split(" ");
			LinkedList<Integer> answer = new LinkedList<>();
			for (int i = 0; i < ss.length; i++) {
				answer.add(i, Integer.parseInt(ss[i]));
			}
			int orderNum = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens() && st.nextToken().equals("I")) {
				int index = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				Stack<Integer> stack = new Stack<>();
				for (int i = 0; i < num; i++) {
					stack.add(Integer.parseInt(st.nextToken()));
				}
				while (!stack.isEmpty()) {
					answer.add(index, stack.pop());
				}
			}

			sb.append("#").append(C).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(answer.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
