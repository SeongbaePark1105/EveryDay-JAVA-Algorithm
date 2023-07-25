# Programmers [호텔 대실](https://school.programmers.co.kr/learn/courses/30/lessons/155651)

### 난이도 ★★

---

#### 문제 설명

> 호텔을 운영 중인 코니는 최소한의 객실만을 사용하여 예약 손님들을 받으려고 합니다. 한 번 사용한 객실은 퇴실 시간을 기준으로 10분간 청소를 하고 다음 손님들이 사용할 수 있습니다.
>예약 시각이 문자열 형태로 담긴 2차원 배열 `book_time`이 매개변수로 주어질 때, 코니에게 필요한 최소 객실의 수를 return 하는 solution 함수를 완성해주세요.

#### 제한사항

>- 1 ≤ book_time의 길이 ≤ 1,000
>  - book_time[i] 는 ["HH:MM", "HH:MM"]의 형태로 이루어진 배열입니다
>    - [대실 시작 시각, 대실 종료 시각] 형태입니다.
>  - 시각은 HH:MM 형태로 24시간 표기법을 따르며, "00:00" 부터 "23:59" 까지로 주어집니다.
>    - 예약 시각이 자정을 넘어가는 경우는 없습니다.
>    - 시작 시각은 항상 종료 시각보다 빠릅니다.

#### 입출력 예

> | book_time                                                    | result |
> | ------------------------------------------------------------ | ------ |
> | [["15:00", "17:00"], ["16:40", "18:20"], ["14:20", "15:20"], ["14:10", "19:20"], ["18:20", "21:20"]] | 3      |
> | [["09:10", "10:10"], ["10:20", "12:20"]]                     | 1      |
> | [["10:20", "12:30"], ["10:20", "12:30"], ["10:20", "12:30"]] | 3      |

#### 입출력 예 설명

>입출력 예 #1
>
>![example1](https://user-images.githubusercontent.com/62426665/199907266-561e3b75-84eb-4da1-930c-a6ac8fa82a79.png)
>위 사진과 같습니다.
>
>입출력 예 #2
>
>첫 번째 손님이 10시 10분에 퇴실 후 10분간 청소한 뒤 두 번째 손님이 10시 20분에 입실하여 사용할 수 있으므로 방은 1개만 필요합니다.
>
>입출력 예 #3
>
>세 손님 모두 동일한 시간대를 예약했기 때문에 3개의 방이 필요합니다.

#### 접근 방식

> `누적 합`을 사용하였습니다.
>
> 배열은 `24 * 60 +10(청소 시간)`만큼 선언해주었고 반복문을 수행할 때 아직 퇴실을 하지 않았으면 계속 1의 값을 가지기 때문에 그 사이에 겹치는 시간이 있으면 `2`가 되므로 방이 2개가 필요하다는 것을 알 수 있습니다. 그 값들을 계속 저장하면서 퇴실할 경우 값을 빼주고 진행하게 된다면 총 필요한 방의 개수를 구할 수 있게 됩니다.

#### 풀이

```java
import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int [] rooms = new int[1450];
        for (String [] time : book_time){
            String inTime = time[0];
            String outTime = time[1];
            rooms[calTime(inTime)] += 1;
            rooms[calTime(outTime) + 10] -= 1;
        }
        for(int i = 1; i < 1450; i++){
            rooms[i] += rooms[i-1];
            answer = Math.max(answer, rooms[i]);
        }
        return answer;
    }
    
    private static int calTime(String time){
        String [] splitTime = time.split(":");
        String hour = splitTime[0];
        String min = splitTime[1];
        int hourNum = Integer.parseInt(hour) * 60;
        int minNum = Integer.parseInt(min);
        return hourNum + minNum;
    }
}
```

