package bj;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1753_최단경로 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] ss = br.readLine().split(" ");
		int V = Integer.parseInt(ss[0]);
		int E = Integer.parseInt(ss[1]);

		int start = Integer.parseInt(br.readLine());
		Node[] nodes = new Node[V + 1];

		StringTokenizer st = null;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			nodes[u] = new Node(v, w, nodes[u]);
		}

		int[] distance = new int[V + 1]; // 출발지에서 자신으로 오는 최소비용
		boolean[] visited = new boolean[V + 1]; // 최소비용 확정여부

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0; // 시작점 0으로

		for (int i = 1; i <= V; i++) {
			// 단계1 : 최소비용이 확정되지 않은 정점중 최소비용의 정점 선택
			int min = Integer.MAX_VALUE, current = 0;
			for (int j = 1; j <= V; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}

			visited[current] = true;

			// 단계2 : 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른정점의 최소비용을 고려
			for (Node temp = nodes[current]; temp != null; temp = temp.link) {
				if (!visited[temp.vertex] && distance[temp.vertex] > distance[current] + temp.weight) {
					distance[temp.vertex] = distance[current] + temp.weight;
				}
			}
		}

		for (int i = 1; i < distance.length; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
			} else {
				sb.append(distance[i]).append("\n");

			}
		}
		System.out.println(sb);
	}

	public static class Node {
		int vertex;
		int weight;
		Node link;

		public Node(int vertex, int weight, Node link) {
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}
	}
}