# Programmers [입양 시각 구하기(1)](https://school.programmers.co.kr/learn/courses/30/lessons/59412)

### 난이도 ★★

---

#### 문제 설명

> `ANIMAL_OUTS` 테이블은 동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블입니다. `ANIMAL_OUTS` 테이블 구조는 다음과 같으며, `ANIMAL_ID`, `ANIMAL_TYPE`, `DATETIME`, `NAME`, `SEX_UPON_OUTCOME`는 각각 동물의 아이디, 생물 종, 입양일, 이름, 성별 및 중성화 여부를 나타냅니다.
>
> | NAME             | TYPE       | NULLABLE |
> | ---------------- | ---------- | -------- |
> | ANIMAL_ID        | VARCHAR(N) | FALSE    |
> | ANIMAL_TYPE      | VARCHAR(N) | FALSE    |
> | DATETIME         | DATETIME   | FALSE    |
> | NAME             | VARCHAR(N) | TRUE     |
> | SEX_UPON_OUTCOME | VARCHAR(N) | FALSE    |

#### 문제

>보호소에서는 몇 시에 입양이 가장 활발하게 일어나는지 알아보려 합니다. 09:00부터 19:59까지, 각 시간대별로 입양이 몇 건이나 발생했는지 조회하는 SQL문을 작성해주세요. 이때 결과는 시간대 순으로 정렬해야 합니다.

#### 예시

> SQL문을 실행하면 다음과 같이 나와야 합니다.
>
> | HOUR | COUNT |
> | ---- | ----- |
> | 9    | 1     |
> | 10   | 2     |
> | 11   | 13    |
> | 12   | 10    |
> | 13   | 14    |
>| 14   | 9     |
> | 15   | 7     |
>| 16   | 10    |
> | 17   | 12    |
> | 18   | 16    |
> | 19   | 2     |

#### 접근 방식

> `hour` 함수를 이용하여 `datetime`에서 시간을 추출할 수 있습니다.
>
> `count`를 활용하여 `group by`로 묶은 것을 개수를 셀 수 있고 `having`절에서 `9`시에서 `19`시 사이의 결과를 추출합니다.

#### 풀이

```sql
select hour(datetime) as hour, count(*) as count
from animal_outs
group by hour(datetime)
having hour between 9 and 19 
# having hour >=9 and hour <=19
order by hour;
```

