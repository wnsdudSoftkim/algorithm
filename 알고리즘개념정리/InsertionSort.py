#삽입정렬
#데이터를 특정 위치에 삽입하는 것
#삽입 정렬은 두번째 인덱스부터 시작
#해당 인덱스 앞에있는! 데이터부터 비교해서 해당인덱스가 작으면
def insertion_sort(data):
    for index in range(len(data)-1):
        #두번째 인덱스부터 0까지
        #세번째 인덱스부터 0까지 ~~
        for index2 in range(index+1,0,-1):
            #앞에있는게 크면 안되니까 스왑해줌
            if data[index2] < data[index2-1]:
                data[index2],data[index2-1] = data[index2-1],data[index2]
            else:
                break
