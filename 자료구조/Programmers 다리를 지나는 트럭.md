# Programmers [다리를 지나는 트럭](https://school.programmers.co.kr/learn/courses/30/lessons/42583)

### 난이도 ★★

---

#### 문제 설명

> 트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있습니다. 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.
>
> 예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
>
> | 경과 시간 | 다리를 지난 트럭 | 다리를 건너는 트럭 | 대기 트럭 |
> | --------- | ---------------- | ------------------ | --------- |
> | 0         | []               | []                 | [7,4,5,6] |
> | 1~2       | []               | [7]                | [4,5,6]   |
> | 3         | [7]              | [4]                | [5,6]     |
> | 4         | [7]              | [4,5]              | [6]       |
> | 5         | [7,4]            | [5]                | [6]       |
> | 6~7       | [7,4,5]          | [6]                | []        |
> | 8         | [7,4,5,6]        | []                 | []        |
>
> 따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.
>
> solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭 별 무게 truck_weights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.

#### 제한사항

>- bridge_length는 1 이상 10,000 이하입니다.
>- weight는 1 이상 10,000 이하입니다.
>- truck_weights의 길이는 1 이상 10,000 이하입니다.
>- 모든 트럭의 무게는 1 이상 weight 이하입니다.

#### 입출력 예

> | bridge_length | weight | truck_weights                   | return |
> | ------------- | ------ | ------------------------------- | ------ |
> | 2             | 10     | [7,4,5,6]                       | 8      |
> | 100           | 100    | [10]                            | 101    |
> | 100           | 100    | [10,10,10,10,10,10,10,10,10,10] | 110    |



#### 접근 방식

> 다리에 올라갈 경우 1초가 지나는 것으로 문제에 나와있습니다.
>
> 첫 번째는 `if`문은 큐에 아무것도 없는 경우에 트럭을 큐에 넣어주었습니다.
>
> 큐의 크기와 다리의 길이가 같을 경우 다리 끝에 도착한 것이므로 도착한 트럭을 빼줍니다.
>
> 다음 `else`문은 다리 길이만큼 큐가 차지 않았을 경우에 트럭을 추가하는 경우입니다.
>
> 무게가 넘지 않을 경우 새로운 트럭을 추가해주고 무게를 넘을 경우 무게의 영향이 안가게 큐에 `0`을 추가하고 시간을 증감시킴으로서 다리에 있는 트럭이 전진했다는 것을 표현해줍니다.
>
> 마지막 `return`문에서 마지막 트럭에서 반복문이 끝나는데 마지막 역시 다리 길이만큼 지나가야해서 다리 길이를 더해주었습니다.

#### 풀이

```java
import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        int time = 0;
        for (int i = 0; i < truck_weights.length; i++){
            int truck = truck_weights[i];
            while(true){
                if (q.isEmpty()){
                    q.add(truck);
                    sum += truck;
                    time++;
                    break;
                } else if (q.size() == bridge_length){
                    sum-= q.poll();
                } else{
                    if (sum + truck <= weight){
                        q.add(truck);
                        sum+=truck;
                        time++;
                        break;
                    } else {
                        q.add(0);
                        time++;
                    }
                }
            }
        }
        return time + bridge_length;
    }
}
```

