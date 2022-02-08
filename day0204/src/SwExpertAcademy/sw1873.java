package SwExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1873 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int x = 0;
			int y = 0;
			char map[][] = new char[H][W];
			for (int i = 0; i < H; i++) { // 격자판 설정
				String line = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = line.charAt(j);
				}
			}
			int N = Integer.parseInt(br.readLine()); // 횟수 입력
			String user = br.readLine(); // 방향키 입력
			for (int k = 0; k < N; k++) {
				char key = user.charAt(k);
				for (int h = 0; h < H; h++) {
					for (int w = 0; w < W; w++) {
						if (map[h][w] == '^') {
							y = h;
							x = w;
						} else if (map[h][w] == '<') {
							y = h;
							x = w;
						} else if (map[h][w] == '>') {
							y = h;
							x = w;
						} else if (map[h][w] == 'v') {
							y = h;
							x = w;
						}
					}
				}
				switch (key) {
				case 'U':
					map[y][x] = '^';
					if (y - 1 >= 0 && map[y - 1][x] == '.') {
						map[y][x] = '.';
						map[y - 1][x] = '^';
					}
					break;
				case 'D':
					map[y][x] = 'v';
					if (y + 1 < H && map[y + 1][x] == '.') {
						map[y][x] = '.';
						map[y + 1][x] = 'v';
					}
					break;
				case 'L':
					map[y][x] = '<';
					if (x - 1 >= 0 && map[y][x - 1] == '.') {
						map[y][x] = '.';
						map[y][x - 1] = '<';
					}
					break;
				case 'R':
					map[y][x] = '>';
					if (x + 1 < W && map[y][x + 1] == '.') {
						map[y][x] = '.';
						map[y][x + 1] = '>';
					}
					break;
				case 'S':
					if (map[y][x] == '^') {
						for (int up = y - 1; up >= 0; up--) {
							if (map[up][x] == '#') {
								break;
							} else if (map[up][x] == '*') {
								map[up][x] = '.';
								break;
							}
						}
					} else if (map[y][x] == 'v') {
						for (int dw = y + 1; dw < H; dw++) {
							if (map[dw][x] == '#') {
								break;
							} else if (map[dw][x] == '*') {
								map[dw][x] = '.';
								break;
							}
						}
					} else if (map[y][x] == '>') {
						for (int rg = x + 1; rg < W; rg++) {
							if (map[y][rg] == '#') {
								break;
							} else if (map[y][rg] == '*') {
								map[y][rg] = '.';
								break;
							}
						}
					} else if (map[y][x] == '<') {
						for (int lf = x - 1; lf >= 0; lf--) {
							if (map[y][lf] == '#') {
								break;
							} else if (map[y][lf] == '*') {
								map[y][lf] = '.';
								break;
							}
						}
					}
				default:
					break;
				}
			}
			System.out.print("#" + tc + " ");
			for (int q = 0; q < H; q++) {
				for (int a = 0; a < W; a++) {
					System.out.print(map[q][a]);
				}
				System.out.println();
			}
		}
	}
}
