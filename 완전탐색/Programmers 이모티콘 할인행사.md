# Programmers [이모티콘 할인행사](https://school.programmers.co.kr/learn/courses/30/lessons/150368)

### 난이도 ★★

---

#### 접근 방식

> `완전탐색`으로 접근하여 풀었습니다.
>
> 각 이모티콘에 모든 할인율의 조합을 적용하였고 마지막에 최대 회원과 최대 수익을 비교하는 로직을 작성해 해결하였습니다.

#### 풀이

```java
import java.util.*;
class Solution {
    int sign = 0;
    int earn = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int [] arr = new int[emoticons.length];
        dfs(arr, 0, users, emoticons);
        answer[0] = sign;
        answer[1] = earn;
        return answer;
    }
    public void dfs(int [] arr, int start, int[][] users, int[] emoticons){
        if (start == arr.length){
            cal(arr, users, emoticons);
            return;
        }
        for (int i = 10 ; i <= 40; i+=10){
            arr[start] = i;
            dfs(arr, start+1, users, emoticons);
        }
    }
    public void cal(int [] arr, int[][] users, int [] emoticons){
        int cnt = 0;
        int calEarn = 0;
        for (int [] user : users){
            int discount = user[0];
            int totalPrice = user[1];
            int sum = 0;
            for (int i = 0; i< arr.length; i++){
                if (arr[i] >=discount){
                    sum += (emoticons[i] / 100) * (100 - arr[i]);
                }
            }
            if (sum >= totalPrice) cnt++;
            else calEarn += sum;
        }
        if (cnt > sign){
            sign = cnt;
            earn = calEarn;
        } else if (cnt == sign){
            if (earn < calEarn) earn = calEarn;
        }
    }
}
```

