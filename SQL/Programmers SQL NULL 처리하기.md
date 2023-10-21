# Programmers [NULL 처리하기](https://school.programmers.co.kr/learn/courses/30/lessons/59410)

### 난이도 ★★

---

#### 문제 설명

> `ANIMAL_INS` 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다. `ANIMAL_INS` 테이블 구조는 다음과 같으며, `ANIMAL_ID`, `ANIMAL_TYPE`, `DATETIME`, `INTAKE_CONDITION`, `NAME`, `SEX_UPON_INTAKE`는 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.
>
> | NAME             | TYPE       | NULLABLE |
> | ---------------- | ---------- | -------- |
> | ANIMAL_ID        | VARCHAR(N) | FALSE    |
> | ANIMAL_TYPE      | VARCHAR(N) | FALSE    |
> | DATETIME         | DATETIME   | FALSE    |
> | INTAKE_CONDITION | VARCHAR(N) | FALSE    |
> | NAME             | VARCHAR(N) | TRUE     |
> | SEX_UPON_INTAKE  | VARCHAR(N) | FALSE    |

#### 문제

>입양 게시판에 동물 정보를 게시하려 합니다. 동물의 생물 종, 이름, 성별 및 중성화 여부를 아이디 순으로 조회하는 SQL문을 작성해주세요. 이때 프로그래밍을 모르는 사람들은 NULL이라는 기호를 모르기 때문에, 이름이 없는 동물의 이름은 "No name"으로 표시해 주세요.

#### 예시

> 예를 들어 `ANIMAL_INS` 테이블이 다음과 같다면
>
> | ANIMAL_ID | ANIMAL_TYPE | DATETIME            | INTAKE_CONDITION | NAME  | SEX_UPON_INTAKE |
> | --------- | ----------- | ------------------- | ---------------- | ----- | --------------- |
> | A350276   | Cat         | 2017-08-13 13:50:00 | Normal           | Jewel | Spayed Female   |
> | A350375   | Cat         | 2017-03-06 15:01:00 | Normal           | Meo   | Neutered Male   |
> | A368930   | Dog         | 2014-06-08 13:20:00 | Normal           | NULL  | Spayed Female   |
> 
> 마지막 줄의 개는 이름이 없기 때문에, 이 개의 이름은 "No name"으로 표시합니다. 따라서 SQL문을 실행하면 다음과 같이 나와야 합니다.
>
> | ANIMAL_TYPE | NAME    | SEX_UPON_INTAKE |
>| ----------- | ------- | --------------- |
> | Cat         | Jewel   | Spayed Female   |
> | Cat         | Meo     | Neutered Male   |
> | Dog         | No name | Spayed Female   |
> 
> ※ 컬럼 이름은 일치하지 않아도 됩니다.

#### 접근 방식

> `MySQL`에서 사용할 수 있는 `IFNULL`을 사용해서 `null`이 아니면 `name`의 값을 출력하고 `null`일 경우 `No name`의 값을 출력합니다.

#### 풀이

```sql
select animal_type, IFNULL(name, "No name") as name, sex_upon_intake
from animal_ins
order by animal_id;
```

