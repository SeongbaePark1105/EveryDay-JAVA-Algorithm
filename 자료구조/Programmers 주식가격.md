# Programmers [주식가격](https://school.programmers.co.kr/learn/courses/30/lessons/42584)

### 난이도 ★★

---

#### 문제 설명

> 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.

#### 제한사항

>- prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
>- prices의 길이는 2 이상 100,000 이하입니다.

#### 입출력 예

> | prices          | return          |
> | --------------- | --------------- |
> | [1, 2, 3, 2, 3] | [4, 3, 1, 1, 0] |



#### 접근 방식

> `stack` 방식 풀이와 `반복문` 방식 풀이 2가지의 방식으로 풀었습니다.
>
> `stack`의 경우 `while`문을 이용하여 값이 존재하고 가격이 떨어졌을 경우 해당 배열의 시간은 감소된 주식가격의 인덱스 번호와 비교한 주식 가격의 인덱스 번호의 차이를 비교해주면 시간이 나옵니다.
>
> 만약에 여기서 구하지 못했을 경우 아래의 `while`문에서 스택에 남은 값을 배열의 인덱스 번호로 적어주고 `전체 길이에서 감소가 되지 않은 주식 가격의 인덱스 번호 + 1 (해당 코드에는 -1 적었습니다.)`를 해주면 몇초동안 떨어지지 않았는 지 값이 나옵니다.
>
> `반복문`의 해결 방법은 `이중 반복문`을 이용하여 값이 큰지 아닌지만 비교해주면 됩니다.
>
> 여기서 클 경우에도 시간은 지나는 것이기 때문에 시간을 증감시켜줘야됩니다. 

#### 풀이

```java
import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < prices.length; i++){
            while (!st.isEmpty() && prices[i] < prices[st.peek()]){
                answer[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            answer[st.peek()] = prices.length - st.peek() - 1;
            st.pop();
        }
        
        for (int i = 0; i < prices.length; i++){
            for (int j = i + 1; j < prices.length; j++){
                if (prices[j] < prices[i]){
                    answer[i]++;
                    break;
                }
                answer[i]++;
            }
        }
        
        return answer;
    }
}
```

