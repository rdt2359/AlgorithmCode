package sw;
import java.io.*;
import java.util.StringTokenizer;

//https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AX5MvY2anG4DFAX1&contestProbId=AV15OZ4qAPICFAYD&probBoxId=AX8Ftyh6JKgDFAW0+&type=PROBLEM&problemBoxTitle=0217&problemBoxCnt=++1+

public class SW0217_1_최적_경로 {
	static StringBuilder sb;
	static int min;
	static boolean[] isUsed;
	static int N;
	static int preX;
	static int preY;
	static int[][] array;
	static int homeX;
	static int homeY;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		sb = new StringBuilder();
		int C = Integer.parseInt(br.readLine());
		for (int cc = 1; cc <= C; cc++) {
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			array = new int[N][2];
			isUsed = new boolean[N];
			st = new StringTokenizer(br.readLine());
			int workX = Integer.parseInt(st.nextToken());
			int workY = Integer.parseInt(st.nextToken());
			homeX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				array[i][0] = Integer.parseInt(st.nextToken());
				array[i][1] = Integer.parseInt(st.nextToken());
			}

			check(0, 0, workX, workY);
			sb.append("#").append(cc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);

	}

	public static void check(int cnt, int sum, int preX, int preY) {
		if (cnt == N) {
			sum += Math.abs(preX - homeX) + Math.abs(preY - homeY); // 집가는 마지막 경우 추가 필요
			if (min > sum) {
				min = sum;
			}
			return;
		} else if (sum > min) { // 현재까지 더한 값이 탐색을 완료한 최소 거리보다 클경우 해당 Case 탐색 종료
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!isUsed[i]) {
				isUsed[i] = true;
				check(cnt + 1, sum + Math.abs(preX - array[i][0]) + Math.abs(preY - array[i][1]), array[i][0],
						array[i][1]);
				isUsed[i] = false;

			}
		}
	}

}
