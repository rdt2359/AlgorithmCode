package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1697_숨바꼭질 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] save = new int[200000];
		Arrays.fill(save, -1);
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(N, 0));
		while (!q.isEmpty()) {
			Point remove = q.remove();
			if (remove.p == M) {
				System.out.println(remove.val);
				break;
			}
			if (0 <= remove.p - 1 && save[remove.p - 1] == -1) {
				save[remove.p - 1] = remove.val + 1;
				q.add(new Point(remove.p - 1, remove.val + 1));
			}
			if (remove.p + 1 < 200000 && save[remove.p + 1] == -1) {
				save[remove.p + 1] = remove.val + 1;
				q.add(new Point(remove.p + 1, remove.val + 1));
			}
			if (remove.p * 2 < 200000 && save[remove.p * 2] == -1) {
				save[remove.p * 2] = remove.val + 1;
				q.add(new Point(remove.p * 2, remove.val + 1));
			}
		}
	}

	static class Point {
		int p;
		int val;

		public Point(int p, int val) {
			this.p = p;
			this.val = val;
		}

	}
}