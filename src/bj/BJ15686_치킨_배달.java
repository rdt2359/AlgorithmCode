package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ15686_치킨_배달 {

	static int N;
	static int M;

	static ArrayList<Point> chickin = new ArrayList<>();
	static ArrayList<Point> house = new ArrayList<>();

	static Point[] selectedChickin;
	static int[][] disSave;
	static int minDis = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selectedChickin = new Point[M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int val = Integer.parseInt(st.nextToken());
				if (val == 1) {
					house.add(new Point(r, c));
				} else if (val == 2) {
					chickin.add(new Point(r, c));
				}
			}
		}

		disSave = new int[house.size()][chickin.size()];
		for (int i = 0; i < house.size(); i++) {
			for (int j = 0; j < chickin.size(); j++) {
				disSave[i][j] = findMin(house.get(i), chickin.get(j));
			}
		}

		recusive(0, 0);
		System.out.println(minDis);
	}

	public static void recusive(int cnt, int start) {
		if (cnt == M) {
			check();
			return;
		}
		for (int i = start; i < chickin.size(); i++) {
			selectedChickin[cnt] = chickin.get(i);
			selectedChickin[cnt].index = i;
			recusive(cnt + 1, i + 1);
		}
	}

	private static void check() {
		int tempSumMin = 0;
		for (int i = 0; i < house.size(); i++) {
			int tempMin = Integer.MAX_VALUE;
			for (int j = 0; j < selectedChickin.length; j++) {
				if (tempMin > disSave[i][selectedChickin[j].index]) {
					tempMin = disSave[i][selectedChickin[j].index];
				}
			}
			tempSumMin += tempMin;
			if (tempSumMin >= minDis) {
				return;
			}
		}
		if (tempSumMin < minDis) {
			minDis = tempSumMin;
		}
	}

	private static int findMin(Point housePoint, Point chickinPoint) {
		return Math.abs(chickinPoint.r - housePoint.r) + Math.abs(chickinPoint.c - housePoint.c);
	}

	public static class Point {
		int r;
		int c;
		int index;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}