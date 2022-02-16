package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk16926 {
	static int N, M, R, arr[][], temp, dx, dy; // N, M 배열의 크기 N*M , R은 회전의 수, A는 배열의 원소, temp는 교체 값

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		boolean chk = true;
		int min = Math.min(N, M);
		while (chk) {
			if (N < 2 || N > 300 || M < 2 || M > 300 || R <= 0 || R > 1000 || (min % 2) != 0) {
				System.out.println("다시 입력하세요.");
				st = new StringTokenizer(br.readLine(), " ");
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				R = Integer.parseInt(st.nextToken());
				arr = new int[N][M];
			} else
				chk = false;
		}
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 0; x < M; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < R; r++) {
			int start = 0;
			while (N / 2 > start && M / 2 > start) { // 횟수 작동
				// 외각 부분
				// 크기가 커질수록 내부가 안늘어남 헬스갔다와서 해결하셈

				// ↓
				for (dy = start + 1; dy < N - start; dy++) {
					temp = arr[dy][start];
					arr[dy][start] = arr[start][start];
					arr[start][start] = temp;

				}

				// →
				for (dx = start + 1; dx < M - start; dx++) {
					temp = arr[N - start - 1][dx];
					arr[N - start - 1][dx] = arr[start][start];
					arr[start][start] = temp;

				}
				// ↑
				for (dy = N - start - 2; dy >= start; dy--) {
					temp = arr[dy][M - start - 1];
					arr[dy][M - start - 1] = arr[start][start];
					arr[start][start] = temp;

				}

				// ←
				for (dx = M - start - 2; dx >= start; dx--) {

					temp = arr[start][dx];
					arr[start][dx] = arr[start][start];
					arr[start][start] = temp;
				}
				start++;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
