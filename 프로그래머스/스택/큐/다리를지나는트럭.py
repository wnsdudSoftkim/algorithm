#첫번 째 시도 - 0/100
def solution(bridge_length, weight, truck_weights):
    answer = 0
    visit=list()
    visited=list()
    while truck_weights:
        truck = truck_weights.pop(0)
        if truck >weight:
            return
        if truck<weight and truck!=weight:
            visit.append(truck)
            if  truck_weights:
                print(visit)
                if ((weight-truck)+truck_weights[0] <=weight):
                    other_truck = truck_weights.pop(0)
                    visit.append(other_truck)
                    answer +=bridge_length*2
            answer +=bridge_length
        elif truck == weight:
            visit.append(truck)
            answer +=1
        visited.extend(visit)
    print(answer)
    return answer

#다른사람 풀이 
def solution2(bridge_length, weight, truck_weights):
    time = 0
    q = [0]*bridge_length #[0,0]
    while q:
        time+=1
        q.pop(0)
        if truck_weights:
            if sum(q)+truck_weights[0]<=weight:
                q.append(truck_weights.pop(0))
            else:
                q.append(0)
    return time
solution2(2,10,[7,4,5,6])