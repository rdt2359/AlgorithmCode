package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1927_최소_힙 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int T = Integer.parseInt(br.readLine());
			if (T > 0) {
				pq.add(T);
			} else {
				Integer val = pq.poll();
				if (val == null) {
					val = 0;
				}
				sb.append(val).append("\n");
			}
		}
		System.out.println(sb);
	}
}