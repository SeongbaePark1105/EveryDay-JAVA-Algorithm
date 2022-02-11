package baekjoon;
// 비밀 이메일

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk2999 {
	static int N, R, C;
	static String input;
	static char code[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		N = input.length();
		for(int i = 1; i<=N; i++) {
			if( (N%i) == 0 && i * N/i == N) { // % 연산자를 이용해 약수를 구하고 R*C = N 확인
											  // R도 가장 큰 값을 이용해야하니 1부터 비교해서 i 값이 커지면서 큰 값을 R에 자꾸 넣어줌
				if (i <= N/i) { // R<=C 이므로 큰지 작은지 같은지 체크 
					R = i;
					C = N/i;
				}
			}
		}
		code = new char[R][C];
		int idx = 0;
		for(int x = 0; x<C; x++) { // dfs 형식으로 저장
			for(int y = 0; y<R; y++) {
				code[y][x] = input.charAt(idx);
				idx++;
			}
		}
		for(int y = 0; y<R; y++) { // 출력은 bfs 형식으로 해야하니까 for문 다시 작성
			for(int x = 0; x<C; x++) {
				System.out.print(code[y][x]);
			}
		}
	}

}
