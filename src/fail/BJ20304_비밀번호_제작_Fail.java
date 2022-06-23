package fail;
import java.io.*;

//https://www.acmicpc.net/problem/20304
public class BJ20304_비밀번호_제작_Fail {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb2 = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] hackPw = new int[M];
		String[] ss = br.readLine().split(" ");
		for (int i = 0; i < ss.length; i++) { // 해킹 비밀번호 저장
			hackPw[i] = Integer.parseInt(ss[i]);
		}

		int security = Integer.MIN_VALUE; // 가장큰 보안성 저장
		for (int i = 0; i <= N; i++) { // 각 관리자 비밀번호 시도
			String binaryPw = Integer.toBinaryString(i); // 비밀번호를 이진수로 변환
			int securityMin = Integer.MAX_VALUE; // 각 관리자 비밀번호의 보안성 저장
			for (int j = 0; j < M; j++) { // 각 해킹 비밀번호 시도
				String binaryHackPw = Integer.toBinaryString(hackPw[j]); // 비밀번호를 이진수로 변환
				// --- 해킹 비밀번호랑 관리자 비밀번호의 자릿수를 통일
				if (binaryPw.length() > binaryHackPw.length()) { // 비밀번호 자릿수를 비교하여 적은 비밀번호앞에 0을 필요횟수만큼 추가해줌
					int diff = binaryPw.length() - binaryHackPw.length();
					for (int k = 0; k < diff; k++) {
						sb2.append("0");
					}
					sb2.append(binaryHackPw);
					binaryHackPw = sb2.toString();
					sb2.setLength(0);
				}
				if (binaryPw.length() < binaryHackPw.length()) {
					int diff = binaryHackPw.length() - binaryPw.length();
					for (int k = 0; k < diff; k++) {
						sb2.append("0");
					}
					sb2.append(binaryHackPw);
					binaryPw = sb2.toString();
					sb2.setLength(0);
				}
				// ---
				int differenceNum = 0; // 두 비밀번호의 차이 기록
				for (int k = 0; k < binaryHackPw.length(); k++) {
					if (binaryPw.charAt(k) != binaryHackPw.charAt(k)) {
						differenceNum++; // 각 비밀번호의 위치의 값이 다를 경우 차이 1증가
					}
				}
				if (differenceNum < securityMin) { // 현재 해킹 비밀번호와 관리자 비밀번호의 차이갯수가 최소일 경우 대체
					securityMin = differenceNum;
				}
			}
			if (securityMin > security) {// 관리자 비밀번호의 보안성이 현재 저장한 보안성보다 큰경우 대체
				security = securityMin;
			}
		}
		System.out.println(security);
	}

}
