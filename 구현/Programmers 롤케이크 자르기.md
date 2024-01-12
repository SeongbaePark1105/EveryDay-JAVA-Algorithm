# Programmers [롤 케이크 자르기](https://school.programmers.co.kr/learn/courses/30/lessons/132265)

### 난이도 ★★

---

#### 접근 방식

> 처음에는 `이분탐색`을 이용하여 각각의 `set`에 값들을 담아서 `size`를 비교했는데 매우 비효율적이였고 `시간초과`도 나왔습니다.
>
> 따라서, 다른 방법인 `Map`을 이용하여 해결하였습니다.
>
> 하나의 `Map`에는 모든 값을 담고 나머지 `Map`은 빈 값으로 진행합니다.
>
> 그 다음 반복문을 이용하여 `topping`배열에 값들을 계속 꺼내어 꽉 찬 `Map`은 값이 있다면 빼주고 `0`이 되면 제거해줍니다. 빈 값의 `Map`은 값을 계속 추가해줍니다.
>
> 그리고, 매 번 `반복문`이 돌 때마다 크기를 비교하여 경우의 수를 체크해줍니다.

#### 풀이

```java
import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> old = new HashMap<>();
        Map<Integer, Integer> young = new HashMap<>();
        for (int t : topping){
            old.put(t, old.getOrDefault(t, 0) + 1);
        }
        for (int t : topping){
            young.put(t, young.getOrDefault(t, 0) + 1);
            if (old.get(t) -1 == 0) old.remove(t);
            else old.put(t, old.get(t) - 1);
            if (old.size() == young.size()) answer++;
        }
        return answer;
    }
}
```

