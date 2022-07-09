package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14938_서강그라운드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 지역
		int M = Integer.parseInt(st.nextToken()); // 수색범위
		int R = Integer.parseInt(st.nextToken()); // 길의 개수

		int area[] = new int[N + 1];
		int max = Integer.MIN_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			area[i] = Integer.parseInt(st.nextToken());
		}

		ArrayList<ArrayList<Node>> list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Node>());
		}

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			list.get(f).add(new Node(s, t));
			list.get(s).add(new Node(f, t));
		}

		for (int i = 1; i <= N; i++) {
			int temp = 0;
			temp += area[i];

			Queue<Node> q = new LinkedList<>();
			q.add(new Node(i, 0));

			boolean[] isUsed = new boolean[N + 1];
			isUsed[i] = true;
			while (!q.isEmpty()) {
				Node remove = q.remove();
				for (Node n : list.get(remove.to)) {
					if (remove.val + n.val <= M) {
						q.add(new Node(n.to, remove.val + n.val));
						if (!isUsed[n.to]) {
							temp += area[n.to];
							isUsed[n.to] = true;
						}
					}
				}
			}
			if (max < temp) {
				max = temp;
			}
		}
		System.out.println(max);
	}

	static class Node {

		int to;
		int val;

		public Node(int to, int val) {
			this.to = to;
			this.val = val;
		}

	}
}