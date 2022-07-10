package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16928_뱀과_사다리_게임 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Node[] list = new Node[101];
		boolean[] isVisited = new boolean[101];

		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from] = new Node(to, 0);
		}

		int answer = Integer.MAX_VALUE;

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(1, 0));
		isVisited[1] = true;

		while (!q.isEmpty()) {
			Node node = q.remove();
			if (node.index == 100) {
				answer = node.cnt;
				break;
			}

			for (int i = 1; i <= 6; i++) {
				int next = node.index + i;
				if (next <= 100 && !isVisited[next]) {
					isVisited[next] = true;
					if (list[next] != null) {
						q.add(new Node(list[next].index, node.cnt + 1));

					} else {
						q.add(new Node(next, node.cnt + 1));
					}
				}
			}
		}

		System.out.println(answer);
	}

	public static class Node {
		int index;
		int cnt;

		public Node(int index, int cnt) {
			super();
			this.index = index;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [index=" + index + ", cnt=" + cnt + "]";
		}

	}
}