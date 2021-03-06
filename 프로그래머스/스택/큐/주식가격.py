# 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.

# 제한사항
# prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
# prices의 길이는 2 이상 100,000 이하입니다.
# 입출력 예
# prices	return
# [1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
# 입출력 예 설명
# 1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
# 2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
# 3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
# 4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
# 5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.
#첫번째시도 - 테스트케이스만 통과 효율성:0
def solution(prices):
    return loop(prices,[])
def loop(my_prices,answer):
    answer=[]+answer
    count=0
    if not my_prices:
        return answer
    else:
        first_price = my_prices[0]
        for i in range(len(my_prices)-1):
            if first_price<=my_prices[i]:
                count+=1
        answer.append(count)
        print(count)
        del my_prices[0]
        print(answer)
        return loop(my_prices,answer)
solution([1, 2, 3, 2, 3])
#다른사람 풀이 - 나도 처음에 이렇게 했는데 왜 틀렷지?
def solution2(prices):
    answer = [0]*len(prices)
    for i in range(len(prices)-1):
        for j in range(i,len(prices)-1):
            if prices[i]>prices[j]:
                break
            else:
                answer[i]+=1
    return answer