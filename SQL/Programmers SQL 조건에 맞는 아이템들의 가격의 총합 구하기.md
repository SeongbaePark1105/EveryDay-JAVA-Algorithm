# Programmers [조건에 맞는 아이템들의 가격의 총합 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/273709)

### 난이도 ★★

---

#### 접근 방식

> `sum`과 `where`절에서 체크를 해주어 풀었습니다.

#### 풀이

```sql
select sum(price) as "TOTAL_PRICE" from ITEM_INFO
where rarity ='LEGEND'
```

