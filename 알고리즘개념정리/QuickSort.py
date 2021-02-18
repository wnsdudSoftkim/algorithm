#분할정복의 예시로 퀵정렬
#정렬 알고리즘의 꽃
#기준점을( pivot)을 정해서 기준보다 작은 데이터는 왼 큰거는 오른쪽으로 모으는 함수를 작성
# 각 왼쪽과 오른쪽은 재귀용법을 사용해서 다시 동일 함수를 호출하여 위 작업을 반복
# 함수는 왼쪽+기준점(pivot)+오른쪽 을 리턴함
#피봇은 맨 앞 데이터를 선택
# 왼 오 나뉘어 지면 그 왼 오 중에서 pivot을 고르고 그걸 반복한다는 뜻!
def qsort(data):
    if len(data)<=1:
        return data
    left,right = list(),list()
    pivot = data[0]
    for index in range(1,len(data)):
        if pivot > data[index]:
            left.append(data[index])
        else:
            right.append(data[index])
    #밑에처럼 하면 리스트로 합쳐지는 것
    return qsort(left)+[pivot]+qsort(right)
#시간복잡도는 nlogn 병합정렬과 유사하다
