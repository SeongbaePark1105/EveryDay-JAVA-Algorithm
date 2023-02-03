# Programmers [프린터](https://school.programmers.co.kr/learn/courses/30/lessons/42587)

### 난이도 ★★

---

#### 문제 설명

> 일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다. 이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.
>
> ```
> 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
> 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
> 3. 그렇지 않으면 J를 인쇄합니다.
> ```
>
> 예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.
>
> 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.
>
> 현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주

#### 제한사항

>- 현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
>- 인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
>- location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.

#### 입출력 예

> | priorities         | location | return |
> | ------------------ | -------- | ------ |
> | [2, 1, 3, 2]       | 2        | 1      |
> | [1, 1, 9, 1, 1, 1] | 0        | 5      |



#### 접근 방식

> 우선 순위 큐를 이용하였고 중요도가 큰 수부터 빼내는 것이니 우선 순위 큐를 선언할 때 `Collections.reverseOrder())`를 활용하여 내림차순으로 정렬합니다.
>
> while문과 for문을 돌려서 먼저 수가 같은 지 체크해주고 위치가 원하는 위치인지 확인 후 맞으면 몇 번째인지 카운터를 증가시켜준 뒤 `return`해줍니다.
>
> 숫자는 같은 데 내가 뽑아야 될 인쇄물이 아닐 경우 값을 삭제해주고 프린터 순위가 밀렸으니 값을 증가시켜줍니다.

#### 풀이

```java
import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : priorities){
            pq.add(i);
        }
        System.out.println(pq);
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {

                if (priorities[i] == pq.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }
        return -1;
    }
}
```

