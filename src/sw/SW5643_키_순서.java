package sw;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXQsLWKd5cDFAUo
public class SW5643_키_순서 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine()); // 학생수
			int M = Integer.parseInt(br.readLine()); // 학생 키 비교
			int sum = 0;
			ArrayList<ArrayList<Integer>> small = new ArrayList<>();
			ArrayList<ArrayList<Integer>> big = new ArrayList<>();

			for (int i = 0; i <= N; i++) {
				small.add(new ArrayList<>());
				big.add(new ArrayList<>());
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				small.get(b).add(s);
				big.get(s).add(b);
			}
			for (int i = 1; i <= N; i++) {
				int cnt = 1;
				boolean[] isUsed = new boolean[N + 1];
				Queue<Integer> queue = new LinkedList<>();
				queue.add(i);
				while (!queue.isEmpty()) {
					int pop = queue.poll();
					for (int b : big.get(pop)) {
						if (!isUsed[b]) {
							queue.add(b);
							cnt++;
							isUsed[b] = true;
						}
					}
				}
				isUsed = new boolean[N + 1];
				queue.add(i);
				while (!queue.isEmpty()) {
					int pop = queue.poll();
					for (int b : small.get(pop)) {
						if (!isUsed[b]) {
							queue.add(b);
							cnt++;
							isUsed[b] = true;
						}
					}
				}
				if (cnt == N) {
					sum++;
				}
			}
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
}