# Programmers [숫자 카드 나누기](https://school.programmers.co.kr/learn/courses/30/lessons/135807)

### 난이도 ★★

---

#### 접근 방식

> `최대 공약수`를 이용하면 풀 수 있는 문제였습니다. `유클리드 호제법`으로 `최대 공약수`를 구하고 반대쪽에 배열을 나눌 수 있는 지 없는 지 확인하면 됩니다. 

#### 풀이

```java
import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcbA = arrayA[0];
        int gcbB = arrayB[0];
        
        for (int i = 1; i < arrayA.length; i++){
            gcbA = gcb(gcbA, arrayA[i]);
            gcbB = gcb(gcbB, arrayB[i]);
        }
        if (checkDivide(arrayB, gcbA)) answer = Math.max(answer, gcbA);
        if (checkDivide(arrayA, gcbB)) answer = Math.max(answer, gcbB);
    
        
        return answer;
    }
    
    int gcb (int a, int b){
        if (a % b == 0) return b;
        return gcb(b, a % b);
    }
    
    boolean checkDivide(int [] array, int gcb){
        for (int i = 0; i < array.length; i++){
            if (array[i] % gcb == 0) return false;
        }
        return true;
    }
}
```

