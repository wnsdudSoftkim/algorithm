#첫번째 시도 - 100
def solution(array, commands):
    answer = []
    while commands:
        my_array=[]+array
        list_command = commands.pop(0)
        first_index = list_command[0]-1
        last_index = list_command[1]
        search_index = list_command[2]-1
        a = my_array[first_index:last_index]
        a.sort()
        answer.append(a[search_index])
    print(answer)
    return answer

solution([1, 5, 2, 6, 3, 7, 4],[[2, 5, 3], [4, 4, 1], [1, 7, 3]])
#다른사람 풀이
def solution2(array,commands):
    return list(map(lambda x:sorted(array[x[0]-1:x[1]])x[2]-1),commands))
def solution3(array, commands):
    answer = []
    for command in commands:
        i,j,k = command
        answer.append(list(sorted(array[i-1:j]))[k-1])
    return answer