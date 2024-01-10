# Programmers [다음 큰 숫자](https://school.programmers.co.kr/learn/courses/30/lessons/12911)

### 난이도 ★★

---

#### 접근 방식

> `toBinary`라는 주어진 정수를 `2진수의 1`의 값을 구할 수 있는 함수를 만들었습니다.
>
> 그 다음 `무한 루프`를 실행해 조건에 맞는 값이 나올 때 까지 반복하여 해결할 수 있었습니다. 

#### 풀이

```java
class Solution {
    public int solution(int n) {
        int answer = 0;
        int cur = toBinary(n);
        while(true){
            int next = toBinary(++n);
            if (cur == next){
                answer = n;
                break;
            }
        }
        return answer;
    }
    int toBinary(int n){
        int count = 1;
        while(n > 1){
            if (n % 2 == 1){
                count++;
            }
            n /= 2;
        }
        return count;
    }
}
```

