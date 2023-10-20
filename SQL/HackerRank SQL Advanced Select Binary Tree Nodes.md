# HackerRank [Binary Tree Nodes](https://www.hackerrank.com/challenges/binary-search-tree-1/problem?isFullScreen=true)

### 난이도 Medium

---

#### 문제

>You are given a table, *BST*, containing two columns: *N* and *P,* where *N* represents the value of a node in *Binary Tree*, and *P* is the parent of *N*.
>
>![img](https://s3.amazonaws.com/hr-challenge-images/12888/1443818507-5095ab9853-1.png)
>
>Write a query to find the node type of *Binary Tree* ordered by the value of the node. Output one of the following for each node:
>
>- *Root*: If node is root node.
>- *Leaf*: If node is leaf node.
>- *Inner*: If node is neither root nor leaf node.
>
>**Sample Input**
>
>![img](https://s3.amazonaws.com/hr-challenge-images/12888/1443818467-30644673f6-2.png)
>
>**Sample Output**
>
>```
>1 Leaf
>2 Inner
>3 Leaf
>5 Root
>6 Leaf
>8 Inner
>9 Leaf
>```
>
>
>**Explanation**
>
>The *Binary Tree* below illustrates the sample:
>
>![img](https://s3.amazonaws.com/hr-challenge-images/12888/1443773633-f9e6fd314e-simply_sql_bst.png)

#### 접근 방법

>`Table`의 `P`의 값이 `NULL`일 경우에는 `Root`의 값을 가지고 `N`의 값이 `P`의 값에 포함되지 않을 경우 `Leaf`의 값을 가지게 되고 둘 다 아닐 경우에는 즉, `N`의 값이 `P`에 있으면  `Inner`의 값을 가지게 됩니다.
>
>그걸 비교하기 위해 `left join`을 사용하여 `Inner`값을 가지면 숫자로 표기되고 `null`인 경우에는 `Leaf`의 값을 가지는 컬럼을 추가해줍니다. 

#### 풀이

```sql
select distinct a.n
     , case when a.p is null then 'Root' 
            when b.p is null then 'Leaf'
            else 'Inner' end
from bst a
     left join bst b 
     on a.n = b.p 
order by a.n;
```

