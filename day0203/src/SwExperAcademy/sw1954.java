package SwExperAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw1954 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int dx[] = { 0, 1, 0, -1 };
		int dy[] = { 1, 0, -1, 0 };
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			if (N == 1) {
				System.out.println("#" + tc);
				System.out.println(1);
				continue;
			}
			int[][] arr = new int[N][N];
			int x = 0;
			int y = 0;
			int k = 0; 
			for (int i = 0; i < N * N; i++) {

				arr[x][y] = i + 1;
				x += dx[k];
				y += dy[k];
				if (x >= N || y >= N || x < 0 || y < 0) {
					x -= dx[k];
					y -= dy[k];

					k = (k + 1) % 4;

					x += dx[k];
					y += dy[k];
				}
				if (arr[x][y] != 0) {
					x -= dx[k];
					y -= dy[k];
					k = (k + 1) % 4;
					x += dx[k];
					y += dy[k];
				}
			}
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}