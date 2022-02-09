package SwExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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