package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9095_1_2_3_더하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] save = new int[11];
		save[1] = 1;
		save[2] = 2;
		save[3] = 4;
		for (int i = 4; i < 11; i++) {
			save[i] = save[i - 1] + save[i - 2] + save[i - 3];
		}
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(save[N]).append("\n");
		}
		System.out.println(sb);
	}
	
}