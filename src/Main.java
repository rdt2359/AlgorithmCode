import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static HashMap<Integer, ArrayList<Node>> map = new HashMap<>();
	static int max = Integer.MIN_VALUE;
	static int end = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int V = Integer.parseInt(br.readLine());
		for (int i = 1; i <= V; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			while (true) {
				int m = Integer.parseInt(st.nextToken());
				if (m == -1) {
					break;
				}
				int val = Integer.parseInt(st.nextToken());

				if (map.get(n) == null) {
					map.put(n, new ArrayList<>());
				}
				map.get(n).add(new Node(m, val));
			}
		}

		boolean[] isUsed = new boolean[V + 1];
		dfs(1, 0, isUsed);

		Arrays.fill(isUsed, false);
		dfs(end, 0, isUsed);

		System.out.println(max);
	}

	private static void dfs(int start, int length, boolean[] isUsed) {
		isUsed[start] = true;
		if (length > max) {
			max = length;
			end = start;
		}
		for (int i = 0; i < map.get(start).size(); i++) {
			Node node = map.get(start).get(i);
			if (!isUsed[node.end]) {
				dfs(node.end, length + node.val, isUsed);
			}
		}
	}

	public static class Node {

		public Node(int end, int val) {
			this.end = end;
			this.val = val;
		}

		public int end;
		public int val;
	}
}