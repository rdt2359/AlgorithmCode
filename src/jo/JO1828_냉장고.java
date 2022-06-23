package jo;
import java.io.*;
import java.util.Arrays;
//http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1101&sca=99&sfl=wr_hit&stx=1828
public class JO1828_냉장고 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Chemical[] chemicals = new Chemical[N];
		for (int i = 0; i < N; i++) {
			String[] ss = br.readLine().split(" ");
			chemicals[i] = new Chemical(Integer.parseInt(ss[0]), Integer.parseInt(ss[1]));
		}
		Arrays.sort(chemicals);
		int targetMax = chemicals[0].maxTemp;
		int cnt = 1;
		for (int i = 1; i < N; i++) {
			if (targetMax < chemicals[i].minTemp) {
				targetMax = chemicals[i].maxTemp;
				cnt++;
			} else if (targetMax > chemicals[i].maxTemp) {
				targetMax = chemicals[i].maxTemp;
			}
		}
		System.out.println(cnt);
	}

	public static class Chemical implements Comparable<Chemical> {
		public int minTemp;
		public int maxTemp;

		public Chemical(int minTemp, int maxTemp) {
			this.minTemp = minTemp;
			this.maxTemp = maxTemp;
		}

		@Override
		public int compareTo(Chemical c) {
			if (this.minTemp != c.minTemp) {
				return this.minTemp - c.minTemp;
			} else {
				return this.maxTemp - c.maxTemp;
			}
		}

		@Override
		public String toString() {
			return minTemp + " " + maxTemp;
		}
	}

}
