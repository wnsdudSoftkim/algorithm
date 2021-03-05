#첫번째 시도 - 10/100
#두번째 시도 0- zip 함수
def my_solution(participant, completion):
    print(zip(participant,completion))
    participant.sort()
    completion.sort()
    for i,q in zip(participant,completion):
        if i != q :
            return i
    return participant[-1]
my_solution(["mislav", "stanko", "mislav", "ana"],["stanko", "ana", "mislav"])