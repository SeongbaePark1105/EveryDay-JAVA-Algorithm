# Programmers [숫자 변환하기](https://school.programmers.co.kr/learn/courses/30/lessons/154538)

### 난이도 ★★

---

#### 문제 설명

> 자연수 `x`를 `y`로 변환하려고 합니다. 사용할 수 있는 연산은 다음과 같습니다.
>
> - `x`에 `n`을 더합니다
>- `x`에 2를 곱합니다.
> - `x`에 3을 곱합니다.
>
> 자연수 `x`, `y`, `n`이 매개변수로 주어질 때, `x`를 `y`로 변환하기 위해 필요한 최소 연산 횟수를 return하도록 solution 함수를 완성해주세요. 이때 `x`를 `y`로 만들 수 없다면 -1을 return 해주세요.

#### 제한사항

>- 1 ≤ `x` ≤ `y` ≤ 1,000,000
> - 1 ≤ `n` < `y`

#### 입출력 예

> | x    | y    | n    | result |
> | ---- | ---- | ---- | ------ |
> | 10   | 40   | 5    | 2      |
> | 10   | 40   | 30   | 1      |
> | 2    | 5    | 4    | -1     |

#### 입출력 예 설명

> 입출력 예 #1
>`x`에 2를 2번 곱하면 40이 되고 이때가 최소 횟수입니다.
> 
>입출력 예 #2
> `x`에 `n`인 30을 1번 더하면 40이 되고 이때가 최소 횟수입니다.
> 
> 입출력 예 #3
> `x`를 `y`로 변환할 수 없기 때문에 -1을 return합니다.

#### 접근 방식

> 크기가 `1,000,000`이기 때문에 `HashSet`를 이용하지 않으면 `시간 초과`가 나는 케이스가 있었습니다. `HashSet`에 이미 계산되어 저장된 값이 있을 경우 한번 더 `큐`에 넣어 실행하지 않도록 조건을 걸어서 중복해서 수행하지 않도록 하여 `시간 초과`를 해결할 수 있었습니다.

#### 풀이

```java
import java.util.*;
class Solution {
    static int answer = -1;
    static HashSet<Integer> hs = new HashSet<>();
    public int solution(int x, int y, int n) {
        bfs(x, y, n);
        return answer;
    }
    static void bfs(int x, int y, int n){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, 0});
        hs.add(x);
        while(!queue.isEmpty()){
            int[] q = queue.poll();
            int num = q[0];
            int cnt = q[1];
            if (num == y ){
                answer = cnt;
                return;
            }
            if (num + n <= y && !hs.contains(num + n)) {
                queue.add(new int[]{num + n, cnt + 1});
                hs.add(num + n);
            }
            if (num * 2 <= y && !hs.contains(num * 2)) {
                queue.add(new int[]{num * 2, cnt + 1});
                hs.add(num * 2);
            }
            if (num * 3 <= y && !hs.contains(num * 3)) {
                queue.add(new int[]{num * 3, cnt + 1});
                hs.add(num * 3);
            }
        }
    }
}
```

