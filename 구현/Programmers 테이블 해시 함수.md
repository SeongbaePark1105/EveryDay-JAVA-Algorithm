# Programmers [테이블 해시 함수](https://school.programmers.co.kr/learn/courses/30/lessons/147354)

### 난이도 ★★

---

#### 접근 방식

> 단순한 구현의 문제입니다.
>
> 하지만, 람다식을 이용할 때 문제가 있었습니다.
>
> 기존의 람다식에선 `o1[값]`에서 값을 `col`로 이용했으나 `final or effectively final` 에러가 발생하였습니다.
>
> 에러가 발생한 이유를 짧게 요약하자면 처음에 변수로 넘어온 `col`의 값이 변경되었기 때문입니다. 즉, `col -=1 `을 하였기 때문에 이러한 에러가 발생했습니다.
>
> 람다식에서는 `final` 즉, 변수의 값이 변하지 않은 변수를 사용해야 되는 것 같았습니다.
>
> 따라서 새로운 변수에 `col`의 값을 담아 해결 할 수 있었습니다.
>
> 나머지는 조건에 맞춰 구현하였습니다.

#### 풀이

```java
import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        col -= 1;
        row_begin -= 1;
        int finalCol = col;
        Arrays.sort(data, (o1, o2) -> {
            if (o1[finalCol] == o2[finalCol]) return o2[0] - o1[0];
            return o1[finalCol] - o2[finalCol];
        });

        for (int i = row_begin; i < row_end; i++){
            int sum = 0;
            for (int num : data[i]) sum += num % (i + 1);
            answer ^= sum;
        }
        return answer;
    }
}
```

