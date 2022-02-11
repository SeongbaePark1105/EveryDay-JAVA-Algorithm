package SwExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 사다리게임
// 내가 지나간 길을 boolean으로 방문처리해서 (어차피 다시 돌아갈 일 없으니) 하는게 중요하다
// 그리고 내가 방문한 자리를 임의로 다른 문자로 디버깅해서 내가 어디를 지나고 있는지 확인하는 습관을 가지면 좋다.
public class sw1210 {
	static int TC;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			TC = Integer.parseInt(br.readLine());
			int data[][] = new int[100][100];
			int y = 0;
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					data[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int k = 0; k < 100; k++) {
				if (data[99][k] == 2) {
					y = k;
					break;
				}
			}
			for (int x = 99; x >= 0; x--) {
				if (y - 1 >= 0 && data[x][y - 1] == 1) {
					while (true) {
						if (y - 1 >= 0 && data[x][y - 1] == 1)
							y--;
						else
							break;
					}
					continue;
				}

				if (y + 1 < 100 && data[x][y + 1] == 1) {
					while (true) {
						if (y + 1 < 100 && data[x][y + 1] == 1)
							y++;
						else
							break;
					}
					continue;
				}

			}
			System.out.println("#" + tc + " " + y);
		}

	}
}