package sw;

import java.io.*;
import java.util.*;

public class SW1238_Contact {
	static StringBuilder sb;
	static boolean[] isUsed;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		for (int cc = 1; cc <= 10; cc++) {
			String[] ss1 = br.readLine().split(" ");

			int N = Integer.parseInt(ss1[0]);
			int M = Integer.parseInt(ss1[1]);

			isUsed = new boolean[N + 1];

			Map<Integer, TreeSet<Integer>> map = new HashMap<>();
			Map<Integer, TreeSet<Integer>> save = new HashMap<>();

			for (int i = 1; i <= N; i++) {
				map.put(i, new TreeSet<>());
			}
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N / 2; i++) {
				map.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
			}

			bfs(M, map, save);
			int maxKey = -1;
			for (int key : save.keySet()) {
				if (maxKey < key) {
					maxKey = key;
				}
			}
			sb.append("#").append(cc).append(" ").append(save.get(maxKey).last()).append("\n");
		}
		System.out.println(sb);
	}

	public static void bfs(int index, Map<Integer, TreeSet<Integer>> map, Map<Integer, TreeSet<Integer>> save) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { index, 1 });
		isUsed[index] = true;
		save.put(1, new TreeSet<Integer>());
		save.get(1).add(index);

		while (!queue.isEmpty()) {
			int[] remove = queue.remove();
			int value = remove[0];
			for (int i : map.get(value)) {
				if (!isUsed[i]) {
					queue.add(new int[] { i, remove[1] + 1 });
					isUsed[i] = true;

					if (save.get(remove[1] + 1) == null) {
						save.put(remove[1] + 1, new TreeSet<Integer>());
					}
					save.get(remove[1] + 1).add(i);
				}
			}
		}
	}
}
