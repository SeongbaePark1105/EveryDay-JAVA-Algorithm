package SwExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Stack;
import java.util.StringTokenizer;

public class sw1218 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> sc = new Stack<>(); // 스택 선언
		for (int tc = 1; tc <= 10; tc++) {
			sc.clear();
			N = Integer.parseInt(br.readLine()); // 괄호 갯수
			String str = br.readLine();
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '<') {
					sc.push(str.charAt(i));
				} else if (str.charAt(i) == ')' && sc.peek() == '(') {
					sc.pop();
				} else if (str.charAt(i) == ']' && sc.peek() == '[') {
					sc.pop();
				} else if (str.charAt(i) == '}' && sc.peek() == '{') {
					sc.pop();
				} else if (str.charAt(i) == '>' && sc.peek() == '<') {
					sc.pop();
				} else
					break;
			}
			if (sc.isEmpty()) {
				System.out.println("#" + tc + " " + 1);
			} else
				System.out.println("#" + tc + " " + 0);
		}
	}
}
