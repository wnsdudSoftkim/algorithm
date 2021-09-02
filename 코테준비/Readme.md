# 코딩테스트

## 코딩테스트를 위한 파이썬 문법
- 코딩테스트
    - 코딩 테스트를 위한 파이썬 문법 1

        ## round() 함수

        ```python
        round(실수형데이터,반올림하고자 하는 위치-1)
        round(123.456, 2)
        123.46

        ```

        대부분의 코딩 테스트에서는 실수형 데이터를 비교할 때 소수점 다섯 번째 자리에서 반올림한 결과가 같으면 정답으로 처리

        ## List 자료형

        - 연결 리스트 자료구조 사용
        - append(),remove() 메서드 지원

        리스트 초기화

        ```python
        >>> list = [0]*10
        >>> list
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        ```

        - N*M 크기의 2차원 리스트 초기화

        ```
        n = 4
        m = 3
        array = [[0]*m for _ in range(n)]
        array
        [[0, 0, 0], [0, 0, 0], [0, 0, 0], [0, 0, 0]]
        ```

        - 2차원 리스트 출력

        ```
        for x in array:
            for y in x:
                print(y, end=" ")
            print()
        ```

        ※ 개인적으로는 2차원 리스트를 출력할 때 위와 같은 방법을 사용하는데 더 좋은 방법이 있다면 알려주세요😉

        ### 리스트 메서드

        - append()의 시간복잡도는 *O*(1)이지만 insert()의 시간복잡도는 *O*(*N*)이므로, insert()를 남용할 시 코딩테스트에서 `시간 초과`가 뜰 수 있다.
        - remove()의 시간복잡도 역시 *O*(*N*)이므로 특정한 값을 가진 원소를 모두 제거하고 싶을 때는 아래 방법을 따르는 것이 좋다.

        ```
        >>> data = [1, 2, 1, 6, 6, 6]
        >>> remove_set = {2, 6}
        >>> result = [x for x in data if x not in remove_set]
        >>> result
        [1, 1]
        ```

        ### 연습 예제

        예시1) append(), sort()

        ```
        >>> list=[2, 8, 4, 1]
        >>> list.append(0)
        >>> list
        [2, 8, 4, 1, 0]
        >>> list.sort()
        >>> list
        [0, 1, 2, 4, 8]
        >>> list.sort(reverse = True)
        >>> list
        [8, 4, 2, 1, 0]
        ```

        예시2) reverse()

        ```
        >>> list
        [8, 4, 2, 1, 0, 7]
        >>> list.reverse()
        >>> list
        [7, 0, 1, 2, 4, 8]
        ```

        예시3) insert()

        ```
        >>> list.insert(0, 9)
        >>> list
        [9, 7, 0, 1, 2, 4, 8]
        ```

        예시4) count()

        ```
        >>> list.append(9)
        >>> list
        [9, 7, 0, 1, 2, 4, 8, 9]
        >>> list.count(9)
        2
        ```

        예시5) remove()

        ```
        >>> list.remove(0)
        >>> list
        [9, 7, 1, 2, 4, 8, 9]
        ```

    - 코딩 테스트를 위한 파이썬 문법 2

        ## Tuple 자료형

        - Tuple 자료형은 immutable data type으로 한 번 선언된 값은 변경할 수 없다.

        ```
        >>> a = (1, 2, 3, 4)
        >>> a[3]=10
        Traceback (most recent call last):
          File "<input>", line 1, in <module>
        TypeError: 'tuple' object does not support item assignment
        ```

        - 튜플을 이용하면 실수로 변경하면 안 되는 값을 변경하는 것을 방지할 수 있다.
        - 리스트에 비해 공간 효율적이며, 일반적으로 각 원소의 성질이 다를 때 사용한다.**e.g.** 다익스트라 최단 경로 알고리즘에서 `(비용, 노드 번호)`의 형태로 사용

        ## Dictionary 자료형

        - Key와 Value의 쌍을 데이터로 가지는 자료형이다.

        ```
        >>> data = dict() # data가 dictionary type임을 선언
        >>> data['사탕'] = 'Candy'
        >>> data['젤리'] = 'Jelly'
        >>> data
        {'사탕': 'Candy', '젤리': 'Jelly'}
        ```

        - 내부적으로 hash table을 이용한다.→ 데이터의 검색 및 수정에 *O*(1)이 소요된다.
        - 키 또는 데이터 값 반환

        ```
        >>> data.keys() # key 데이터만 담은 리스트 반환
        dict_keys(['사탕', '젤리'])
        >>> data.values() # value 데이터만 담은 리스트 반환
        dict_values(['Candy', 'Jelly'])
        ```

        - [dictionary 자료형 정리](https://janeljs.github.io/python/dictionaries/) (dictionary 자료형에 대하여 자세하게 정리해 두었으니 필요하신 분들은 확인하셔요🥰)

        ## Set 자료형

        - 리스트나 튜플 자료형과 다르게 순서가 없기 때문에 인덱싱으로 값을 얻을 수 없다.

        ```
        >>> data = {1,2,3,4,5}
        >>> data[2]
        Traceback (most recent call last):
          File "<input>", line 1, in <module>
        TypeError: 'set' object is not subscriptable
        ```

        - 특정 데이터가 이미 등장한 적이 있는지를 체크할 때 효과적이다.
        - dictionary와 마찬가지로 hash table을 기반으로 구현되어 있다.

        ### 집합 자료형의 연산

        ```
        >>> a = set([1,2,6,9,10])
        >>> b = set([3,5,9,10,8])
        >>> a | b # 합집합
        {1, 2, 3, 5, 6, 8, 9, 10}
        >>> a & b # 교집합
        {9, 10}
        >>> a - b # 차집합
        {1, 2, 6}
        ```

        ### 집합 메서드

        - add()

        ```
        >>> data = {1,2,3,4}
        >>> data.add(5)
        >>> data
        {1, 2, 3, 4, 5}
        ```

        - update()

        ```
        >>> data.update([7,8,9])
        >>> data
        {1, 2, 3, 4, 5, 7, 8, 9}
        ```

        - remove()

        ```
        >>> data.remove(4)
        >>> data
        {1, 2, 3, 5, 7, 8, 9}
        ```

    - 코딩 테스트를 위한 파이썬 문법 3

        ## 조건문

        ### pass 연산자

        - 아무것도 처리하지 않고 넘기고 싶을 때는 `pass`를 지정해주면 된다.

        ```
        >>> score = 90
        >>> if score >= 80: pass
        ... else: print("시험을 통과하지 못했습니다.")
        ... print('종료')
        종료

        >>> score = 60
        >>> if score >= 80: pass
        ... else: print("시험을 통과하지 못했습니다.")
        시험을 통과하지 못했습니다.
        ```

        ### 조건부 표현식(Conditional Expression)

        - 조건부 표현식을 사용하면 조건문을 한 줄에 작성할 수 있다.

        ```
        >>> score = 100
        >>> result = "Success" if score >= 80 else "Fail"
        >>> result
        'Success'
        ```

        ## 반복문

        ### 특정 인덱스 값에 해당하는 요소 제외하고 출력하기

        1. 제외하고 싶은 항목의 순서를 remove_set에 저장한다.

        ```
        >>> scores = [90, 35, 67, 79, 100]
        >>> remove_set = {3, 5} # 67, 100
        ```

        1. index값에 1을 더한 값이 remove_set에 존재한다면 `continue`를 사용해서 밑의 if 조건식의 실행을 건너뛴다.

        ```
        >>> for i in range(5):
        ...     if i+1 in remove_set:
        ...         continue
        ...     if scores[i] >= 70:
        ...         print("Student Number", i+1, ": Pass")
        ```

        1. 이렇게 하면 remove_set에 지정되지 않았으면서 70점이 넘는 학생들의 목록을 출력할 수 있다.

        ```
        # result
        Student Number 1 : Pass
        Student Number 4 : Pass
        ```

        ## 함수

        ### 함수의 구조

        - 매개변수와 return문은 존재하지 않을 수도 있다.

        ```
        def 함수명(매개변수):
            실행할 소스코드
            return 반환 값
        ```

        ### 매개변수 직접 지정

        - 매개변수를 직접 지정해서 값을 넣으면 순서와 상관없이 지정한 대로 값이 출력된다.

        ```
        >>> def printa(a,b):
        ...     print(a)
        ...
        >>> printa(4,5)
        4
        >>> printa(b=7, a=9) # 매개변수 직접 지정
        9
        ```

        ### 🌟 global 변수

        - 함수 안에서 함수 밖의 데이터를 변경하고 싶으면 함수 안에 **`global`** 키워드를 사용해주어야 한다.

        ```
        >>> a = 0
        >>> def func():
        ...     global a
        ...     a += 2
        ... for i in range(10):
        ...     func()
        ... print(a)
        20
        ```

        - 이미 a는 전역 변수로 선언되었으므로 함수 안에서도 a의 값을 수정할 수 있을 것 같지만 함수 내부에서 **`global`**로 선언해주지 않으면 `UnboundLocalError`가 발생한다.

        ```
        a = 0
        def func():
        ...     a += 2
        ... for i in range(10):
        ...     func()
        ... print(a)
        Traceback (most recent call last):
          File "<input>", line 4, in <module>
          File "<input>", line 2, in func
        UnboundLocalError: local variable 'a' referenced before assignment
        ```

        - 그러나 신기하게도 수정이 아닌 접근은 `global` 선언 없이도 가능하다.

        ```
        a = 5
        def func():
        ...     print("a의 값은", a, "입니다.")
        ... func()
        a의 값은 5 입니다.
        ```

        ### local 변수

        - 함수 내에서 전역 변수와 동일한 이름의 지역 변수를 선언해 줄 때에도 에러는 발생하지 않는다.
        - 그러나 이 경우에는 전역 변수 a에 접근하는 것이 아니라 함수가 호출되어 실행될 때마다 새로운 지역 변수가 만들어지는 것이다.
        - 지역 변수는 그 변수가 속한 함수의 밖에서는 호출될 수 없으며 함수의 실행이 종료되면 모두 삭제된다.

        ```
        >>> a = 5
        >>> def func():
        ...     a = 3
        ...     print("local a:", a)
        ... func()
        local a: 3
        >>> print("global a:", a)
        global a: 5
        ```

        ### 람다 표현식

        - 사용 방법

        ```
        lambda 매개변수1, 매개변수2, ... : 매개변수를 이용한 표현식
        ```

        ```
        print((lambda a, b: a+b)(3, 5))
        8
        ```

    - 코딩 테스트를 위한 파이썬 문법 4

        ## input()

        - 한 줄의 문자열을 입력 데이터로 받아온다.

        ```
        >>> a = list(map(int, input().split()))
        >? 7 9 4 1 3 # input 값 입력
        >>> a
        [7, 9, 4, 1, 3]
        ```

        - 위의 코드는 알고리즘 문제를 풀면서 거의 2문제당 1문제꼴로 사용했던 코드로 외워두고 사용하면 좋다.

            > list(map(int, input().split()))→ input()으로 입력 받은 문자열을→ split()을 이용하여 띄어쓰기를 기준으로 나눈 리스트로 바꾼뒤,→ map()을 이용하여 해당 리스트의 모든 원소를 정수로 바꾼 결과를→ list()를 이용하여 다시 리스트로 변환한다.

        ## sys.stdin.readline()

        - python의 input() 함수는 동작 속도가 느리기 때문에 `시간 초과`를 피하고 싶다면, **sys.stdin.readline()** 함수를 사용하는 것이 좋다.

            > sys는 System-specific parameters and functions의 약자로, python interpreter가 제공하는 변수와 함수를 직접 제어할 수 있게 해주는 모듈이다.

        - readline()으로 입력하면 엔터가 줄 바꿈 기호로 입력되기 때문에 `rstrip()`함수를 통해 공백 문자를 제거해 주어야 한다.

        ```
        >>> import sys
        >>> data = sys.stdin.readline().rstrip()
        >? Hello World!
        >>> print(data)
        Hello World!
        ```

        ## print()

        - `,` 이용: 각 항목이 띄어쓰기로 구분되어 출력된다.

        ```
        >>> a = 5
        ... def func():
        ...    print("a의 값은", a, "입니다.")
        ... func()
        a의 값은 5 입니다.
        ```

        - `+` 이용: 항목들이 띄어쓰기 없이 연결되어 출력된다.

        ```
        >>> a = 5
        ... def func():
        ...    print("a의 값은" + a + "입니다.")
        ... func()
        Traceback (most recent call last):
          File "<input>", line 4, in <module>
          File "<input>", line 3, in func
        TypeError: can only concatenate str (not "int") to str
        ```

        🌟 그러나 위의 예제에서 확인할 수 있듯이 int와 string을 연결하려고 하면 `TypeError`가 발생한다. 이를 해결하기 위해 `str()` 함수를 이용하여 int를 string으로 바꿔주면 된다.

        ```
        >>> a = 5
        ... def func():
        ...    print("a의 값은 " + str(a) + "입니다.")
        ... func()
        a의 값은 5입니다.
        ```

        ### f-string

        - 문자열 앞에 'f'를 붙여 사용한다.
        - `{}` 안에 변수를 넣으면 자료형의 변환 없이도 int와 string을 함께 쓸 수 있다.

        ```
        >>> a = 5
        >>> def func():
        ...     print(f"a의 값은 {a}입니다.")
        ... func()
        a의 값은 5입니다.
        ```

        ### 예제1) 정렬

        ```
        left = 'apple'
        result = f'|{left:<20}|' # 왼쪽 정렬
        mid = 'banana'
        result2 = f'|{mid:^20}|' # 가운데 정렬
        right = 'strawberry'
        result3 = f'|{right:>20}|' # 오른쪽 정렬
        print(result)
        print(result2)
        print(result3)
        ```

        ```
        # result
        |apple               |
        |       banana       |
        |          strawberry|
        ```

        ### 예제2) dictionary

        ```
        data = dict([('Jane', 25), ('Jisun', 26), ('Tom', 30)])
        result = f'Jane\'s age: {data["Jane"]}'print(result)
        ```

        ```
        # result
        Jane's age: 25
        ```

        ### 예제3) list 순회

        ```
        names = ['Jane', 'Jisun', 'Jiseob']
        i = 0
        for x in names:
            i += 1
            print(f'name{i}: {x}')
        ```

        ```
        # result
        name1: Jane
        name2: Jisun
        name3: Jiseob
        ```

    - 코딩 테스트를 위한 파이썬 문법 5

        # 표준 라이브러리

        - 특정한 프로그래밍 언어에서 자주 사용되는 표준 소스코드를 미리 구현해 놓은 라이브러리

            > 👉 파이썬 공식 문서에 있는 표준 라이브러리

        ## 내장 함수(Built-in functions)

        1. import 명령어 없이 사용할 수 있다.
        2. input(), print(), sum(), min(), max(), eval(), sorted(), sort() 등이 포함된다.

        ### sum()

        - iterable 객체가 입력으로 주어졌을 때 모든 원소의 합을 반환

            > iterable 객체: 반복 가능한 객체로 list, dictionary, tuple 등이 이에 해당한다.

        ### min()

        - 매개변수가 2개 이상 들어왔을 때 가장 작은 값을 반환

        ### max()

        - 매개변수가 2개 이상 들어왔을 때 가장 큰 값을 반환

        ### eval()

        - 수식이 문자열 형식으로 들어오면 수식을 계산한 결과를 반환

        ```
        >>> result = eval("100*(10%7)+5")
        >>> result
        305
        ```

        ### sorted()

        - iterable 객체가 들어왔을 때 정렬된 결과를 반환

        ```
        >>> data = sorted([5, 6, 9, 0, 3])
        >>> data
        [0, 3, 5, 6, 9]
        ```

        - key 속성을 이용해서 나이가 많은 순으로 정렬

        ```
        student_tuples = [
            ('john', 'A', 15),
            ('jane', 'B', 12),
            ('dave', 'B', 10),
        ]
        result = sorted(student_tuples, key=lambda student: student[2], reverse = True)
        print(result)
        ```

        ```
        # result
        [('john', 'A', 15), ('jane', 'B', 12), ('dave', 'B', 10)]
        ```

        ※ lambda를 처음 보신다면 [이 포스팅](https://janeljs.github.io/python/lambda/)을 참고하세요 😉※ 리스트와 같은 iterable 객체는 [sort() 메서드가 내장](https://velog.io/@janeljs/python-for-coding-test)되어 있기 때문에 sorted() 함수를 사용할 필요가 없다.

        ## itertools

        - 파이썬에서 반복되는 데이터를 처리하는 기능을 포함하고 있는 라이브러리

        ### permutations

        - iterable 객체에서 **r**개의 데이터를 뽑아 일렬로 나열하는 모든 경우를 계산

        ```
        from itertools import permutations

        fruits = ['🍏', '🍌', '🍓']
        result = list(permutations(fruits, 2))

        print(result)
        ```

        재미를 위해 과일을 넣어봤다.

        ```
        # result
        [('🍏', '🍌'), ('🍏', '🍓'), ('🍌', '🍏'),
        ('🍌', '🍓'), ('🍓', '🍏'), ('🍓', '🍌')]
        ```

        ※ permutations는 클래스이기 때문에 객체 초기화 이후에는 list로 변환하여 사용해야 한다.

        ### combinations

        - iterable 객체에서 **r**개의 데이터를 뽑아 순서를 고려하지 않고 나열하는 모든 경우를 계산

        ```
        from itertools import combinations

        fruits = ['🍏', '🍌', '🍓']
        result = list(combinations(fruits, 2))

        print(result)
        ```

        ```
        # result
        [('🍏', '🍌'), ('🍏', '🍓'), ('🍌', '🍓')]
        ```

        ### product

        - iterable 객체에서 **r**개의 데이터를 뽑아 일렬로 나열하는 모든 경우를 계산(단, 원소를 중복하여 뽑음)

        ```
        from itertools import product

        fruits = ['🍏', '🍌', '🍓']
        result = list(product(fruits, repeat = 2))
        # repeat: 중복 허용
        # 만약 repeat을 써주지 않는다면 다음과 같은 에러가 발생한다.
        # result = list(product(fruits, 2))
        # TypeError: 'int' object is not iterable

        print(result)
        ```

        ```
        # result
        [('🍏', '🍏'), ('🍏', '🍌'), ('🍏', '🍓'),
        ('🍌', '🍏'), ('🍌', '🍌'), ('🍌', '🍓'),
        ('🍓', '🍏'), ('🍓', '🍌'), ('🍓', '🍓')]
        ```

        ### combinations_with_replacement

        - iterable 객체에서 **r**개의 데이터를 뽑아 순서를 고려하지 않고 나열하는 모든 경우를 계산(단, 원소를 중복하여 뽑음)

        ```
        from itertools import combinations_with_replacement

        fruits = ['🍏', '🍌', '🍓']
        result = list(combinations_with_replacement(fruits, 2))

        print(result)
        ```

        ```
        # result
        [('🍏', '🍏'), ('🍏', '🍌'), ('🍏', '🍓'),
        ('🍌', '🍌'), ('🍌', '🍓'), ('🍓', '🍓')]
        ```

    - 코딩 테스트를 위한 파이썬 문법 6

        # heapq

        ### 힙 기능을 위한 [표준 라이브러리](https://velog.io/@janeljs/python-for-coding-test-5)

        - 다익스트라 최단 경로 알고리즘 등 우선 순위 큐 기능을 구현할 때 사용한다.
        - 코딩테스트 환경에서는 heapq가 PriorityQueue 라이브러리보다 빠르게 작동한다.

        > heapq.heappush(): 원소 삽입heapq.heappop(): 원소 삭제

        ## 힙 정렬(heap sort)

        힙 정렬은 max heap이나 min heap 트리를 이용한 정렬 방식으로 내림차순 정렬을 위해서는 **max heap**이, 오름차순 정렬을 위해서는 **min heap**이 사용된다.

        ### 오름차순 정렬

        - 파이썬에는 **최소 힙(Min Heap)**이 구현되어 있기 때문에 원소를 힙에 전부 삽입했다가 제거함으로써 오름차순으로 정렬 할 수 있다. `O(NlogN)`

        > 모든 원소를 차례대로 heap에 삽입한다.힙에 삽입된 모든 원소를 차례대로 result에 담는다.

        ```
        import heapq

        def heapsort(iterable):
            heap = []
            result = []
            for value in iterable:
                heapq.heappush(heap, value)
            for i in range(len(heap)):
                result.append(heapq.heappop(heap))
            return result

        result = heapsort([1,9,0,7,8,6,3,5])
        print(result)
        ```

        ```
        # result
        [0, 1, 3, 5, 6, 7, 8, 9] # 오름차순 정렬
        ```

        ### 내림차순 정렬

        - 파이썬에는 **최대 힙(Max Heap)**이 구현되어 있지 않기 때문에 내림차순 정렬을 위해서는 부호를 바꾼 뒤 최소 힙을 이용하여 정렬하고 다시 부호를 바꿔주어야 한다.

        > 모든 원소에 -를 붙인 값을 heap에 삽입한다.heap의 원소를 꺼낸 뒤 다시 -를 붙여 result에 담는다.

        ```
        def heapsort(iterable):
            heap = []
            result = []
            for value in iterable:
                heapq.heappush(heap, -value)
            # print(heap)
            # [-9, -8, -6, -5, -7, 0, -3, -1]
            for i in range(len(heap)):
                result.append(-heapq.heappop(heap))
            return result

        result = heapsort([1,9,0,7,8,6,3,5])
        print(result)
        ```

        ```
        # result
        [9, 8, 7, 6, 5, 3, 1, 0] # 내림차순 정렬
        ```

    - python 컴프리헨션

        # **Python comprehension**

        다른 Sequence로 부터 새로운 Sequence (Iterable Object)를 만들 수 있는 기능

        ## **List comprehension**

        ### **사용 방법**

        `[출력표현식 for 요소 in 입력Sequence [if 조건식]]`

        - 입력 Sequence는 반복이 가능한 데이터 Sequence 혹은 컬렉션
        - if 조건식 입력은 optional하다.

        ### **활용 예시**

        - 종류가 다른 데이터에서 정수 리스트만 가져오기

            `mylist = [5, 9.9, False, 'Love', 15, 100, True]
            int_data = [x for x in mylist if type(x)==int]
            print(int_data)`

            `# Result
            [5, 15, 100]`

        - 응용하기

            `mylist = [5, 9.9, False, 'Love', 15, 100, True]
            int_data = [x for x in mylist if type(x)==int]
            int_square_data = [y * y for y in mylist if type(y)==int]
            boolean_data = [z for z in mylist if type(z)==bool]
            print(int_data)
            print(int_square_data)
            print(boolean_data)`

            `# Result
            [5, 15, 100]
            [25, 225, 10000]
            [False, True]`

        - List comprehension을 사용해서 1~20까지의 숫자 중 3으로 나누어 떨어지는 수만 출력하기

            `answer = [x for x in range(1, 21) if x % 3 == 0]
            print(answer)`

            `# Result
            [3, 6, 9, 12, 15, 18]`

        - List comprehension을 사용해서 1~20까지의 숫자 중 3 또는 7로 나누어 떨어지지 않는 수만 출력하기

            `answer = [x for x in range(1, 21) if (x % 3 != 0 and x % 7 != 0)]
            print(answer)`

            `# Result
            [1, 2, 4, 5, 8, 10, 11, 13, 16, 17, 19, 20]`

        ## **Set comprehension**

        ### **사용 방법**

        `{출력표현식 for 요소 in 입력Sequence [if 조건식]}`

        - 입력 Sequence로부터 조건에 맞는 새로운 Set 컬렉션 반환
        - if 조건식 입력은 optional하다.

        ### **활용 예시**

        `int_data = [1, 1, 2, 2, 2, 3, 3, 4, 6, 7, 8, 8, 9]
        data_set = {num for num in int_data}
        print(data_set)

        data_set_under_condition = {num for num in int_data if num > 3}
        print(data_set_under_condition)

        square_data_set = {num * num for num in int_data if num > 3}
        print(square_data_set)`

        `# Result
        {1, 2, 3, 4, 6, 7, 8, 9} # 집합 출력
        {4, 6, 7, 8, 9} # 조건에 맞는 집합 출력
        {64, 36, 16, 49, 81} # 제곱된 수로 구성된 집합 출력`

        ## **Dictionary comprehension**

        ### **사용 방법**

        `{Key:Value for 요소 in 입력Sequence [if 조건식]}`

        - 입력 Sequence로부터 조건에 맞는 새로운 Set 컬렉션 반환
        - if 조건식 입력은 optional하다.

        ### **활용 예시**

        `id_name = {1: 'Dave', 2: 'David', 3: 'Anthony', 4: 'Jane'}
        print(id_name.items())

        # 아이디가 2이상인 데이터를 이름:아이디 형식으로 새로운 set 만들기
        name_id = {val:key for key,val in id_name.items() if key > 2}
        print(name_id)

        # key 해싱 (2n-1)
        name_id = {key * 2 - 1:val for key,val in id_name.items()}
        print(name_id)`

        `# Result
        dict_items([(1, 'Dave'), (2, 'David'), (3, 'Anthony'), (4, 'Jane')])
        {'Anthony': 3, 'Jane': 4}
        {1: 'Dave', 3: 'David', 5: 'Anthony', 7: 'Jane'}`

    - python lambda 함수

        # **lambda() 함수**

        - 함수를 생성할 때 사용하는 예약어 (=def)
        - 함수를 한 줄로 간결하게 만들 때 사용💡 lambda 예약어로 만든 함수는 return 명령어가 없어도 결과값을 돌려준다.

        ## **사용 방법**

        `lambda 매개변수1, 매개변수2, ... : 매개변수를 이용한 표현식`

        ## **활용 예시**

        - 예시 1

            `>>> add = lambda a, b: a+b
            >>> result = add(3, 5)
            >>> print(result)
            8`

        - 예시 2

            `>>> arr = [[1,2,9],[8,5,6],[7,8,9]]
            >>> answer = max(arr, key=lambda x: x[1])[2]
            # 2차원 배열에서 열의 두번째 값이 가장 큰 원소를 찾고,
            # 그 값의 3번째 값 반환
            >>> print(answer)
            9`

        - 예시 3

            `>>> names = ['Jane', 'Jisun', 'Jiseob']
            >>> longest_name = max(names, key=lambda x: len(x))
            >>> print(longest_name)
            Jiseob`

        - 예시 4

            `>>> keys = [{'key': 5}, {'key': 10}, {'key': 7}, {'key': 8}]
            >>> keys
            [{'key': 5}, {'key': 10}, {'key': 7}, {'key': 8}]
            >>> keys.sort(key = lambda x:x['key'])
            >>> keys
            [{'key': 5}, {'key': 7}, {'key': 8}, {'key': 10}]
            # keys 리스트를 'key'들의 value를 기준으로 정렬`

        - 예시 5

            `>>> student_tuples = [
            ...     ('john', 'A', 15),
            ...     ('jane', 'B', 12),
            ...     ('dave', 'B', 10),
            ... ]
            >>> sorted(student_tuples, key=lambda student: student[2])   
            # 나이를 기준으로 정렬 
            [('dave', 'B', 10), ('jane', 'B', 12), ('john', 'A', 15)]`

    -
