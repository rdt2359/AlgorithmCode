package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ1620_나는야_포켓몬_마스터_이다솜 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb =new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Integer, String> intToString = new HashMap<>();
		HashMap<String, Integer> stringToInt = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			intToString.put(i,s);
			stringToInt.put(s,i);
		}

		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if(Character.isDigit(s.charAt(0))){
				sb.append(intToString.get(Integer.valueOf(s))).append("\n");
			}else{
				sb.append(stringToInt.get(s)).append("\n");
			}
		}
		System.out.println(sb);
	}
}