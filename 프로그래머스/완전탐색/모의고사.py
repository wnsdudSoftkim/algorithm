# 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

# 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
# 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
# 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

# 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

# 제한 조건
# 시험은 최대 10,000 문제로 구성되어있습니다.
# 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
# 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
# 입출력 예
# answers	return
# [1,2,3,4,5]	[1]
# [1,3,2,4,2]	[1,2,3]
# 입출력 예 설명
# 입출력 예 #1

# 수포자 1은 모든 문제를 맞혔습니다.
# 수포자 2는 모든 문제를 틀렸습니다.
# 수포자 3은 모든 문제를 틀렸습니다.
# 따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

# 입출력 예 #2

# 모든 사람이 2문제씩을 맞췄습니다.
#첫번째시도 - 테스트케이스만 통과
def solution(answers):
    answer = []
    #answers 최대 값 10000
    pe1 = [1,2,3,4,5] #5개
    pe2 = [2,1,2,3,2,4,2,5] #8개
    pe3 = [3,3,1,1,2,2,4,4,5,5] # 10개
    #pe1 비교
    pe1_length = len(answers)//5
    pe2_length = len(answers)//8 or 1
    pe3_length = len(answers)//10 or 1
    count = [0,0,0]
    for i in range(len(answers)):

        pe1 = pe1*pe1_length
        pe2 = pe2*pe2_length
        pe3 = pe3*pe3_length
        if pe1[i] ==answers[i]:
            count[0]+=1
        if pe2[i] ==answers[i]:
            count[1]+=1
        if pe3[i] ==answers[i]:
            count[2]+=1
    if max(count) ==count[0]:
        answer.append(1)
    if max(count) ==count[1]:
        answer.append(2)
    if max(count) ==count[2]:
        answer.append(3)
    print(answer)
    return answer
solution([1,2,3,4,5])
#두번째 시도 -100/100
def solution2(answers):
    answer = []
    #answers 최대 값 10000
    pe1 = [1,2,3,4,5] #5개
    pe2 = [2,1,2,3,2,4,2,5] #8개
    pe3 = [3,3,1,1,2,2,4,4,5,5] # 10개
    count = [0,0,0]
    for i in range(len(answers)):
        if pe1[i%5] ==answers[i]:
            count[0]+=1
        if pe2[i%8] ==answers[i]:
            count[1]+=1
        if pe3[i%10] ==answers[i]:
            count[2]+=1
    if max(count) ==count[0]:
        answer.append(1)
    if max(count) ==count[1]:
        answer.append(2)
    if max(count) ==count[2]:
        answer.append(3)
    print(answer)
    return answer