# Programmers [주차 요금 계산](https://school.programmers.co.kr/learn/courses/30/lessons/92341)

### 난이도 ★★

---

#### 접근 방식

> `Map`을 사용하여 문제에 접근하였습니다.
>
> `In, out`을 구분할 `Map`, 한 타임의 주차 시간을 담는 `Map`, 한 차의 전체 시간을 담는 `map` 이렇게 3개를 선언하여 접근하였습니다.
>
> 나머지는 조건에 맞춰 구현하였습니다.

#### 풀이

```java
import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> carInAndOut = new HashMap<>();
        Map<String, Integer> carTime = new HashMap<>();
        Map<String, Integer> totalFee = new HashMap<>();

        for (String str : records){
            String [] strArr = str.split(" ");
            String [] time = strArr[0].split(":");
            int num = Integer.parseInt(time[1]) + ( Integer.parseInt(time[0]) * 60);
            if (!carTime.containsKey(strArr[1])){
                carTime.put(strArr[1], num);
                carInAndOut.put(strArr[1], strArr[2]);
            } else {
                if (carInAndOut.get(strArr[1]).equals("IN")){
                    carInAndOut.put(strArr[1], "OUT");
                    int totalCarTime = num - carTime.get(strArr[1]);
                    totalFee.put(strArr[1], totalFee.getOrDefault(strArr[1], 0) + totalCarTime);
                } else {
                    carInAndOut.put(strArr[1], "IN");
                    carTime.put(strArr[1], num);
                }
            }
        }
        
        for (String key : carInAndOut.keySet()) {
            if (carInAndOut.get(key).equals("IN")){
                carInAndOut.put(key, "OUT");
                int num = (23 * 60) + 59;
                int totalTime = num - carTime.get(key);
                totalFee.put(key, totalFee.getOrDefault(key, 0) + totalTime);
            }
        }
        ArrayList<String> list = new ArrayList<>(carTime.keySet());
        Collections.sort(list);
        int[] answer = new int[list.size()];
        int cnt = 0;
        for (String key : list) {
            int timeFee = totalFee.get(key) - fees[0];
            if (timeFee < 0) timeFee = 0;
            if (timeFee % fees[2] != 0) timeFee = (timeFee / fees[2]) + 1;
            else timeFee /= fees[2];
            answer[cnt++] = fees[1] + timeFee * fees[3];
        }

        return answer;
    }
}
```

