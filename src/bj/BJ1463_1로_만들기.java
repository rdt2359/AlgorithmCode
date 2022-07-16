package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1463_1로_만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] save = new int[1000001];
		Arrays.fill(save, -1);
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		save[N] = 0;
		while (!q.isEmpty()) {
			int val = q.remove();
			if (val == 1) {
				System.out.println(save[1]);
				break;
			}
			if (val % 3 == 0 && save[val / 3] == -1) {
				q.add(val / 3);
				save[val / 3] = save[val] + 1;
			}
			if (val % 2 == 0 && save[val / 2] == -1) {
				q.add(val / 2);
				save[val / 2] = save[val] + 1;
			}
			if (save[val - 1] == -1) {
				q.add(val - 1);
				save[val - 1] = save[val] + 1;
			}
		}
	}
}