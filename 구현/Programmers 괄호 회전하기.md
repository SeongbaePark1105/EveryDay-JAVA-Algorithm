# Programmers [괄호 회전하기](https://school.programmers.co.kr/learn/courses/30/lessons/76502)

### 난이도 ★★

---

#### 접근 방식

> 괄호 회전하기 같은 문제는 보통 `stack`으로 접근해서 해결하였습니다.
>
> 스택의 값이 있고 값을 꺼내었을 때 짝궁의 문자열이면 지우고 아니면 스택에 추가해주었습니다.
>
> 이러한 과정을 거치면서 스택의 값이 비었을 경우 `+1`을 카운트해줍니다.

#### 풀이

```java
import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int x = s.length();
        for (int i = 0; i < x; i++){
            String str = s;
            if (i != 0){
                str = s.substring(i, x) + s.substring(0, i);
            }
            Stack<Character> st = new Stack<>();
            for (int j = 0; j < x; j++){
                char c = str.charAt(j);
                if (st.isEmpty()) st.push(c);
                else if (c == ')' && st.peek() == '(') st.pop();
                else if (c == ']' && st.peek() == '[') st.pop();
                else if (c == '}' && st.peek() == '{') st.pop();
                else st.push(c);
            }
            if (st.isEmpty()) answer++;
        }
        return answer;
    }
}
```

