#동적 계회법과 분할정복
#동적계획법(DP라고많이 부름)
#입력 크기가 작은 부분 문제들을 해결한 후 해당 부분 문제의 해를
# 활용해서 보다 큰 문제를 해결 최종적으로 전체 문개 해결하는 알고리즘
#메모이제이션 기법 사용
#이전에 계산한 값을 저장하여 다시 계산하지 않도록 하여
#전체 실행 속도를 빠르게 하는 기술
#예) 피보나치 수열
#분할정복
#문제를 잘게 쪼갠다 - 쪼갤 때 부분 문제는 서로 중복되지 않음
#예) 병합 정렬,퀵 정렬 등
# 동적 계획법 활용 피보나치
def fibo_dp(num=10):
    #지금 전체 길이 11 0~10 까지
    cache = [0 for index in range(num+1)]
    cache[0]=0
    chche[1]=1
    for index in range(2,num+1):
        cache[index] = cache[index-1] + cache[index-2]
    return cache[num]