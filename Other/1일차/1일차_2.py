#재귀 호출 1부터 n까지의 합을 계산하는 반봅함수와 재귀함수
def sum(n):
    result=0
    for i in range(1,n):
        result+=i
    return result
def recursiveSum(n):
    if(n==1) return 1
    return n + recursiveSum(n-1)
