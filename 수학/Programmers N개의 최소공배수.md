# Programmers [N개의 최소공배수](https://school.programmers.co.kr/learn/courses/30/lessons/12953)

### 난이도 ★★

---

#### 접근 방식

> 두 수의 `최소공배수`를 구하는 방법은 주어진 두 수 `a, b`가 있으면 `a * b / a와 b의 최대공약수`를 이용하면 두 수의 `최소공배수`를 구할 수 있습니다.
>
> 여기서 `두 수의 최대 공약수`를 구하는 방법은 `유클리드 호제법`을 이용하면 구할 수 있습니다.
>
> ```
> 유클리드 호제법
> int gcb (int a, int b){
> 	if (a % b == 0) return b;
> 	return gcb(b, a % b);
> }
> ```
>
> > `a`와 `b`가 주어질 경우 `b`가 `a`보다 더 크면 `if문`에 걸려서 자리가 뒤바뀌게 됩니다.
> >
> > 아닐 경우에도 값이 `0`이 아니면 계속해서 `0`이 될 때 까지 구하기 때문에 최대공약수를 구할 수 있습니다.

#### 풀이

```java
class Solution {
    // 두 수의 최소 공배수 = 주어진 두 수 a * b / 두 수의 최대공약수
    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i = 1; i < arr.length; i++){
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }
    public int lcm(int a, int b){
        return a * b / gcb(a, b);
    }
    public int gcb(int a, int b){
        if (a % b == 0) return b;
        return gcb(b, a % b);
    }
}
```

