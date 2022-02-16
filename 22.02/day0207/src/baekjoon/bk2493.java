package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 스택 구조를 쓰면서 자기보다 앞에 있는 수를 비교하면서  자기보다 작아서 레이저를 받을 수 없는 수신 후보들을 삭제시킴
// 시간은 1.5 초
// 1억번의 연산이 1초정도 걸림
// 시간복잡도에 의해 n의 제곱 시간인데 n은 50만까지이므로 100억의 숫자이니 최소 100초라는 연산속도가 걸리므로 for문으로 할 수없음
public class bk2493 {

	static int N, Razer[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

		N = Integer.parseInt(br.readLine()); // 타워 갯수

		Stack<Tower> towers = new Stack<>(); // 레이저 수신 후보탑들 들어가는 스택
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			Tower now = new Tower(n, Integer.parseInt(st.nextToken())); // 탑 번호와 높이를 하나의 객체로 묶어서 생성
			// 지금 입장한 탑의 레이저를 누가 수신하는지 확인
			while (!towers.isEmpty() && towers.peek().height < now.height)
				towers.pop();
			// 이제 남은 가능성은 2가지
			if (towers.isEmpty()) { // 스택에 있는 애들이 다 난쟁이라 다 버려졌거나
				sb.append("0 ");
			} else { // 아니면 큰 타워가 남았음
				sb.append(towers.peek().num + " "); // 가져온 peek의 인덱스 번호
			}
			towers.push(now); // 내뒤에 들어올 레이저타워가 나보다 작으면 내가 레이저 수신 후보!
		}
		System.out.println(sb.toString()); // StringBuilder는 출력을 위해 toString을 써줘야함
	}
	static class Tower {
		int num, height;
		Tower(int n, int h) {
			num = n;
			height = h;
		}
	}

}
