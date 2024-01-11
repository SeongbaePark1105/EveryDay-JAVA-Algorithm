# Programmers [숫자의 표현](https://school.programmers.co.kr/learn/courses/30/lessons/12924)

### 난이도 ★★

---

#### 접근 방식

> 이중 `for`문을 이용하여 해결하였습니다. 값을 넘으면 반복문을 끝내고 같을 경우에는 `answer`의 값을 증가시킵니다.

#### 풀이

```java
class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i<=n; i++){
            int sum = 0;
            for (int j = i; j <= n; j++){
                sum+= j;
                if (sum == n) {
                    answer++;
                    break;
                } else if (sum > n) break;
            }
        }
        return answer;
    }
}
```

