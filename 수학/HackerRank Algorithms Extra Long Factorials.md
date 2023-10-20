# HackerRank [Extra Long Factorials](https://www.hackerrank.com/challenges/extra-long-factorials/problem?isFullScreen=true)

### 난이도 `Medium`

---

#### 접근 방식

> `BigInteger`를 사용해야 풀 수 있는 문제입니다.
>
> `BigInteter`는 문자열이기 때문에 사칙연산이 안됩니다. 그래서 내부 메서드를 사용하여 해결하였습니다.

#### 풀이

```java
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {


    public static void extraLongFactorials(int n) {
    BigInteger value = BigInteger.valueOf(1);
    for (int i = 2; i <= n; i++){
        value = value.multiply(BigInteger.valueOf(i));
    }
    System.out.println(value);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.extraLongFactorials(n);

        bufferedReader.close();
    }
}
```

