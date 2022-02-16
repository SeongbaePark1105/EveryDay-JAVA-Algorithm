package SwExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw2805 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			boolean chk = true;
			int sum = 0;
			int N = Integer.parseInt(br.readLine());
			while (chk) {
				if (N % 2 != 0) {
					chk = false;
				} else
					N = Integer.parseInt(br.readLine());
			}
			int farm[][] = new int[N][N];
			for (int i = 0; i < N; i++) { // 농작물 만들기
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					farm[i][j] = line.charAt(j) - '0';
				}
			}
			for(int d = 0; d<N/2; d++) {
				for (int q = N/2-d; q<=N/2+d; q++) {
					sum+=farm[d][q];
				}
			}
			for(int d = N/2; d>=0; d--) {
				for(int q = N/2-d; q<=N/2+d; q++) {
					sum+=farm[N-d-1][q];
				}			
			}
			System.out.printf("#"+tc+ " ");
			System.out.println(sum);
		}
	}
}
