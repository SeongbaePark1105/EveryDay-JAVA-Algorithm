package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk1780 {
	static int N;
	static int arr[][];
	static int cntZero, cntOne, cntMinusOne;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		cntZero = 0;
		cntOne = 0;
		cntMinusOne = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dnca(0, 0, N);

		System.out.println(cntMinusOne);
		System.out.println(cntZero);
		System.out.println(cntOne);
	}

	static void dnca(int y, int x, int size) { // 분할에서 계산하기 위한 함수
		if (colorcheck(y, x, size)) {
			if (arr[y][x] == -1)
				cntMinusOne++;
			else if (arr[y][x] == 0)
				cntZero++;
			else if (arr[y][x] == 1)
				cntOne++;
			return;
		}

		int cutsize = size / 3;
		dnca(y, x, cutsize);
		dnca(y, x + cutsize, cutsize);
		dnca(y, x + cutsize * 2, cutsize);

		dnca(y + cutsize, x, cutsize);
		dnca(y + cutsize, x + cutsize, cutsize);
		dnca(y + cutsize, x + cutsize * 2, cutsize);

		dnca(y + cutsize * 2, x, cutsize);
		dnca(y + cutsize * 2, x + cutsize, cutsize);
		dnca(y + cutsize * 2, x + cutsize * 2, cutsize);
	}

	static boolean colorcheck(int y, int x, int size) {
		int check = arr[y][x];
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (check != arr[i][j])
					return false;
			}
		}
		return true;

	}
}
