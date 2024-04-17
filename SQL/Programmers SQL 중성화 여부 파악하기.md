# Programmers [중성화 여부 파악하기](https://school.programmers.co.kr/learn/courses/30/lessons/59409)

### 난이도 ★★

---

#### 접근 방식

> `case when`으로 조건문을 걸어줘서 해당 단어들을 포함하면 `o` 아니면 `x`를 출력하였습니다.

#### 풀이

```sql
select animal_id, name, 
case when sex_upon_intake like '%Neutered%' 
or sex_upon_intake like '%Spayed%' 
then 'O'
else 'X'
End as '중성화'
from animal_ins;
```

