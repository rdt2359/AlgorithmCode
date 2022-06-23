package fail;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
//https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AX5MvY2anG4DFAX1&contestProbId=AWXRDL1aeugDFAUo&probBoxId=AX7_1LnqH_EDFAW0+&type=PROBLEM&problemBoxTitle=0216&problemBoxCnt=++2+&&&&&&
public class SW_0216_2_무선충전_Fail {
	static int N;
	static int[][] array;
	static int scoreDiff;
	static int totalScoreA;
	static int totalScoreB;
	static int[] dr = { 0, -1, 0, 1, 0 };
	static int[] dc = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int C = Integer.parseInt(br.readLine());
		for (int cc = 1; cc <= C; cc++) {
			String[] ss1 = br.readLine().split(" ");
			int M = Integer.parseInt(ss1[0]);
			int A = Integer.parseInt(ss1[1]);

			String ss2[] = br.readLine().split(" ");
			String ss3[] = br.readLine().split(" ");
			int[] userAMoves = new int[M + 2];
			int[] userBMoves = new int[M + 2];
			userAMoves[0] = 0;
			userBMoves[0] = 0;
			for (int i = 1; i < M + 1; i++) {
				userAMoves[i] = Integer.parseInt(ss2[i - 1]);
				userBMoves[i] = Integer.parseInt(ss3[i - 1]);
			}

			BC[] bc = new BC[A];
			for (int i = 0; i < bc.length; i++) {
				String ss4[] = br.readLine().split(" ");
				bc[i] = new BC(Integer.parseInt(ss4[1]) - 1, Integer.parseInt(ss4[0]) - 1, Integer.parseInt(ss4[2]),
						Integer.parseInt(ss4[3]));
			}
			Arrays.sort(bc);

			int sum = 0;
			int[] userALocation = new int[] { 0, 0 };
			int[] userBLocation = new int[] { 9, 9 };

			for (int i = 0; i <= M; i++) {
				userALocation[0] += dr[userAMoves[i]];
				userALocation[1] += dc[userAMoves[i]];
				userBLocation[0] += dr[userBMoves[i]];
				userBLocation[1] += dc[userBMoves[i]];

				ArrayList<BC> userAList = new ArrayList<>();
				ArrayList<BC> userBList = new ArrayList<>();

				for (BC targetBc : bc) { // 겹치는 bc 체크
					if (targetBc.isObscure(userALocation[0], userALocation[1])) {
						userAList.add(targetBc);
					}
					if (targetBc.isObscure(userBLocation[0], userBLocation[1])) {
						userBList.add(targetBc);
					}
				}

				int var = 0;
				if (userAList.size() >= 1 && userBList.size() == 0) {
					var = userAList.get(0).performance;
				} else if (userAList.size() == 0 && userBList.size() >= 1) {
					var = userBList.get(0).performance;
				} else if (userAList.size() == 1 && userBList.size() == 1) {
					if (userAList.get(0).equals(userBList.get(0))) {
						var = userAList.get(0).performance;
					} else {
						var = userAList.get(0).performance;
						var += userBList.get(0).performance;
					}
				} else if (userAList.size() > 1 && userBList.size() == 1) {
					BC bBC = userBList.get(0);
					var = bBC.performance;
					if (userAList.get(0).equals(bBC)) {
						var += userAList.get(1).performance;
					} else {
						var += userAList.get(0).performance;
					}
				} else if (userBList.size() > 1 && userAList.size() == 1) {
					BC aBC = userAList.get(0);
					var = aBC.performance;
					if (userBList.get(0).equals(aBC)) {
						var += userBList.get(1).performance;
					} else {
						var += userBList.get(0).performance;
					}
				} else if (userAList.size() > 1 && userBList.size() > 1) {
					BC aBC = userAList.get(0);
					BC bBC = userBList.get(0);
					if (aBC.equals(bBC)) {
						BC aBC2 = userAList.get(1);
						BC bBC2 = userBList.get(1);
						var = aBC.performance;
						var += aBC2.performance > bBC2.performance ? aBC2.performance : bBC2.performance;
					} else {
						var = aBC.performance;
						var += bBC.performance;
					}
				}
				sum += var;
			}
			sb.append("#").append(cc).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}

	public static class BC implements Comparable<BC> {
		static int cnt = 1;
		int row;
		int col;
		int coverage;
		int performance;
		int check;
		boolean[][] coverageMap = new boolean[10][10];

		public BC(int row, int col, int coverage, int performance) {
			this.row = row;
			this.col = col;
			this.coverage = coverage;
			this.performance = performance;
			this.check = cnt++;

			for (int i = col - coverage; i <= col + coverage; i++) {
				if (i >= 0 && i < 10) {
					coverageMap[row][i] = true;
				}
			}
			for (int i = 1; i <= coverage; i++) {
				for (int j = coverage - i; j >= 0; j--) {
					if (row + i < 10 && col + j < 10) {
						coverageMap[row + i][col + j] = true;
					}
					if (row + i < 10 && col - j > 0) {
						coverageMap[row + i][col - j] = true;
					}
					if (row - i >= 0 && col + j < 10) {
						coverageMap[row - i][col + j] = true;
					}
					if (row - i >= 0 && col - j > 0) {
						coverageMap[row - i][col - j] = true;
					}
				}
			}
		}

		public boolean isObscure(int row, int col) {
			return coverageMap[row][col];
		}

		@Override
		public int compareTo(BC bc) {
			return bc.performance - this.performance;
		}

		@Override
		public boolean equals(Object obj) {
			BC bc = (BC) obj;
			return bc.check == this.check;
		}

	}
}
