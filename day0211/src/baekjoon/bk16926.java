package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk16926 {
	static int N, M, R, A, arr[][], temp, dx, dy, Indx, Indy; // N, M 배열의 크기 N*M , R은 회전의 수, A는 배열의 원소, temp는 교체 값

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 0; x < M; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i <= R; i++) { // 횟수 작동
			// 외각 부분
			dx = 0;
			dy = 0;
			Indx = 1;
			Indy = 1;

			// ↓
			for (; dy < N; dy++) {
				if (dy + 1 == N)
					break;
				else {
					temp = arr[dy + 1][dx];
					arr[dy + 1][dx] = arr[0][0];
					arr[0][0] = temp;
				}
			}

			// →
			for (; dx < M; dx++) {
				if (dx + 1 == M)
					break;
				else {
					temp = arr[dy][dx + 1];
					arr[dy][dx + 1] = arr[0][0];
					arr[0][0] = temp;
				}
			}
			// ↑
			for (; dy >= 0; dy--) {
				if (dy == 0)
					break;
				else {
					temp = arr[dy - 1][dx];
					arr[dy - 1][dx] = arr[0][0];
					arr[0][0] = temp;
				}
			}

			// ←
			for (; dx >= 0; dx--) {
				if (dx == 0)
					break;
				else {
					temp = arr[dy][dx - 1];
					arr[dy][dx - 1] = arr[0][0];
					arr[0][0] = temp;
				}
			}
			// 내부 부분

			// ↓
			if (!(Indy + 1 == N && Indx + 1 == M)) { // 내부를 돌릴 수 있는 지 없는 지 체크
				for (; Indy < N; Indy++) {
					if (Indy + 2 == N)
						break;
					else {
						temp = arr[Indy + 1][Indx];
						arr[Indy + 1][Indx] = arr[1][1];
						arr[1][1] = temp;
					}
				}

				// →
				for (; Indx < M; Indx++) {
					if (Indx + 2 == M)
						break;
					else {
						temp = arr[Indy][Indx + 1];
						arr[Indy][Indx + 1] = arr[1][1];
						arr[1][1] = temp;
					}
				}

				// ↑
				for (; Indy > 1; Indy--) {

					temp = arr[Indy - 1][Indx];
					arr[Indy - 1][Indx] = arr[1][1];
					arr[1][1] = temp;

				}

				// ←
				for (; Indx > 1; Indx--) {

					temp = arr[Indy][Indx - 1];
					arr[Indy][Indx - 1] = arr[1][1];
					arr[1][1] = temp;

				}
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
