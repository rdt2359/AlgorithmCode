package sw;

import java.io.*;

//https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AWIeUtVakTMDFAVH&solveclubId=AX5MvY2anG4DFAX1&problemBoxTitle=0216&problemBoxCnt=2&probBoxId=AX7_1LnqH_EDFAW0+
public class SW_0216_2_요리사 {
	static int N;
	static int[][] array;
	static int scoreDiff;
	static int totalScoreA;
	static int totalScoreB;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int cc = 1; cc <= T; cc++) {
			N = Integer.parseInt(br.readLine());
			array = new int[N][N];
			scoreDiff = Integer.MAX_VALUE;
			totalScoreA = 0;
			totalScoreB = 0;
			for (int i = 0; i < N; i++) {
				String[] ss = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					array[i][j] = Integer.parseInt(ss[j]);
				}
			}
			boolean[] food = new boolean[N];
			function(0, 0, food);
			sb.append("#").append(cc).append(" ").append(scoreDiff).append("\n");
		}
		System.out.println(sb);
	}

	public static void function(int cnt, int startIdx, boolean[] food) {
		if (cnt == N / 2) {
			calculateScore(food);
			return;
		}
		for (int i = startIdx; i < N; i++) {
			food[i] = true;
			function(cnt + 1, i + 1, food);
			food[i] = false;
		}
	}

	public static void calculateScore(boolean[] food) {
		int[] scoreAIdxsave = new int[2];
		int[] scoreBIdxsave = new int[2];
		int[] foodListA = new int[N / 2];
		int[] foodListB = new int[N / 2];
		int aIndex = 0;
		int bIndex = 0;

		for (int i = 0; i < N; i++) {
			if (food[i]) {
				foodListA[aIndex++] = i;
			} else {
				foodListB[bIndex++] = i;
			}
		}
		function2(0, 0, foodListA, scoreAIdxsave, true);
		function2(0, 0, foodListB, scoreBIdxsave, false);
		int currentScoreDiff = Math.abs(totalScoreA - totalScoreB);
		if (scoreDiff > currentScoreDiff) {
			scoreDiff = currentScoreDiff;
		}
		totalScoreA = 0;
		totalScoreB = 0;
	}

	public static void function2(int index, int cnt, int[] foodList, int[] scoreIdxSave, boolean isA) {
		if (cnt == 2) {
			if (isA) {
				totalScoreA += (array[scoreIdxSave[0]][scoreIdxSave[1]] + array[scoreIdxSave[1]][scoreIdxSave[0]]);
			} else {
				totalScoreB += (array[scoreIdxSave[0]][scoreIdxSave[1]] + array[scoreIdxSave[1]][scoreIdxSave[0]]);
			}
			return;
		}
		for (int i = index; i < foodList.length; i++) {
			scoreIdxSave[cnt] = foodList[i];
			function2(i + 1, cnt + 1, foodList, scoreIdxSave, isA);
		}
	}
}