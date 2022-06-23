package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/17135
public class BJ17135_캐슬_디펜스 {
	static int maxValue = Integer.MIN_VALUE;
	static int N;
	static int M;
	static int D;
	static int[][] input;
	static int[][] copyArray;
	static int[] archers;
	static int maxKill = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		archers = new int[3];
		input = new int[N][M];
		copyArray = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				input[i][j] = value;
			}
		}
		
		getArchers(0, 0);
		
		System.out.println(maxKill);
	}

	// 조합
	public static void getArchers(int cnt, int index) {
		if (cnt == 3) {
			copy(input, copyArray); // 배열 복제
			int killNum = action(archers, copyArray);
			if (maxKill < killNum) {
				maxKill = killNum;
			}
			return;
		}

		for (int i = index; i < M; i++) {
			archers[cnt] = i;
			getArchers(cnt + 1, i + 1);
		}
	}

	public static int action(int[] archers, int[][] copyArray) {
		int killNum = 0;

		for (int t = 0; t < N; t++) {
			// ----- 적 찾기
			int[][] enemies = new int[3][2]; // 3명, r,c 좌표
			for (int i = 0; i < 3; i++) {
				// 궁수한명이 죽일 적 찾기
				enemies[i] = findNearEnemy(archers[i], t, copyArray);
			}

			// ----- 적 죽이기
			for (int i = 0; i < 3; i++) {
				if (enemies[i] != null && copyArray[enemies[i][0]][enemies[i][1]] != 0) { // 이미 죽인 적 체크
					killNum++;
					copyArray[enemies[i][0]][enemies[i][1]] = 0;
				}
			}

			// ----- 이동
			for (int r = N - 1; r >= t; r--) {
				for (int c = 0; c < M; c++) {
					if (copyArray[r][c] == 1) {
						if (r < N - 1) { // 맨 아래 칸이 아니면 아래칸으로 이동
							copyArray[r + 1][c] = 1;
						}
						copyArray[r][c] = 0; // 원래칸은 0으로 변경
					}
				}
			}
		}
		return killNum;
	}

	public static int[] findNearEnemy(int archer, int index, int[][] copyArray) {
		int enemyR = -1;
		int enemyC = -1;
		int minDis = Integer.MAX_VALUE;
		for (int r = 0 + index; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (copyArray[r][c] == 1) {
					int dis = Math.abs(c - archer) + (N - r);
					if (dis <= D) {
						if (minDis > dis || (minDis == dis && c < enemyC)) { // 거리 적을 떄 , 거리 같고 왼쪽에 있을때
							enemyR = r;
							enemyC = c;
							minDis = dis;
						}
					}
				}
			}
		}
		if (minDis != Integer.MAX_VALUE) {
			return new int[] { enemyR, enemyC };
		} else {
			return null;
		}
	}

	static void copy(int[][] input, int[][] copyArray) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				copyArray[r][c] = input[r][c];
			}
		}
	}

}
