# Programmers [JadenCase 문자열 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/12951)

### 난이도 ★★

---

#### 접근 방식

>`substring`, `toUpperCase()`와 `toLowerCase()`를 사용하여 해결하였습니다.
>
>다만, 주의할 점이 `공백 문자`도 주어지기 때문에 조건으로 체크를 해주어야하고 마지막 문자열이 `공백 문자`일 경우도 생각해야 되기 때문에 이와 관련된 조건도 체크해야합니다.

#### 풀이

```java
import java.util.*;
class Solution {
    public int[] solution(String s) {
        int len = s.length();
        int[] answer = new int[len];
        Arrays.fill(answer, -1);
        for (int i = 1; i < len; i++){
            char s1 = s.charAt(i);
            for (int j = i-1; j >= 0; j--){
                char s2 = s.charAt(j);
                if (s1 == s2){
                    answer[i] = i - j;
                    break;
                }
            }
        }
        return answer;
    }
}
```
