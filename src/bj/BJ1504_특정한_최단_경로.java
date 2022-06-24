package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1504_특정한_최단_경로 {

	static ArrayList<Node>[] store;
	static int[] dist;
	static boolean[] check;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] mustVisit = new int[2];
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int E = Integer.parseInt(s[1]);
		store = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			store[i] = new ArrayList<Node>();
		}
		dist = new int[N + 1];
		check = new boolean[N + 1];

		for (int i = 0; i < E; i++) {
			s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			int dis = Integer.parseInt(s[2]);
			store[x].add(new Node(y, dis));
			store[y].add(new Node(x, dis));

		}

		s = br.readLine().split(" ");
		mustVisit[0] = Integer.parseInt(s[0]);
		mustVisit[1] = Integer.parseInt(s[1]);
		int answer = -1;
		int mustVisitMinDis = dijkstra(mustVisit[0], mustVisit[1]);

		if (mustVisitMinDis != Integer.MAX_VALUE) {
			int result1 = dijkstra(1, mustVisit[0]);
			int result2 = dijkstra(N, mustVisit[1]);
			int answer1 = Integer.MAX_VALUE;
			if (result1 != Integer.MAX_VALUE && result2 != Integer.MAX_VALUE) {
				answer1 = result1 + result2 + mustVisitMinDis;
			}

			result1 = dijkstra(1, mustVisit[1]);
			result2 = dijkstra(N, mustVisit[0]);
			int answer2 = Integer.MAX_VALUE;
			if (result1 != Integer.MAX_VALUE && result2 != Integer.MAX_VALUE) {
				answer2 = result1 + result2 + mustVisitMinDis;
			}

			answer = Math.min(answer1, answer2);
			if (answer == Integer.MAX_VALUE) {
				answer = -1;
			}
		}

		System.out.println(answer);
	}

	public static int dijkstra(int start, int end) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(check, false);

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.y;

			if (!check[cur]) {
				check[cur] = true;

				for (Node node : store[cur]) {
					if (!check[node.y] && dist[node.y] > dist[cur] + node.dis) {
						dist[node.y] = dist[cur] + node.dis;
						pq.add(new Node(node.y, dist[node.y]));
					}
				}
			}
		}
		return dist[end];
	}

	public static class Node implements Comparable<Node> {
		int y;
		int dis;

		public Node(int y, int dis) {
			super();
			this.y = y;
			this.dis = dis;
		}

		@Override
		public int compareTo(Node o) {
			return dis - o.dis;
		}

	}
}