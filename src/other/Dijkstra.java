package other;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/14502
public class Dijkstra {

	private static int N;
	private static int M;
	private static int X;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		List<List<Node>> normal = new ArrayList<>();
		List<List<Node>> reverse = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			normal.add(new ArrayList<>());
			reverse.add(new ArrayList<>());
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			normal.get(from).add(new Node(to, t));
			reverse.get(to).add(new Node(from, t));
		}

		int[] normalDis = dijkstra(normal);
		int[] reverseDis = dijkstra(reverse);

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, normalDis[i] + reverseDis[i]);
		}
		System.out.println(max);
	}

	private static int[] dijkstra(List<List<Node>> list) {
		boolean[] visited = new boolean[N + 1];
		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[X] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(X, 0));

		while (!pq.isEmpty()) {
			int idx = pq.poll().index;

			if (!visited[idx]) {
				visited[idx] = true;

				for (Node node : list.get(idx)) {
					if (distance[node.index] > distance[idx] + node.distance) {
						distance[node.index] = distance[idx] + node.distance;
						pq.add(new Node(node.index, distance[node.index]));
					}
				}
			}
		}
		return distance;
	}

	static class Node implements Comparable<Node> {
		int index;
		int distance;

		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}

		public int compareTo(Node n) {
			return this.distance - n.distance;
		}
	}
}