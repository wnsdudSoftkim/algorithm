#대표적인 정렬1 : 버블정렬
#알고리즘 연습방법
#문제를 읽고 분석한 뒤에 연습장과 펜을 이용해 알고리즘을 생각한다
# 가능한 알고리즘이 보인다면, 구현할 알고리즘을 세부항목으로 나누고
# 문장으로 세부 항목으로 나누어서 적어본다
# 코드화하기 위해 데이터 구조 또는 사용할 변수를 정리하고,
# 각 문장을 코드 레벨로 적는다
#1. 정렬 - 정해진 순서대로 나열 하는 것
#2. 버블정렬 - 두 인접한 데이터를 비교해서 앞에 있는 데이터가 크면
# 뒤에 있는 데이터와 자리를 바꾸는 알고리즘
def bubblesort(data):
    
    for index in range(len(data)-1):
        swap = False
        #-1을 하는 이유는 그 전까지 반복하려고
        for index2 in range(len(data)-index-1):
            if data[index2]>data[index2+1]:
                data[index2],data[index2+1]=data[index2+1],data[index2]
            swap=True
        if swap==False:
            break
    return data

