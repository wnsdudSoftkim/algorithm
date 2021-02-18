#재귀용법
#쉬운 알고리즘일때 재귀용법을 많이 사용하기도 함
#팩토리얼
def factorial(n):
    if n>1:
        return n*factorial(n-1)
    else:
        return n
재귀 호출의 일반적인 형태1
def ex1(입력):
    if 입력>일정값:
        return ex1(입력-1)
    else:
        return 일정값
#일반적인 형태2
def ex2(입력):
    if 입력 <=입력값:
        return 결과값
    ex2(입력보다 작은값)
    return 결과값
#재귀용법을 활용해서 1부터 num까지 곱이 출력되게 만들기
def multiple(num):
    return_value = 1
    for index in range(1,num+1):
        return_value = return_value*index
    return return_value
def multiple1(num):
    if num<=1:
        return num
    else:
        return num*multiple(num-1)
#숫자가 들어있는 리스트가 주어졌을때 리스트의 합을 리턴하는 함수
import random
data = random.sample(range(100),10)
def sum_list(data):
    if len(data)==1:
        return data[0]
    return data[0]+sum_list(data[1:])
#위에 두가지 예제는 리스트나 범위를 하나씩 줄여나감
#단어가 주어졌을때 거꾸로 읽어도 같은 단어를 판별하는 함수
#e내가 짠 함수
def recur(data):
    data_list = data.split()
    if len(data_list)<=1:
        return True
    if data_list[0]==data_list[len(data_list)-1]:
        return recur(data_list[1:len(data_list)-1])
recur('level')
#강사님이 짠 함수
def palindrome(string):
    if len(string)<=1:
        return True
    if string[0]==string[-1]:
        return palindrome(string[1:-1])
    else:
        return False
#내가 부족했던 점:
#python string은 배열처럼 사용이 가능하다.
#배열-1의 개념을 생각하지 못했음.
#정수 n에서 홀수이면 3*n+1을 하고 짝수이면 n을 2로나눈다
# n이 1이 될때까지 이 과정을 반복한다.
#내가 짠 함수
def mypalindrome(value):
    if value ==1:
        return True
    if value%2==0:
        mypalindrome(value/2)
    if value%2==1:
        mypalindrome((value*3)+1)
#정수 n이 입력으로 주어졌을 때, n을 1,2,3으로 나타낼 수 있는
#방법의 수를 구하시오
#1,2,3,4,5일때 연습장에 풀어본 결과 1,2,4,7,13 방법의 수가 나왔다
#여기서 규칙을 발견하면 n이 4 이상일때 그 앞에 3개의 방법의 수를 더하는 것
def func(data):
    if data==1:
        return 1
    elif data==2:
        return 2
    elif data==3:
        return 3
    return func(data-1)+func(data-2)+func(data-3)
