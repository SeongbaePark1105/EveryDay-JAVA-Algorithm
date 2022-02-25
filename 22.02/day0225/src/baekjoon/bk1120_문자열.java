package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk1120_문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String input = st.nextToken();
		String input2 = st.nextToken();

		int inputlen = input.length();
		int inputlen2 = input2.length();
		int len = inputlen2 - inputlen;
		int result = Integer.MAX_VALUE;
		for (int i = 0; i <= len; i++) {
			int cnt = 0;
			for (int j = 0; j < inputlen; j++) {
				if (input.charAt(j) != input2.charAt(j + i)) {
					cnt++;
				}
			}
			if (result > cnt)
				result = cnt;
		}
		System.out.println(result);
	}
}