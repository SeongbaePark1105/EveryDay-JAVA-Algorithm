package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bk1260 {
	static int N, M, V, arr[][];
	static boolean chkDFS[], chkBFS[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][N + 1];
		chkDFS = new boolean[N + 1];
		chkBFS = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int g1 = Integer.parseInt(st.nextToken());
			int g2 = Integer.parseInt(st.nextToken());

			arr[g1][g2] = V;
			arr[g2][g1] = V;
		}

		dfs(V);
		System.out.println();
		bfs(V);
	}
	static void dfs(int v) {
		System.out.print(v + " "); // 방문 노드 출력
		chkDFS[v] = true; // 노드를 방문했으니 true

		for (int j = 1; j < N + 1; j++) { // 자식 노드들을 뒷 배열에 저장시켜주었으니 하나하나 찾아서 비교
			if (arr[v][j] == V && chkDFS[j] == false) // main 에서 간선으로 연결시켰던 값 확인 하고 그 자식노드를 방문했는지 안했는지 체크
				dfs(j); // 방문을 안했으면 방문해주러 재귀함수 이용
		}
	}
	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		chkBFS[v] = true;
		while (!queue.isEmpty()) {
			int q = queue.remove();
			System.out.print(q + " ");
			for(int j = 1; j < N + 1; j++) {
				if(!chkBFS[j] && arr[q][j]==V) {
					queue.add(j);
					chkBFS[j] = true;
				}
			}
		}
	}
}