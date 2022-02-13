package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bk17406 {
	static int N, M, K, A[][], calnum[][], result, arrmin[], idx, primaryA[][];
	static int rcsinput[][];
	static int min = Integer.MAX_VALUE;
	static boolean visit[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 열 입력
		M = Integer.parseInt(st.nextToken()); // 행 입력
		K = Integer.parseInt(st.nextToken()); // 회전 수 입력
		A = new int[N][M];
		primaryA = new int[N][M];
		rcsinput = new int[K][3];
		visit = new boolean[K];
		calnum = new int[K][3];
		arrmin = new int[K];
		idx = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				primaryA[i][j] = A[i][j];
			}
		}

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			rcsinput[k][0] = r;
			rcsinput[k][1] = c;
			rcsinput[k][2] = s;

		}
		permutation(0);
		
		System.out.println(min);

	}

	static void permutation(int cnt) {

		if (cnt == K) {
			for (int k = 0; k < K; k++) {
				rcs(calnum[k][0], calnum[k][1], calnum[k][2]);
			}

			rcsmin(calnum);
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					A[i][j] = primaryA[i][j];
				}
			}
			return;
		}

		for (int i = 0; i < K; i++) {
			if (visit[i])
				continue;
			for (int j = 0; j < 3; j++) {
				calnum[cnt][j] = rcsinput[i][j];
			}
			visit[i] = true;
			permutation(cnt + 1);
			visit[i] = false;

		}
	}

	
	static int rcsmin(int [][]calnum) {
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += A[i][j];
			}
			min = Math.min(min, sum);
		}
		return min;
	}
	
	static void rcs(int r, int c, int s) {
		int chk = 0;
		int upleftY = r - s - 1;
		int upleftX = c - s - 1;
		int downrightY = r + s - 1;
		int downrightX = c + s - 1;
		int temp = 0;
		while ((downrightY - upleftY) / 2 > chk && (downrightX - upleftX) / 2 > chk) {
			// →
			for (int dx = 1 + upleftX + chk; dx <= downrightX - chk; dx++) {
				temp = A[upleftY + chk][dx];
				A[upleftY + chk][dx] = A[upleftY + chk][upleftX + chk];
				A[upleftY + chk][upleftX + chk] = temp;
			}
			// ↓
			for (int dy = 1 + upleftY + chk; dy <= downrightY - chk; dy++) {
				temp = A[dy][downrightX - chk];
				A[dy][downrightX - chk] = A[upleftY + chk][upleftX + chk];
				A[upleftY + chk][upleftX + chk] = temp;
			}
			// ←
			for (int dx = downrightX - 1 - chk; dx >= upleftX + chk; dx--) {
				temp = A[downrightY - chk][dx];
				A[downrightY - chk][dx] = A[upleftY + chk][upleftX + chk];
				A[upleftY + chk][upleftX + chk] = temp;
			}
			// ↑
			for (int dy = downrightY - 1 - chk; dy >= upleftY + chk; dy--) {
				temp = A[dy][upleftX + chk];
				A[dy][upleftX + chk] = A[upleftY + chk][upleftX + chk];
				A[upleftY + chk][upleftX + chk] = temp;
			}
			chk++;
		}
	}
}
