#선택정렬이란?
#주어진 데이터 중 최소값을 찾음
# 해당 최소값을 맨 앞에 위치한 값고 ㅏ교체함
# 맨 앞을 제외한 데이터를 동일한 방법으로 반복
def selection_sort(data):
    for stand in range(len(data)-1):
        lowest = stand
        for index in range(stand+1,len(data)):
            if data[lowest]>data[index]:
                #최소값을 찾은 부분
                lowest=index
        data[lowest],data[index] = data[index],data[lowest]
    return data 