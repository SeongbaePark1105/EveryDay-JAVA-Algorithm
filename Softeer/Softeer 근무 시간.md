# Softeer [근무 시간](https://softeer.ai/practice/info.do?idx=1&eid=990)

### 난이도 ★

---

#### 접근 방식

> StringTokenizer를 이용하여 입력 받은 것을 2번 짤라서 시간은 분으로 변환 후 출근 시간과 퇴근 시간의 차이를 계산하였습니다.

#### 풀이

```java
import java.util.*;
import java.io.*;


public class Main
{
  public static void main(String args[]) throws IOException
  {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int result = 0;
      for(int i = 0; i < 5; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          String str = st.nextToken();
          String str2 = st.nextToken();
          StringTokenizer st2 = new StringTokenizer(str, ":");
          StringTokenizer st3 = new StringTokenizer(str2, ":");
          int startH = Integer.parseInt(st2.nextToken());
          int startM = Integer.parseInt(st2.nextToken());
          int endH = Integer.parseInt(st3.nextToken());
          int endM = Integer.parseInt(st3.nextToken());
          result += (endH * 60 + endM) - (startH * 60 + startM);
      }
      System.out.println(result);
  }
}

```

