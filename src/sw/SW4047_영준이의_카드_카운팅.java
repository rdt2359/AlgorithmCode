package sw;
import java.io.*;
import java.util.HashSet;
import java.util.LinkedHashMap;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIsY84KEPMDFAWN&categoryId=AWIsY84KEPMDFAWN&categoryType=CODE&problemTitle=4047&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&
public class SW4047_영준이의_카드_카운팅 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		loop: for (int cc = 1; cc <= T; cc++) {
			LinkedHashMap<String, HashSet<Integer>> map = new LinkedHashMap<>();
			map.put("S", new HashSet<Integer>());
			map.put("D", new HashSet<Integer>());
			map.put("H", new HashSet<Integer>());
			map.put("C", new HashSet<Integer>());
			String ss = br.readLine();
			for (int i = 0; i < ss.length(); i += 3) {
				String s1 = ss.substring(i, i + 1);
				String s2 = ss.substring(i + 1, i + 3);
				if (!map.get(s1).add(Integer.parseInt(s2))) {
					sb.append("#").append(cc).append(" ").append("ERROR").append("\n");
					continue loop;
				}
			}
			sb.append("#").append(cc).append(" ");
			for (HashSet<Integer> hs : map.values()) {
				sb.append(13 - hs.size()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}