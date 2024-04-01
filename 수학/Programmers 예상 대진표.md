# Programmers [예상 대진표](https://school.programmers.co.kr/learn/courses/30/lessons/12985)

### 난이도 ★★

---

#### 접근 방식

> A와B가 같은 그룹에 속할 때 까지 반복을 하는데 
>
> 예시를 들면, `3`과 `4`는 같은 그룹이지만 `나누기 2`로 해봤을 때 `1.5`와 `2.0`의 값을 가지게 됩니다.
>
> 따라서, 두 수의 `1`을 더해주면 `4`의 값과 `5`의 값을 가지게 되는 `2.0`과 `2.5`의 값을 가지게 됩니다.
>
> 그리고 두 수를 `int`형으로 표현하면 `2`의 값을 가지게 됩니다.
>
> 즉, 두 수의 `1`을 더하고 나눴을 때 값이 같을 경우에는 같은 그룹이라고 볼 수 있습니다.

#### 풀이

```java
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        while (a != b ){
            a = ( a + 1 ) / 2;
            b = ( b + 1 ) / 2;
            answer++;
        }
        return answer;
    }
}
```

