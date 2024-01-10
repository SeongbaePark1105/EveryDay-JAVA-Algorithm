# Programmers [최솟값 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/12941)

### 난이도 ★★

---

#### 접근 방식

> 한 배열의 `최솟값`과 `최댓값`을 곱하면 두 배열로 만들 수 있는 `최솟값`을 구할 수 있습니다.

#### 풀이

```java
import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        int sum = 0;
        for (int i = 0; i < A.length; i++){
            sum += (A[i] * B[B.length -1 - i]);
        }
        return sum;
    }
}
```

