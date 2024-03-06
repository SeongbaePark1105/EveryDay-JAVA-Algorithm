# Programmers [멀리 뛰기](https://school.programmers.co.kr/learn/courses/30/lessons/12914)

### 난이도 ★★

---

#### 접근 방식

> `DP`방식으로 접근했습니다.
>
> 점화식을 구해보면 `피보나치의 수`인 것을 알 수 있었습니다.

#### 풀이

```java
class Solution {
    public long solution(int n) {
        long [] dp = new long[2001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        return dp[n];
    }
}
```

