package sw;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AX5MvY2anG4DFAX1&contestProbId=AWBOKg-a6l0DFAWr&probBoxId=AX_ypNnKRDwDFAVy+&type=PROBLEM&problemBoxTitle=0404&problemBoxCnt=++1+
public class SW0404_최장증가부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] array = new int[N];
			int[] save = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < array.length; i++) {
				array[i] = Integer.parseInt(st.nextToken());
				save[i] = 1;
			}

			for (int current = 1; current < array.length; current++) {
				for (int past = current - 1; past >= 0; past--) {
					if (array[past] < array[current] && save[past] + 1 > save[current]) {
						save[current] = save[past] + 1;
					}
				}
			}
			int max = 1;
			for (int i = 0; i < save.length; i++) {
				if (max < save[i]) {
					max = save[i];
				}
			}
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}
