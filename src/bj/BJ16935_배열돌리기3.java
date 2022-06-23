package bj;

import java.io.*;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/16935
public class BJ16935_배열돌리기3 {
	static StringBuilder sb;
	static StringTokenizer st;
	static int R;
	static int C;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String[] input1 = br.readLine().split(" ");
		R = Integer.parseInt(input1[0]);
		C = Integer.parseInt(input1[1]);
		// int cnt = Integer.parseInt(input1[2]);

		int[][] array = new int[R][C];
		for (int i = 0; i < R; i++) {
			String[] input2 = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				array[i][j] = Integer.parseInt(input2[j]);
			}
		}
		for (String s : br.readLine().split(" ")) {
			array = function(array, s);
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				sb.append(array[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static int[][] function(int[][] array, String function) {
		int[][] originalCopy = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				originalCopy[i][j] = array[i][j];
			}
		}

		if (function.equals("1")) {
			for (int i = 0; i < R / 2; i++) {
				for (int j = 0; j < C; j++) {
					array[i][j] = originalCopy[R - i - 1][j];
					array[R - i - 1][j] = originalCopy[i][j];
				}
			}
		} else if (function.equals("2")) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C / 2; j++) {
					array[i][j] = originalCopy[i][C - j - 1];
					array[i][C - j - 1] = originalCopy[i][j];
				}
			}
		} else if (function.equals("3")) {
			array = new int[C][R];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					array[j][R - i - 1] = originalCopy[i][j];
				}
			}
			int temp = R;
			R = C;
			C = temp;
		} else if (function.equals("4")) {
			array = new int[C][R];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					array[C - j - 1][i] = originalCopy[i][j];
				}
			}
			int temp = R;
			R = C;
			C = temp;
		} else if (function.equals("5")) {
			int halfR = R / 2;
			int halfC = C / 2;
			for (int i = 0; i < halfR; i++) {
				for (int j = 0; j < halfC; j++) {
					array[i][j + halfC] = originalCopy[i][j];
				}
			}
			for (int i = 0; i < halfR; i++) {
				for (int j = halfC; j < C; j++) {
					array[i + halfR][j] = originalCopy[i][j];
				}
			}
			for (int i = halfR; i < R; i++) {
				for (int j = halfC; j < C; j++) {
					array[i][j - halfC] = originalCopy[i][j];
				}
			}
			for (int i = halfR; i < R; i++) {
				for (int j = 0; j < halfC; j++) {
					array[i - halfR][j] = originalCopy[i][j];
				}
			}

		} else if (function.equals("6")) {
			int halfR = R / 2;
			int halfC = C / 2;
			for (int i = 0; i < halfR; i++) {
				for (int j = 0; j < halfC; j++) {
					array[i + halfR][j] = originalCopy[i][j];
				}
			}
			for (int i = 0; i < halfR; i++) {
				for (int j = halfC; j < C; j++) {
					array[i][j - halfC] = originalCopy[i][j];
				}
			}
			for (int i = halfR; i < R; i++) {
				for (int j = halfC; j < C; j++) {
					array[i - halfR][j] = originalCopy[i][j];
				}
			}
			for (int i = halfR; i < R; i++) {
				for (int j = 0; j < halfC; j++) {
					array[i][j + halfC] = originalCopy[i][j];
				}
			}
		}
		return array;
	}
}
