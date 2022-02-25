package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bk7576_토마토 {
	static int M, N; // M 가로 , N 세로
	static int arr[][];
	static int di[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int result = Integer.MIN_VALUE;
	static Queue<tomato> q;

	static class tomato {
		int y;
		int x;

		public tomato(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int [N][M];
		q = new LinkedList<tomato>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					q.add(new tomato(i, j));
				}
			}
		}
		bfs();
		System.out.println(Answer());
	}
	static void bfs() {
		while(!q.isEmpty()) {
			tomato t = q.remove();
			int y = t.y;
			int x = t.x;
			
			for(int i =0; i < 4; i++) {
				int newY = y + di[i][0];
				int newX = x + di[i][1];
				
				if(newY>=0 && newX>=0 && newY <N && newX <M) {
					if(arr[newY][newX] == 0) {
						q.add(new tomato(newY, newX));
						arr[newY][newX] = arr[y][x] +1; // 토마토 익은 숫자가 1이라 이렇게 연산하면 1일차가 2일차로 저장된다.
					}
				}
			}
		}
	}
	static int Answer() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				result = Math.max(result, arr[i][j]);
				if (arr[i][j] == 0)
					return -1;
			}
		}
		return result -1; // 59번 주석 문제를 해결하기 위해 -1를 해주면 1일차부터 계산이 된다.
		
	}
}
