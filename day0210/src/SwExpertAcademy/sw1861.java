package SwExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1861 {
	static int TC, tc, N, arr[][], cnt, resultCnt, resultRoom;
	static int[] dy = { -1, 0, 1, 0 }; // 상, 우, 하, 좌
	static int[] dx = { 0, 1, 0, -1 }; // 시계 방향으로 탐색

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		for (tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			resultCnt = 0;
			resultRoom = 0;
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int x = 0; x < N; x++) {
					arr[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cnt = square(i, j);

					if (resultCnt < cnt) {
						resultCnt = cnt;
						resultRoom = arr[i][j];
					} else if (resultCnt == cnt) {
						resultRoom = Math.min(resultRoom, arr[i][j]);
					}
				}
			}
			System.out.println("#" + tc + " " + resultRoom + " " + resultCnt);
		}
	}
	// 
	static int square(int nowy, int nowx) { // 선생님 강의를 보니 내가 처음에 짜려고 시도한 것은 DFS 방법
		for (int d = 0; d < 4; d++) {
			int nexty = nowy + dy[d];
			int nextx = nowx + dx[d];
			if (nexty >= 0 && nexty < N && nextx >= 0 && nextx < N && arr[nexty][nextx] == arr[nowy][nowx] + 1) {
				return square(nexty, nextx) + 1;
			}
		}
		return 1;
	}
}
