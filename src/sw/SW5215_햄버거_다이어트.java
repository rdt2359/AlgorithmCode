package sw;

import java.io.*;

//햄버거 다이어트 https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AX5MvY2anG4DFAX1&contestProbId=AWT-lPB6dHUDFAVT&probBoxId=AX7SL27qNUMDFAVm+&type=PROBLEM&problemBoxTitle=0207&problemBoxCnt=++1+

public class SW5215_햄버거_다이어트 {
	static StringBuilder sb;
	static int maxCal;
	static int num;
	static int maxScore;
	static int[] inputScore;
	static int[] inputCal;
	static boolean[] isUsed;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int nn = Integer.parseInt(br.readLine());

		for (int cc = 1; cc <= nn; cc++) {
			String[] input1 = br.readLine().split(" ");
			num = Integer.parseInt(input1[0]);
			maxCal = Integer.parseInt(input1[1]);
			maxScore = 0;
			inputScore = new int[num];
			inputCal = new int[num];
			isUsed = new boolean[num];
			for (int i = 0; i < num; i++) {
				String[] input2 = br.readLine().split(" ");
				inputScore[i] = Integer.parseInt(input2[0]);
				inputCal[i] = Integer.parseInt(input2[1]);
			}
			function(0, 0, 0);
			sb.append("#").append(cc).append(" ").append(maxScore).append("\n");
		}
		System.out.println(sb);
	}

	public static void function(int index, int score, int cal) {
		if (cal > maxCal) {
			return;
		}
		if (score > maxScore) {
			maxScore = score;
		}
		for (int i = index; i < num; i++) {
			function(i + 1, score + inputScore[i], cal + inputCal[i]);
		}
	}
}
