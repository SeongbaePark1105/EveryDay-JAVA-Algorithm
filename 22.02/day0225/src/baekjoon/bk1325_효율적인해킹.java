package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bk1325_효율적인해킹 {
	static ArrayList<Integer> list[];
	static int resultarr[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list[] = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[A].add(B);
		}
		resultarr = new int[N + 1];
		int result = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			boolean[] visit = new boolean[N + 1];
			visit[i] = true;
//			dfs(i, visit, list);
			bfs(i, visit, list);
		}
		for(int i = 1; i<=N; i++) {
			result = Math.max(result, resultarr[i]);
		}
		for(int i = 1; i <=N; i++) {
			if (resultarr[i] == result)
				System.out.print(i +" ");
		}
	}
	
	static void bfs(int start, boolean[] visit, ArrayList<Integer>[] list) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(start);
		visit[start] = true;
		while(!queue.isEmpty()) {
			int node = queue.remove();
			for(int next : list[node]) {
				if (!visit[next]) {
					visit[next] = true;
					resultarr[next]++;
					queue.add(next);
				}
			}
		}
	}
	
//	static void dfs(int start, boolean[] visit, ArrayList<Integer>[] list) {
//		for (int next : list[start]) {
//			if (!visit[next]) {
//				visit[next] = true;
//				resultarr[next]++;
//				dfs(next, visit, list);
//			}
//		}
//	}
}
