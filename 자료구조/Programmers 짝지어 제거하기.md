# Programmers [짝지어 제거하기](https://school.programmers.co.kr/learn/courses/30/lessons/12973)

### 난이도 ★★

---

#### 접근 방식

> `Stack` 자료구조를 이용하여 `FILO` 구조를 이용하여 해결할 수 있었습니다.

#### 풀이

```java
import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            if (stack.size() == 0) stack.add(s.charAt(i));
            else {
                if (stack.get(stack.size() -1) == s.charAt(i)){
                    stack.pop();
                } else stack.add(s.charAt(i));
            }
        }
        if (stack.size() != 0) return 0;
        else return 1;
    }
}
```

