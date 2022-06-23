package bj;
import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/1260
public class BJ1260_DFS와_BFS {
	static StringBuilder sb;
	static boolean[] isUsed;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String[] ss1 = br.readLine().split(" ");
		int N = Integer.parseInt(ss1[0]);
		int M = Integer.parseInt(ss1[1]);
		int V = Integer.parseInt(ss1[2]);
		isUsed = new boolean[N + 1];

		HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			map.put(i, new TreeSet<>());
		}
		for (int i = 0; i < M; i++) {
			String[] ss2 = br.readLine().split(" ");
			map.get(Integer.parseInt(ss2[0])).add(Integer.parseInt(ss2[1]));
			map.get(Integer.parseInt(ss2[1])).add(Integer.parseInt(ss2[0]));
		}

		dfs(V, map);

		sb.append("\n");
		isUsed = new boolean[N + 1];

		bfs(V, map);
		System.out.println(sb);

	}

	public static void dfs(int index, HashMap<Integer, TreeSet<Integer>> map) {
		if (!isUsed[index]) {
			isUsed[index] = true;
			sb.append(index).append(" ");
			for (int i : map.get(index)) {
				dfs(i, map);
			}
		}
	}

	public static void bfs(int index, HashMap<Integer, TreeSet<Integer>> map) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(index);
		isUsed[index] = true;
		while (!queue.isEmpty()) {
			int value = queue.remove();
			sb.append(value).append(" ");
			for (int i : map.get(value)) {
				if (!isUsed[i]) {
					queue.add(i);
					isUsed[i] = true;
				}
			}
		}
	}

}
