package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1238
public class BJ1238_파티 {

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

		ArrayList<ArrayList<Node>> normalList = new ArrayList<>();
		ArrayList<ArrayList<Node>> reverseList = new ArrayList<>();

		for (int i = 0; i < N + 1; i++) {
			normalList.add(new ArrayList<Node>());
			reverseList.add(new ArrayList<Node>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			normalList.get(from).add(new Node(to, weight));
			reverseList.get(to).add(new Node(from, weight));
		}

		int[] normal = function(normalList);
		int[] reverse = function(reverseList);

		int max = Integer.MIN_VALUE;
		for (int i = 1; i < N + 1; i++) {
			if (max < normal[i] + reverse[i]) {
				max = normal[i] + reverse[i];
			}
		}
		System.out.println(max);

	}

	public static int[] function(ArrayList<ArrayList<Node>> list) {
		boolean[] isUsed = new boolean[N + 1];
		int[] save = new int[N + 1];
		Arrays.fill(save, Integer.MAX_VALUE);
		save[X] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(X, 0));
		while (!pq.isEmpty()) {
			Node node = pq.remove();
			if (!isUsed[node.index]) {
				isUsed[node.index] = true;
				for (Node nextNode : list.get(node.index)) {
					if (save[nextNode.index] > save[node.index] + nextNode.weight) {
						save[nextNode.index] = save[node.index] + nextNode.weight;
						pq.add(new Node(nextNode.index, save[nextNode.index]));
					}
				}
			}
		}
		return save;
	}

	public static class Node implements Comparable<Node> {
		int index;
		int weight;

		public Node(int index, int weight) {
			super();
			this.index = index;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

	}
}