from collections import deque
def solution(priorities, location):
    answer = 0
    my_deque = deque([(v,i) for i,v in enumerate(priorities)])
    while len(my_deque):
        item = my_deque.popleft()
        if my_deque and max(my_deque)[0] > item[0]:
            my_deque.append(item)
        else:
            answer+=1
            if item[1]==location:
                break
        
    return answer