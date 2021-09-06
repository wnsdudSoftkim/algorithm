from itertools import combinations_with_replacement
def solution(clothes):
    answer = 0
    for (p1) in zip(clothes):
        answer+=p1

    return len(answer)
solution([["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]])