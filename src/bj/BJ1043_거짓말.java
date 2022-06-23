package bj;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://www.acmicpc.net/problem/1043
public class BJ1043_거짓말 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] ss = br.readLine().split(" ");
		int N = Integer.parseInt(ss[0]);
		int M = Integer.parseInt(ss[1]);

		boolean[] knowTruth = new boolean[N + 1]; // 진실을 아는 사람들
		int[] array = new int[N + 1]; // unionFind
		ArrayList<Set<Integer>> teams = new ArrayList<>(); // 각 팀별 집합 저장

		for (int i = 1; i <= N; i++) { // union find 초기화
			array[i] = i;
		}

		ss = br.readLine().split(" ");
		for (int i = 1; i <= Integer.parseInt(ss[0]); i++) { // 초기값으로 주어진 진실을 아는 사람
			knowTruth[Integer.parseInt(ss[i])] = true;
		}

		for (int i = 0; i < M; i++) { // Union find 및 팀별 집합 저장
			ss = br.readLine().split(" ");
			Set<Integer> tempTeam = new HashSet<>();
			teams.add(tempTeam);

			tempTeam.add(Integer.parseInt(ss[1]));
			for (int j = 2; j < ss.length; j++) {
				int previous = Integer.parseInt(ss[j - 1]);
				int current = Integer.parseInt(ss[j]);

				union(previous, current, array);
				// temp.add(previous);
				tempTeam.add(current);
			}
		}

		boolean[] copyKnowTruth = Arrays.copyOf(knowTruth, knowTruth.length);
		// 입력으로 주어진 진실을 아는 사람을 포함한 파티의 인원을 진실을 아는 사람으로 설정
		for (int i = 1; i <= N; i++) {
			if (copyKnowTruth[i]) {
				int root = findSet(i, array);
				//TODO 반복
				for (int j = 1; j < N + 1; j++) {
					if (findSet(j, array) == root) {
						knowTruth[j] = true;
					}
				}
			}
		}

		int cnt = 0;
		loop: for (Set<Integer> s : teams) { // 각 팀별 탐색하여 팀에 있는 모든 인원인 진실을 모를경우 cnt 증가
			for (int i = 1; i < knowTruth.length; i++) {
				if (knowTruth[i] && s.contains(i)) {
					continue loop;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
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
}