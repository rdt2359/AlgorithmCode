package bj;
import java.io.*;

//https://www.acmicpc.net/problem/2961
public class BJ2961_도영이가_만든_맛있는_음식 {
	static int N;
	static int minValue = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		int[][] food = new int[N][2];
		for (int cc = 0; cc < N; cc++) {
			String[] ss = br.readLine().split(" ");
			food[cc][0] = Integer.parseInt(ss[0]);
			food[cc][1] = Integer.parseInt(ss[1]);
		}
		function(0, 1, 0, food, 0);
		System.out.println(minValue);
	}

	public static void function(int index, int sour, int bitter, int[][] food, int choice) {
		if (index == N) {
			int diff = Math.abs(sour - bitter);
			if (minValue > diff && choice != 0) {
				minValue = diff;
			}
			return;
		}
		function(index + 1, sour * food[index][0], bitter + food[index][1], food, choice + 1);
		function(index + 1, sour, bitter, food, choice);
	}
}
