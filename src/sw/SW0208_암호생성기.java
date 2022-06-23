package sw;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
//[S/W 문제해결 기본] 7일차 - 암호생성기  https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AX5MvY2anG4DFAX1&contestProbId=AV14uWl6AF0CFAYD&probBoxId=AX7XYZwa4esDFAVm+&type=PROBLEM&problemBoxTitle=0208&problemBoxCnt=++1+
public class SW0208_암호생성기 {
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		for (int C = 1; C <= 10; C++) {
			Queue<Integer> queue = new LinkedList<>();
			br.readLine();
			String[] input = br.readLine().split(" ");
			for (String s : input) {
				queue.offer(Integer.parseInt(s));
			}

			int cnt = 1;
			while (queue.peek() - cnt > 0) {
				queue.offer(queue.poll() - cnt++);
				if (cnt == 6) {
					cnt = 1;
				}
			}
			queue.poll();
			queue.offer(0);

			sb.append("#").append(C).append(" ");
			while (!queue.isEmpty()) {
				sb.append(queue.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
