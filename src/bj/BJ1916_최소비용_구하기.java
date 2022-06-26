package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1916_최소비용_구하기 {

	public static ArrayList<ArrayList<Node>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Node>());
		}

		for (int i = 1; i <= M; i++) {
			String[] s = br.readLine().split(" ");
			list.get(Integer.parseInt(s[0])).add(new Node(Integer.parseInt(s[1]), Integer.parseInt(s[2])));
		}
		String[] s = br.readLine().split(" ");
		int start = Integer.parseInt(s[0]);
		int end = Integer.parseInt(s[1]);
		System.out.println(dijkstra(start, end, N));
	}

	public static int dijkstra(int start, int end, int N) {
		boolean[] isUsed = new boolean[N + 1];
		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		while (!pq.isEmpty()) {
			int index = pq.poll().index;
			if (!isUsed[index]) {
				isUsed[index] = true;
				for (Node node : list.get(index)) {
					if (distance[node.index] > distance[index] + node.distance) {
						distance[node.index] = distance[index] + node.distance;
						pq.add(new Node(node.index, distance[node.index]));
					}
				}
			}
		}
		return distance[end];
	}

	public static class Node implements Comparable<Node> {
		int index;
		int distance;

		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node n) {
			return this.distance - n.distance;
		}

	}

}