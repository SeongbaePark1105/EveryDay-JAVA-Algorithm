# Programmers [카테고리 별 상품 개수 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/131529)

### 난이도 ★★

---

#### 접근 방식

> `left` 함수를 이용하면 맨 왼쪽부터 주어진 숫자만큼 문자열을 추출합니다.
>
> 그거 기반으로 `group by`와 `order by`를 이용하여 해결하였습니다.

#### 풀이

```sql
select left(product_code, 2) as category,
count(*) as products
from product
group by category
order by category ;
```

