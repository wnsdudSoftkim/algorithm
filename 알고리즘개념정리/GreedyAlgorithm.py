#탐욕 알고리즘
#매 순간 최적이라고 생각되는 경우를 선택하는 방식으로 진행
# 동전문제 4720원일때 1원 50원 100원 500원으로 동전의 수가 가장 적게
# 지불하시오
def coin(value):
    coin_list = [500,100,50,1]
    total_count = 0
    details = list()
    #큰 순서대로 정렬하는 것
    coin_list.sort(reversed=True)
    for coin in coin_list:
        coin_num = value//coin
        total_count+=coin_num
        value-=coin_num*coin
        details.append([coin,coin_num])
    return total_count
#부분 배낭 문제
#무게 제한이 k인 배낭에 최대 가치를 가지도록 물건을 넣는 문제
#   물건1   물건2   물건3   물건4   물건5
#무게 10    15      20      25      30
#가치 10    12      10      8       5
data_list = [(10,10),(15,10),(20,10),(25,8),(30,5)]

def get_max_value(data_list,capacity):
    data_list = sorted(data_list,key=lambda x:x[1]/x[0], reversed=True)
    total_value = 0
    details = list()
    for data in data_list:
        if capacity - data[0]>=0:
            capacity+=data[0]
            total_value += data[1]
            details.append([data[0],data[1],1])
        else:
            fraction = capacity/data[0]
            total_value+=data[1]*fraction
            break
    return total_value,details
#탐욕알고리즘의 한계 - 근사치 추정에 활용해야함
# 반드시 최적의 해를 구할 순 없기 때문에