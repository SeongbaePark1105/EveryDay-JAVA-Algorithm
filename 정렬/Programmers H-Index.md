# Programmers [K번째 수](https://school.programmers.co.kr/learn/courses/30/parts/12198)

### 난이도 ★

---

#### 문제 설명

> H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과[1](https://school.programmers.co.kr/learn/courses/30/lessons/42747#fn1)에 따르면, H-Index는 다음과 같이 구합니다.
>
> 어떤 과학자가 발표한 논문 `n`편 중, `h`번 이상 인용된 논문이 `h`편 이상이고 나머지 논문이 h번 이하 인용되었다면 `h`의 최댓값이 이 과학자의 H-Index입니다.
> 
> 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.

#### 제한사항

>- 과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
>- 논문별 인용 횟수는 0회 이상 10,000회 이하입니다.

#### 입출력 예

> | citations       | return |
> | --------------- | ------ |
> | [3, 0, 6, 1, 5] | 3      |

#### 입출력 예 설명

> 이 과학자가 발표한 논문의 수는 5편이고, 그중 3편의 논문은 3회 이상 인용되었습니다. 그리고 나머지 2편의 논문은 3회 이하 인용되었기 때문에 이 과학자의 H-Index는 3입니다.

#### 접근 방식

> 정렬한 뒤 조건대로 `h번`이상 인용된 논문이 `h`편 이상인지 체크를 해주었습니다.
>
> ```
> EX)
> [0, 1, 3, 5, 6] 일 때, 
> 1) 0 5 5번 이상 5편 이상 false
> 2) 1 4 4번 이상 4편 이상 false
> 3) 3 3 3번 이상 3편 이상 true
> 4) 5 2 2번 이상 2편 이상 true
> 5) 6 1 1번 이상 1편 이상 true
> 
> 여기서 최대 값을 출력하는 것 이기 때문에 3이 정답입니다.
> ```

#### 풀이

```java
import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}
```

