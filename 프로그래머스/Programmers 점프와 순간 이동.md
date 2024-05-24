# Programmers [점프와 순간 이동](https://school.programmers.co.kr/learn/courses/30/lessons/12980)

### 난이도 ★★

---

#### 접근 방식

> 순간이동은 짝수 위치의 값만 도착 하기 때문에 주어진 값 `n`을 기준으로 `%2`를 하여 해당 위치에는 건전지의 값이 들지 않기 때문에 주어진 값의 `/2`만 진행합니다. 그리고 `n`의 값이 홀수가 될 때는 `-1`을 해주어 계속 값을 깍아내려가고 `ans`의 값을 증가시킵니다.

#### 풀이

```java
import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        while(n != 0){
            if (n % 2 == 0) n /= 2;
            else {
                n--;
                ans++;
            }
        }
        return ans;
    }
}
```

