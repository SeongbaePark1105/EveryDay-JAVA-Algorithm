package baekjoon;
// ACM 호텔

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk10250 {
	static int TC, H, W, N, cnt, result;
	static String hotel[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			hotel = new String[H][W + 1];
			cnt = 0;
			for (int j = 1; j <= W; j++) {
				for (int i = H - 1; i >= 0; i--) { // 만약에 층을 이차원 배열을 출력해서 호텔을 보여준다고 생각했을 때
												   // 1층은 맨 아래부터 보여야 하니 맨 아래부터 값을 넣어서 진행했다.
					cnt += 1;
					if (cnt == N & j < 10) {  // 10보다 작은 숫자들은 0을 붙여주고 출력해야되니까 방의 수를 비교한다
						System.out.println(H-i +"0"+j); 
						//hotel[i][j] = Integer.toString(H - i) + "0" + Integer.toString(j);
						// 메모리랑 시간을 너무 많이 잡아먹어서 무엇이 문제인가 생각했는데
						// 굳이 값을 변환시켜서 넣어줘서 또 다른 if문에서 cnt를 비교해서 출력을 할 필요가 없다는 걸 알았다.
					} else if (cnt == N & j>=10)
						System.out.println(H-i +""+j);
						//hotel[i][j] = Integer.toString(H - i) + Integer.toString(j);
//					if (cnt == N) {
//						System.out.println(hotel[i][j]);
//						break;
//					}
				}
			}
		}
	}
}
