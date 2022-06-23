package sw;

import java.io.*;

//상호의 배틀필드 https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AX5MvY2anG4DFAX1&contestProbId=AV5LyE7KD2ADFAXc&probBoxId=AX7CcH16KvoDFAVm+&type=PROBLEM&problemBoxTitle=0204&problemBoxCnt=++3+

public class SW1873 {
	static StringBuilder sb;
	static int nn;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int tankR;
	static int tankC;
	static char tank;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		nn = Integer.parseInt(br.readLine());
		for (int cc = 1; cc <= nn; cc++) {
			String[] s1 = br.readLine().split(" ");
			int row = Integer.parseInt(s1[0]);
			int col = Integer.parseInt(s1[1]);
			char[][] map = new char[row][col];
			for (int i = 0; i < row; i++) {
				map[i] = br.readLine().toCharArray();
			}
			// 위치 확인
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == 'v' || map[i][j] == '^') {
						tankR = i;
						tankC = j;
						tank = map[i][j];
					}
				}
			}
			int num = Integer.parseInt(br.readLine());
			for (char input : br.readLine().toCharArray()) {
				if (input == 'U') {
					if (tankR - 1 >= 0 && map[tankR - 1][tankC] == '.') {
						map[tankR - 1][tankC] = '^';
						map[tankR][tankC] = '.';

						tankR = tankR - 1;
						tank = '^';
					} else {
						tank = '^';

						map[tankR][tankC] = '^';
					}
				} else if (input == 'D') {
					if (tankR + 1 < row && map[tankR + 1][tankC] == '.') {
						map[tankR + 1][tankC] = 'v';
						map[tankR][tankC] = '.';

						tankR = tankR + 1;
						tank = 'v';
					} else {
						map[tankR][tankC] = 'v';

						tank = 'v';
					}
				} else if (input == 'L') {
					if (tankC - 1 >= 0 && map[tankR][tankC - 1] == '.') {
						map[tankR][tankC - 1] = '<';
						map[tankR][tankC] = '.';

						tankC = tankC - 1;
						tank = '<';

					} else {
						map[tankR][tankC] = '<';

						tank = '<';
					}
				} else if (input == 'R') {
					if (tankC + 1 < col && map[tankR][tankC + 1] == '.') {
						map[tankR][tankC + 1] = '>';
						map[tankR][tankC] = '.';

						tankC = tankC + 1;
						tank = '>';
					} else {
						map[tankR][tankC] = '>';

						tank = '>';
					}
				} else if (input == 'S') {
					int drdc = 0;
					if (tank == '^') {
						drdc = 0;
					} else if (tank == 'v') {
						drdc = 1;
					} else if (tank == '<') {
						drdc = 2;
					} else if (tank == '>') {
						drdc = 3;
					}
					int tempR = tankR;
					int tempC = tankC;
					while (tempR + dr[drdc] >= 0 && tempR + dr[drdc] < row && tempC + dc[drdc] >= 0
							&& tempC + dc[drdc] < col) {
						try {
							char tempMap = map[tempR + dr[drdc]][tempC + dc[drdc]];
							if (tempMap == '*') {
								map[tempR + dr[drdc]][tempC + dc[drdc]] = '.';
								break;
							} else if (tempMap == '#') {
								break;
							}
						} finally {
							tempR = tempR + dr[drdc];
							tempC = tempC + dc[drdc];
						}
					}
				}
			}
			sb.append("#").append(cc).append(" ");
			for (char[] m : map) {
				for (char mm : m) {
					sb.append(mm);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
