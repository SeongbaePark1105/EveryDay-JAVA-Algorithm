# Programmers [뒤에 있는 큰 수 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/154539)

### 난이도 ★★

---

#### 문제 설명

> 정수로 이루어진 배열 `numbers`가 있습니다. 배열 의 각 원소들에 대해 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수를 뒷 큰수라고 합니다.
> 정수 배열 `numbers`가 매개변수로 주어질 때, 모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을 return 하도록 solution 함수를 완성해주세요. 단, 뒷 큰수가 존재하지 않는 원소는 -1을 담습니다.

#### 제한사항

>- 4 ≤ `numbers` 의 길이 ≤ 1,000,000
>  - 1 ≤ `numbers[i]` ≤ 1,000,000

#### 입출력 예

> | numbers            | result                |
> | ------------------ | --------------------- |
> | [2, 3, 3, 5]       | [3, 5, 5, -1]         |
> | [9, 1, 5, 3, 6, 2] | [-1, 5, 6, 6, -1, -1] |

#### 입출려 예 설명

> 입출력 예 #1
> 2의 뒷 큰수는 3입니다. 첫 번째 3의 뒷 큰수는 5입니다. 두 번째 3 또한 마찬가지입니다. 5는 뒷 큰수가 없으므로 -1입니다. 위 수들을 차례대로 배열에 담으면 [3, 5, 5, -1]이 됩니다.
>
> 입출력 예 #2
> 9는 뒷 큰수가 없으므로 -1입니다. 1의 뒷 큰수는 5이며, 5와 3의 뒷 큰수는 6입니다. 6과 2는 뒷 큰수가 없으므로 -1입니다. 위 수들을 차례대로 배열에 담으면 [-1, 5, 6, 6, -1, -1]이 됩니다.

#### 접근 방식

> 제한사항에서 길이가 `1,000,000` 입니다. 시간복잡도를 고려하여 이중 반복문을 사용할 경우 `시간 초과`가 날 우려가 있습니다.
>
> `stack`을 활용하여 반복문을 배열 맨 뒤부터 검사를 시작하여 `시간 초과` 문제를 해결할 수 있었습니다.

#### 풀이

```java
import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        int start = numbers.length -1;
        for (int i = start; i >=0; i--){
            while(!stack.isEmpty()){
                if(stack.peek() > numbers[i]){
                    answer[i] = stack.peek();
                    break;
                } else stack.pop();
            }
            if (stack.isEmpty()) answer[i] = -1;
            stack.push(numbers[i]);
        }
        return answer;
    }
}
```

