# Programmers [최댓값과 최솟값](https://school.programmers.co.kr/learn/courses/30/lessons/12939)

### 난이도 ★★

---

#### 접근 방식

> 문자열로 입력을 받기 때문에 `split`으로 `string`배열을 만듭니다.
>
> 그 다음 `for-each`문을 사용하여 배열의 값들을 꺼내어 최솟값과 최댓값을 구합니다.

#### 풀이

```java
import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String str2 : str){
            int num = Integer.parseInt(str2);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        answer = min + " " + max;
        return answer;
    }
}
```

