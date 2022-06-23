package bj;
import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/11399
public class BJ11399_ATM {
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Integer[] array = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array, Collections.reverseOrder()); //큰수 기준으로 정렬
		int sum = 0;
		for (int i = 0; i < N; i++) { //큰수 먼저 처리
			sum += (array[i] * (i + 1)); 
		}
		System.out.println(sum);
	}
}
