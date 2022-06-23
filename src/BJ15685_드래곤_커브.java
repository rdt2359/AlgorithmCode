import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ15685_드래곤_커브 {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		boolean[][] array = new boolean[101][101];

		int N = Integer.parseInt(br.readLine());
		for (int nn = 0; nn < N; nn++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int gen = Integer.parseInt(st.nextToken());

			ArrayList<Point> points = new ArrayList<>();
			points.add(new Point(x, y));
			points.add(new Point(x + dx[dir], y + dy[dir]));

			for (int g = 0; g < gen; g++) {
				for (int i = points.size() - 1; i > 0; i--) {
					Point p1 = points.get(i);
					Point p2 = points.get(i - 1);
					Point vector = change(new Point(p2.x - p1.x, p2.y - p1.y));
					Point last = points.get(points.size() - 1);
					points.add(new Point(last.x + vector.x, last.y + vector.y));
				}
			}
			for (Point p : points) {
				array[p.x][p.y] = true;
			}
		}
		int cnt = 0;
		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				if (array[x][y] && array[x + 1][y] && array[x][y + 1] && array[x + 1][y + 1]) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

	public static Point change(Point point) {
		if (point.x == dx[0] && point.y == dy[0]) {
			return new Point(dx[3], dy[3]);
		} else if (point.x == dx[1] && point.y == dy[1]) {
			return new Point(dx[0], dy[0]);
		} else if (point.x == dx[2] && point.y == dy[2]) {
			return new Point(dx[1], dy[1]);
		} else if (point.x == dx[3] && point.y == dy[3]) {
			return new Point(dx[2], dy[2]);
		}
		return point;
	}

	public static class Point {
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		int x;
		int y;

		@Override
		public String toString() {
			return "[" + x + "," + y + "]";
		}
	}
}