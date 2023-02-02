# Programmers [여행경로](https://school.programmers.co.kr/learn/courses/30/lessons/43164)

### 난이도 ★★★

---

#### 문제 설명

> 주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.
>
> 항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.



#### 제한사항

>- 모든 공항은 알파벳 대문자 3글자로 이루어집니다.
>- 주어진 공항 수는 3개 이상 10,000개 이하입니다.
>- tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
>- 주어진 항공권은 모두 사용해야 합니다.
>- 만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
>- 모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.



#### 입출력 예

> | tickets                                                      | return                                     |
> | ------------------------------------------------------------ | ------------------------------------------ |
> | [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]             | ["ICN", "JFK", "HND", "IAD"]               |
> | [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]] | ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"] |
>
> ```
> 예제 #1
> 
> ["ICN", "JFK", "HND", "IAD"] 순으로 방문할 수 있습니다.
> 
> 예제 #2
> 
> ["ICN", "SFO", "ATL", "ICN", "ATL", "SFO"] 순으로 방문할 수도 있지만 ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"] 가 알파벳 순으로 앞섭니다.
> ```

#### 접근 방식

> DFS로 접근하였습니다.
>
> List에 담아서 출력을 해주었고 각 배열에서 0번이 출발지 이기 때문에 Start랑 배열 0번이랑 같은 지 확인해주고 방문여부를 체크해줍니다.
>
> 방문하지 않은 곳일 경우 도착지를 start에 넣어주고 재귀함수를 돌립니다.
>
> 모두 다 돌게되면 동선을 list에 넣어주고 다양한 경우가 나올 경우 알파벳 순으로 해야되니 `Colletcions.sort` 를 이용하여 정렬해줍니다.
>
> 그 다음 배열 형식으로 짤라서 저장해줍니다.

#### 풀이

```java
import java.util.*;
class Solution {
    static boolean [] visited ;
    static ArrayList<String> arr = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs("ICN", "ICN", tickets, 0);
        Collections.sort(arr);
        String [] answer = arr.get(0).split(" ");
        
        return answer;
    }
    static void dfs(String start, String route, String[][] tickets, int cnt){
        if(cnt == tickets.length){
            arr.add(route);
            return ;
        }
        for(int i = 0; i< tickets.length; i++){
            if(start.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt+1);
                visited[i] = false;
            }
        }
    }
}
```

