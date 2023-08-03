# Softeer [플레이페어 암호](https://softeer.ai/practice/info.do?idx=1&eid=804&sw_prbl_sbms_sn=234070)

### 난이도 ★★

---

#### 접근 방식

> `List`를 만들어 `J`를 제외 한 알파벳을 순차적으로 넣어주고 `key`값에 있는 단어들은 `list`에서 제외하고 배열에 값을 넣어줬습니다. 그 다음 나머지 리스트에 있는 것을 순차적으로 배열에 넣어줬습니다.
>
> 여기서 `Character.valueOf`를 사용한 이유는 `ArrayList`에서 `remove`할 때, `remove(Object O)` 보다 `remove(int index)`가 먼저 인식되기 때문에 `(type).valueOf`를 사용하여 값을 먼저 넣어줘야 합니다.
>
> 그리고 다음 값이 암호화 해야 될 문자에서 2글자로 자를 때 같을 경우에는 `X`나 `Q`를 추가 해주는데 `StringBuilder` 에 있는 `insert`를 활용하면 `sb.insert(인덱스 값, 원하는 값)`을 사용하여 원하는 문자 바로 뒤에 값을 넣을 수 있습니다.
>
> 나머지는 구현이고 거기에서 `StringBuilder`에 있는 `setCharAt(인덱스 값, Character 값)`을 활용하여 해당 인덱스의 값을 변경하여 원하는 답을 구할 수 있었습니다.

#### 풀이

```java
import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String strMessage = br.readLine();
    String strKey = br.readLine();
    List<Character> alphabet = new ArrayList<>();
    char [][] arr = new char[5][5];
    for (int i = 0 ; i < 26; i++){
      if ( (char) 'A' + i == 'J') continue;
      alphabet.add( (char) ('A' + i));
    }
    int col = 0;
    int row = 0;
    int keyLen = strKey.length();
    for (int i = 0; i < keyLen; i++){
      if (alphabet.contains(strKey.charAt(i))){
        arr[row][col] = strKey.charAt(i);
        alphabet.remove(Character.valueOf(arr[row][col]));
        col++;
        if (col == 5){
          col = 0;
          row++;
        }
      }
    }
    for (int i = 0; i < alphabet.size(); i++){
      arr[row][col] = alphabet.get(i);
      col++;
      if (col == 5){
        col = 0;
        row++;
      }
    }
    StringBuilder sb = new StringBuilder();
    sb.append(strMessage);
    for (int i = 0; i < sb.length() - 1; i+=2 ){
      if (sb.charAt(i) == sb.charAt(i+1)){
        if (sb.charAt(i) == 'X'){
          sb.insert(i + 1, 'Q');
        } else{
          sb.insert(i + 1, 'X');
        }
      }
    }
    if (sb.length() %2 == 1){
      sb.append('X');
    }
    for (int i = 0; i < sb.length() - 1; i+=2){
      char ch1 = sb.charAt(i);
      char ch2 = sb.charAt(i+1);
      int cx = 0, cy = 0, cx2 = 0, cy2 = 0;
      for (int y = 0; y < 5; y++){
        for (int x = 0; x < 5; x++){
          // if - else if 로 하면 안되는 이유는 암호화 해야되는 메시지가 연속적으로 같은 단어가 올 수 있기 때문이다.
          if (ch1 == arr[y][x]) {
            cy = y;
            cx = x;
          }
          if (ch2 == arr[y][x]) {
            cy2 = y;
            cx2 = x;
          }
        }
      }
      if (cy == cy2) {
        if (cx + 1 >= 5) cx = -1;
        if (cx2 + 1 >= 5) cx2 = -1;
        sb.setCharAt(i, arr[cy][cx + 1]);
        sb.setCharAt(i + 1, arr[cy2][cx2 + 1]);
      } else if (cx == cx2){
        if (cy + 1>= 5) cy = -1;
        if (cy2 + 1>=5) cy2 = -1;
        sb.setCharAt(i, arr[cy + 1][cx]);
        sb.setCharAt(i + 1, arr[cy2 + 1][cx2]);
      } else {
        sb.setCharAt(i, arr[cy][cx2]);
        sb.setCharAt(i + 1, arr[cy2][cx]);
      }
    }
    System.out.println(sb);
  }
}
```

