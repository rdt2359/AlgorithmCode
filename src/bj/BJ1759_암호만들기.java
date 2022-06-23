package bj;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1759
public class BJ1759_암호만들기 {
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String[] ss = br.readLine().split(" ");
		int L = Integer.parseInt(ss[0]);
		int C = Integer.parseInt(ss[1]);
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] input = new char[C];
		for (int i = 0; i < C; i++) {
			input[i] = st.nextToken().toCharArray()[0];
		}
		boolean[] isUsed = new boolean[C];
		Arrays.sort(input);
		function(0, 0, 0, input, L, C, isUsed);
		System.out.println(sb);
	}

	public static void function(int cnt, int index, int vowel, char[] input, int L, int C, boolean[] isUsed) {
		if (index >= C) {
			if (cnt == L && vowel >= 1 && L - vowel >= 2) { // 자음 모음 체크
				for (int i = 0; i < C; i++) {
					if (isUsed[i]) {
						sb.append(input[i]);
					}
				}
				sb.append("\n");
			}
			return;
		}

		boolean isVowel = false;

		if (input[index] == 'a' || input[index] == 'e' || input[index] == 'i' || input[index] == 'o'
				|| input[index] == 'u') {
			isVowel = true;
		}

		if (cnt < L) { // 여태까지 선택한 문자열 길이가 L보다 적을 경우만 선택 가능
			isUsed[index] = true;
			function(cnt + 1, index + 1, isVowel ? vowel + 1 : vowel, input, L, C, isUsed);
			isUsed[index] = false;
		}

		function(cnt, index + 1, vowel, input, L, C, isUsed);

	}
}
