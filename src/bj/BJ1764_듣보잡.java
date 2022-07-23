package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ1764_듣보잡 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> set = new HashSet<>();
		ArrayList<String> list= new ArrayList<>();
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if (set.contains(s)) {
				list.add(s);
			}
		}
		Collections.sort(list);
		sb.append(list.size()).append("\n");
		for(String s : list) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}
}