# Programmers [n^2 배열 자르기](https://school.programmers.co.kr/learn/courses/30/lessons/87390)

### 난이도 ★★

---

#### 접근 방식

> 처음에는 조건을 따라 배열을 만들었다가 `메모리 초과`가 발생하였습니다.
>
> 따라서, 배열을 만들기보단 `행`과 `열`의 값을 구하는 것에 초점을 두었습니다.
>
> `행`과 `열`의 값을 구하고 큰 값을 정답 배열에 담았습니다.

#### 풀이

```java
import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int [] answer = new int[(int) (right - left) + 1];
        for (int i = 0; i < answer.length; i++){
            int row = (int)((i + left) / n) + 1;
            int col = (int)((i + left) % n) + 1;
            answer[i] = Math.max(row, col);
        }
        return answer;
    }
}
```

