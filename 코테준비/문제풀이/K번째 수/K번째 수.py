def solution(array, commands):
    answer= []
    my_array = []
    while len(commands)>0:
        item = commands.pop(0)
        start = item[0]-1
        last = item[1]
        index = item[2]-1
        my_array = array[start:last]
        my_array.sort()
        answer.append(my_array[index])
    return answer