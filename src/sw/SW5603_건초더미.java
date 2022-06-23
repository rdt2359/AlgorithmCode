package sw;
import java.io.*;
import java.util.StringTokenizer;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXGEbd6cjMDFAUo
public class SW5603_건초더미 {
	static int[] dr = { 0, -1, 0, 1, 1, 1, -1, -1 };
	static int[] dc = { 1, 0, -1, 0, -1, 1, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int C = Integer.parseInt(br.readLine());
		for (int cc = 1; cc <= C; cc++) {
			int N = Integer.parseInt(br.readLine());
			int[] array = new int[N];

			int avg = 0;
			int answer = 0;

			for (int i = 0; i < N; i++) {
				int value = Integer.parseInt(br.readLine());
				array[i] = value;
				avg += value;
			}
			avg /= N;

			for (int i = 0; i < N; i++) {
				answer += Math.abs(array[i] - avg);
			}

			sb.append("#").append(cc).append(" ").append(answer / 2).append("\n");
		}
		System.out.println(sb);
	}

}