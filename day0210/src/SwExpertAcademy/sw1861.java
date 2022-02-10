package SwExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1861 {
	static int TC, tc, N, arr[][], cnt, comresult[][], result[][];
	static int q, w;
	static int[] dy = { -1, 0, 1, 0 }; // 상, 우, 하, 좌
	static int[] dx = { 0, 1, 0, -1 }; // 시계 방향으로 탐색

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		for (tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			comresult = new int[N][N];
			result = new int[N][N];
			q = 0;
			w = 0;
			cnt = 1;
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int x = 0; x < N; x++) {
					arr[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					square(i, j);
					System.out.println(cnt);
					comresult[i][j] = cnt;
					cnt = 1;
				}
			}

			for (int k = 0; k < N; k++) {
				for (int l = 0; l < N; l++) {
					if (result[q][w] <= comresult[k][l]) {
						if(arr[q][w] < arr[k][l])
							continue;
						q = k;
						w = l;
					}
				}
			}
			System.out.println(q+"::"+w);
			System.out.println("#"+tc+" " + arr[q][w]);
		}
	}

	 static void square(int nowy, int nowx) {
		for (int d = 0; d < 4; d++) {
			int nexty = nowy + dy[d];
			int nextx = nowx = dx[d];
			if (nexty >= 0 && nexty < N && nextx >= 0 && nextx < N && arr[nexty][nextx] == arr[nowy][nowx] + 1) {
				cnt++;
				square(nexty, nextx);
			}
		}
	}
}