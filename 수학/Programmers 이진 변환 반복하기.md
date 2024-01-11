# Programmers [이진 변환 반복하기](https://school.programmers.co.kr/learn/courses/30/lessons/70129)

### 난이도 ★★

---

#### 접근 방식

> 함수를 만들어서 문자열에서 `0`을 빼준 문자열을 만들고 `2진수`로 변환해주는 함수를 만들어 해결하였습니다. 이 과정에서 `Integer.toBinaryString(int값)`을 이용하면 `10진수`값을 `2진수`값으로 변환할 수 있습니다. 또한, 여담으로 `2진수`값을 `10진수`값으로 변환하는 방법은 `Integer.parseInt(문자열, radix)`를 이용해서 `문자열`을 변환할 진수`(radix)`로 읽어서 `int`로 변환할 수 있습니다. 
>
> `ex) Integer.parseInt(4, 2) - > 2진수 : 100 -> 10진수 : 4 값으로 변경`

#### 풀이

```java
import java.util.*;
class Solution {
    int [] answer = new int[2];
    public int[] solution(String s) {
        while(true){
            String result = toBinary(s);
            if (result.length() == 1){
                break;
            }
            s = result;
        }
        return answer;
    }
    public String toBinary(String str){
        answer[0]++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '1') sb.append(str.charAt(i));
            else answer[1]++;
        }
        int num = sb.toString().length();
        String binary = Integer.toBinaryString(num);
        return binary;
    }
}
```

