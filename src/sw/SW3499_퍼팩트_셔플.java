package sw;
import java.io.*;
import java.util.ArrayList;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIsY84KEPMDFAWN&categoryId=AWIsY84KEPMDFAWN&categoryType=CODE&problemTitle=4047&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&
public class SW3499_퍼팩트_셔플 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int cc = 1; cc <= T; cc++) {
			int N = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			boolean isOdd = input.length % 2 == 1 ? true : false;
			int middle = isOdd ? input.length / 2 + 1 : input.length / 2;
			ArrayList<String> output = new ArrayList<>();
			int cnt = 0;
			int index = 0;
			while (cnt < N) {
				output.add(input[index]);
				cnt++;
				if (cnt < N) {
					output.add(input[index + middle]);
					cnt++;
				}
				index++;
			}
			sb.append("#").append(cc).append(" ");
			for (String s : output) {
				sb.append(s).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}