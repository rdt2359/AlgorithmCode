package sw;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV_mSnmKUckDFAWb
public class SW3124_최소_스패닝_트리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int C = Integer.parseInt(br.readLine());

		for (int c = 1; c <= C; c++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			Node[] nodes = new Node[E];
			int[] array = new int[V + 1];
			for (int i = 1; i <= V; i++) {
				array[i] = i;
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}

			Arrays.sort(nodes);
			long min = 0;
			int cnt = 1;

			for (int i = 0; i < E; i++) {
				if (union(nodes[i].x1, nodes[i].x2, array)) {
					min += nodes[i].v;
					cnt++;
					if (cnt == V) {
						break;
					}
				}
			}
			sb.append("#").append(c).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	public static boolean union(int a, int b, int[] array) {
		int aRoot = findSet(a, array);
		int bRoot = findSet(b, array);
		if (aRoot == bRoot) {
			return false;
		}
		array[bRoot] = aRoot;
		return true;
	}

	public static int findSet(int a, int[] array) {
		if (a == array[a]) {
			return a;
		}
		return array[a] = findSet(array[a], array);
	}

	static class Node implements Comparable<Node> {
		int x1;
		int x2;
		long v;

		public Node(int x1, int x2, long v) {
			this.x1 = x1;
			this.x2 = x2;
			this.v = v;
		}

		@Override
		public int compareTo(Node o) {
			return (int) (this.v - o.v);
		}

	}
}
