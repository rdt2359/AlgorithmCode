package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ13549_숨바꼭질_3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		boolean[] hasVisited = new boolean[200000];

		PriorityQueue<Pos> q = new PriorityQueue<>();
		q.add(new Pos(N, 0));
		int answer = -1;
		while (!q.isEmpty()) {
			Pos remove = q.remove();
			hasVisited[remove.p] = true;
			if (remove.p == K) {
				answer = remove.cnt;
				break;
			}

			if (remove.p * 2 < K * 2) {
				if (!hasVisited[remove.p * 2]) {
					q.add(new Pos(remove.p * 2, remove.cnt));
				}
			}

			if (remove.p - 1 >= 0) {
				if (!hasVisited[remove.p - 1]) {
					q.add(new Pos(remove.p - 1, remove.cnt + 1));
				}
			}

			if (remove.p + 1 <= K) {
				if (!hasVisited[remove.p + 1]) {
					q.add(new Pos(remove.p + 1, remove.cnt + 1));
				}
			}

		}
		System.out.println(answer);
	}

	public static class Pos implements Comparable<Pos> {
		int p;
		int cnt;

		public Pos(int p, int cnt) {
			this.p = p;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Pos c) {
			return this.cnt - c.cnt;
		}

	}
}