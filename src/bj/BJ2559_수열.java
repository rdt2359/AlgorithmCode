package bj;
import java.io.*;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2559
public class BJ2559_수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] ss = br.readLine().split(" ");
		int N = Integer.parseInt(ss[0]);
		int K = Integer.parseInt(ss[1]);
		int[] input = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i <= N - K; i++) {
			int tempSum = 0;
			for (int j = i; j < i + K; j++) {
				tempSum += input[j];
			}
			if (tempSum > max) {
				max = tempSum;
			}
		}
		System.out.println(max);
	}

}