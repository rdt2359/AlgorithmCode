package bj;

import java.io.*;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10163
public class BJ13300_방_배정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int array[][] = new int[2][7];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			array[S][Y]++;
		}
		int sum = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 7; j++) {
				int t = array[i][j] / K;
				int r = array[i][j] % K;
				sum += t;
				if (r != 0) {
					sum++;
				}
			}
		}
		System.out.println(sum);

	}

}