#탐색 알고리즘
#순차탐색
#데이터가 담겨있는 리스트를 앞에서부터 하나씩 비교해서 
# 원하는 데이터를 찾는 방법
def sequential_search(data_list,search_data):
    for index in range(len(data_list)):
        if data_list[index] == search_data:
            return index
    return -1
