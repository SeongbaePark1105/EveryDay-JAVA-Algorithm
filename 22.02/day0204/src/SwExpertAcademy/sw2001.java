package SwExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw2001 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int arr[][] = new int[N][N];

			int max = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				StringTokenizer nt = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(nt.nextToken());
				}
			}
			
			for (int a = 0; a < N - M + 1; a++) {
				for (int b = 0; b < N - M + 1; b++) {
					int sum = 0;
					for (int c = 0; c < M; c++) {
						for (int d = 0; d < M; d++) {
							sum += arr[a + c][b + d];
						}
					}
					if (max < sum) {
						max = sum;
					}
				}
			}
			System.out.printf("#" + tc + " ");
			System.out.println(max);
		}
	}
}
