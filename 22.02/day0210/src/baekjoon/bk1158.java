package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bk1158 {
	static int N, K, num;
	public static void main(String[] args) throws IOException {
		LinkedList<Integer> queue = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for(int i = 1; i<=N; i++) {
			queue.add(i);
		}
		System.out.print("<");
		while(!queue.isEmpty()) {
			for (int j = 0; j<K; j++) {
				if (j == K-1) {
					num = queue.remove();
					if (queue.isEmpty())
						System.out.print(num);
					else
						System.out.print(num+", ");
				}
				else
					queue.add(queue.remove());		
			}
		}
		System.out.println(">");
	}
}
