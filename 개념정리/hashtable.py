#키에 데이터를 저장하는 구조
#key를 통해 데이터를 받아올 수 있으므로 속도가 획기적으로 빨라짐
# 파이썬에서 dictionary 타입임
# hash table 만들기 0으로 초기화 해줌
hash_table = list([0 for i in range(10)])
#충돌 해결 알고리즘
#chaining 기법(MySQL table 같은 느낌)
def get_key(data):
    return hash(data)
def hash_function(key):
    return key%10
def save_data(data,value):
    index_key = get_key(data)
    hash_address = hash_function(index_key)
    #0이 아니라면 데이터가 있다는 뜻이니까
    if hash_table[hash_address] != 0:
        #기존에 있는 value를 list 형식으로 바꾸어 주고
        for index in range(len(hash_table[hash_address])):
            if hash_table[hash_address][index][0] ==index_key:
                hash_table[hash_address][index][1] =value
                return
        # 이제 부터 들어갈 데이터가 append 가 되는 것
        hash_table[hash_address].append([index_key,value])
    #데이터가 0 이면 데이터가 없는거니까
    else :
        hash_table[hash_address] = list([index_key,value])
#0  |   0 -> index_key :value (이 안에 있는 0이란 value 를 리스트로 바꿔준것)
#1  |   0 -> index_key :value
#2  |   0
#3  |   0
def read_data(data):
    index_key = get_key(data)
    hash_address = hash_function(index_key)
    if hash_table[hash_address] !=0:
        for index in range(len(hash_table[hash_address])):
            if hash_table[hash_address][index][0] ==index_key:
                return hash_table[hash_address][index][1]
        #여기서 return None이 나오는 이유는
        #반복문에서 return 이 되면 정상 수행이 된것인데
        # 반복문이 수행이 안된거니까 return None
        return None
    #데이터가 없는거니까 끝나는 거
    else:
        return None
    return hash_table[hash_address]
#Lineary Probing기법
# 저장공간의 활용도를 높임
# 데이터가 충돌이 나면 
# address를 보면서 빈공간을 찾아간다.
def get_key(data):
    return hash(data)
def hash_function(key):
    return key%10
def save_data(data,value):
    index_key = get_key(data)
    hash_address = hash_function(index_key)
    #0이 아니라면 데이터가 있다는 뜻이니까
    if hash_table[hash_address] != 0:
        #내가 넣으려는 주소부터 시작(충돌나는 주소)
        for index in range(hash_address,len(hash_table)):
            if hash_table[index] ==0:
                hash_table[index] = [index_key,value]
                return
            #만약 key부분이 동일하다고 보이면
            #다음 address를 찾는게 아니라 그 값을 업데이트를
            #해야한다고 본다
            elif hash_table[index][0] ==index_key:
                hash_table[index][1] = value
                return
    else:
        hash_table[hash_address] = [index_key,value]
    #데이터가 0 이면 데이터가 없는거니까
#0  |   0 -> index_key :value (이 안에 있는 0이란 value 를 리스트로 바꿔준것)
#1  |   0 -> index_key :value
#2  |   0
#3  |   0
def read_data(data):
    index_key = get_key(data)
    hash_address = hash_function(index_key)
    if hash_table[hash_address] !=0:
        for index in range(len(hash_table[hash_address])):
            if hash_table[hash_address][index][0] ==index_key:
                return hash_table[hash_address][index][1]
        #여기서 return None이 나오는 이유는
        #반복문에서 return 이 되면 정상 수행이 된것인데
        # 반복문이 수행이 안된거니까 return None
        return None
    #데이터가 없는거니까 끝나는 거
    else:
        return None
    return hash_table[hash_address]
