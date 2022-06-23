package sw;
import java.io.*;
import java.util.StringTokenizer;
//9229. 한빈이와 Spot Mart https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN

public class SW9229_한빈이와_Spot_Mart {
	static StringBuilder sb;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int C = 1; C <= TC; C++) {
			String[] ss = br.readLine().split(" ");
			int cnt = Integer.parseInt(ss[0]);
			int maxWeight = Integer.parseInt(ss[1]);
			int[] bags = new int[cnt];
			ss = br.readLine().split(" ");
			for (int i = 0; i < ss.length; i++) {
				bags[i] = Integer.parseInt(ss[i]);
			}
			int answer = Integer.MIN_VALUE;
			for (int i = 0; i < bags.length; i++) {
				for (int j = i + 1; j < bags.length; j++) { // i+1
					int sum = bags[i] + bags[j];
					if (sum <= maxWeight && answer < sum) {
						answer = sum;
					}
				}
			}
			sb.append("#").append(C).append(" ").append(answer == Integer.MIN_VALUE ? "-1" : answer).append("\n");
		}
		System.out.println(sb);
	}
}
