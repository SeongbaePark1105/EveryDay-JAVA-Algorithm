package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bk7562_나이트의이동 {
	static int di[][] = { { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 } };
	static int arr[][];
	static int l;
	static boolean visit[][];
	static int startY, startX, endY, endX;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			l = Integer.parseInt(br.readLine());
			arr = new int[l][l];
			visit = new boolean[l][l];
			StringTokenizer st = new StringTokenizer(br.readLine());
			startY = Integer.parseInt(st.nextToken());
			startX = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			endY = Integer.parseInt(st.nextToken());
			endX = Integer.parseInt(st.nextToken());
			bfs();
			System.out.println(arr[endY][endX]);
		}
	}

	static void bfs() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(startY, startX));
		visit[startY][startX] = true;
		while (!q.isEmpty()) {
			Node temp = q.remove();
			int y = temp.y;
			int x = temp.x;
			if (y == endY && x == endX) {
				break;
			}
			for (int i = 0; i < 8; i++) {
				int moveY = y + di[i][0];
				int moveX = x + di[i][1];
				if (moveY >= 0 && moveX >= 0 && moveY < l && moveX < l && !visit[moveY][moveX]) {
					q.add(new Node(moveY, moveX));
					visit[moveY][moveX] = true;
					arr[moveY][moveX] = arr[y][x] + 1;
				}
			}
		}
	}

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
