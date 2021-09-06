#
from itertools import combinations
def solution(participant, completion):
    answer= ""
    my_list= set(participant)
    my_completion  = set(completion)
    if len(my_list)==len(completion):
        for i in range(len(participant)):
            
            if participant.count(participant[i]) >1:
                answer = participant[i]
            else :
                pass
    else :
        answer = "".join(my_list - my_completion)
    return answer