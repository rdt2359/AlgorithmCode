package bj;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/11725
public class BJ11725_트리의_부모_찾기 {
	static StringBuilder sb;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[n + 1];
		int[] check = new int[n + 1];
		HashMap<Integer, LinkedList<Integer>> tree = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			tree.put(i, new LinkedList<>());
		}
		for (int i = 1; i < n; i++) {
			String[] ss = br.readLine().split(" ");
			int a = Integer.parseInt(ss[0]);
			int b = Integer.parseInt(ss[1]);
			tree.get(a).add(b);
			tree.get(b).add(a);
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;
		while (!queue.isEmpty()) {
			int remove = queue.remove();
			for (int value : tree.get(remove)) {
				if (!visited[value]) {
					check[value] = remove;
					visited[value] = true;
					queue.add(value);
				}
			}
		}

		for (int i = 2; i < check.length; i++) {
			sb.append(check[i]).append("\n");
		}
		System.out.println(sb);
	}

}
