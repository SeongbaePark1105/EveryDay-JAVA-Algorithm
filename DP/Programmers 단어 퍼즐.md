# Programmers [단어 퍼즐](https://school.programmers.co.kr/learn/courses/18/lessons/1882)

### 난이도 ★★★★

---

#### 문제 설명

> 단어 퍼즐은 주어진 단어 조각들을 이용해서 주어진 문장을 완성하는 퍼즐입니다. 이때, 주어진 각 단어 조각들은 각각 무한개씩 있다고 가정합니다. 예를 들어 주어진 단어 조각이 [“ba”, “na”, “n”, “a”]인 경우 "ba", "na", "n", "a" 단어 조각이 각각 무한개씩 있습니다. 이때, 만들어야 하는 문장이 “banana”라면 “ba”, “na”, “n”, “a”의 4개를 사용하여 문장을 완성할 수 있지만, “ba”, “na”, “na”의 3개만을 사용해도 “banana”를 완성할 수 있습니다. 사용 가능한 단어 조각들을 담고 있는 배열 strs와 완성해야 하는 문자열 t가 매개변수로 주어질 때, 주어진 문장을 완성하기 위해 사용해야 하는 단어조각 개수의 최솟값을 return 하도록 solution 함수를 완성해 주세요. 만약 주어진 문장을 완성하는 것이 불가능하면 -1을 return 하세요.

#### 제한사항

>- strs는 사용 가능한 단어 조각들이 들어있는 배열로, 길이는 1 이상 100 이하입니다.
>- strs의 각 원소는 사용 가능한 단어조각들이 중복 없이 들어있습니다.
>- 사용 가능한 단어 조각들은 문자열 형태이며, 모든 단어 조각의 길이는 1 이상 5 이하입니다.
>- t는 완성해야 하는 문자열이며 길이는 1 이상 20,000 이하입니다.
>- 모든 문자열은 알파벳 소문자로만 이루어져 있습니다.

#### 입출력 예

> | strs                                | t        | result |
> | ----------------------------------- | -------- | ------ |
> | ["ba","na","n","a"]                 | "banana" | 3      |
> | ["app","ap","p","l","e","ple","pp"] | "apple"  | 2      |
> | ["ba","an","nan","ban","n"]         | "banana" | -1     |

#### 입출력 예 설명

>입출력 예 #1
>문제의 예시와 같습니다.
>
>입출력 예 #2
>"ap" 1개, "ple" 1개의 총 2개로 "apple"을 만들 수 있으므로 필요한 단어 개수의 최솟값은 2를 return 합니다.
>
>입출력 예 #3
>주어진 단어로는 "banana"를 만들 수 없으므로 -1을 return 합니다.

#### 접근 방식

> `dp[i]` 는 `i`번째부터 단어의 마지막까지 문자열을 만드는 최소 횟수를 의미합니다.
>
> 단어를 만들어 갈 때는 길이가 긴 단어부터 하는 게 유리합니다.

#### 풀이

```java
import java.util.*;
class Solution {
    public static int [] dp;
    public int solution(String[] strs, String t) {
        int len = t.length();
        dp = new int[len];
        Arrays.fill(dp, -1);
        Arrays.sort(strs, (String s1, String s2) -> s2.length() - s1.length());
        int answer = solve(0, t, strs);

        if (answer <= 20000){
            return answer;
        } else {
            return -1;
        }
    }
    
    public static int solve(int idx, String check, String[] strs){

        if (idx == check.length()){
            return 0;
        }
        if (dp[idx] != -1){
            return dp[idx];
        }
        
        dp[idx] = 20001;
        for (int i = 0; i < strs.length; i++){
            if (idx + strs[i].length() <= check.length()){
                boolean flag = true;
                for (int j = 0; j < strs[i].length(); j++){
                    if (check.charAt(idx + j) != strs[i].charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    dp[idx] = Math.min(dp[idx], solve(idx + strs[i].length(), check, strs) +1);
                    
                }
            }
        }
        return dp[idx];
    }
}
```

