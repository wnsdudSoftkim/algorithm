#병합정렬
#재귀용법을 이용한 정렬 알고리즘
# 리스트를 절반으로 잘라 비슷한 크기의 두부분 리스트로 넣는다
# 각 부분 리스트를 재귀적으로 합병 정렬을 이용해 정렬한다
# 두 부분 리스트를 다시 하나의 정렬된 리스트로 합병한다.
def split(data):
    #5를 넣으면 인트로되서 2가되는데
    medium = int(len(data)/2)
    #슬라이싱에서 맨 뒤에 숫자 앞에만 되므로
    # 0,1 이 left 2,3,4가 right가 된다
    left = data[:medium]
    right = data[medium:]
def mergesplit(data):
    if len(data) <=1:
        return data
    medium = int(len(data)/2)
    left = mergesplit(data[:medium])
    right = mergesplit(data[medium:])
    return merge(left,right)
