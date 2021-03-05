#첫번째 시도 - 66.7/100
# 정확성 62.5
# 효율성 4.2
# 시간 복잡도 n
def solution(phone_book):
    list_first = phone_book[0]
    list_first_len = len(list_first)
    list_other = phone_book[1:]
    answer=True
    for list_index in list_other:
        list_cut_index = list_index[:list_first_len]
        if list_cut_index==list_first:
            answer=False
            break
    print(answer)
    return answer
    
# 두번째 시도 - 66.7/100
# 시간복잡도 n
def solution2(phone_book):
    answer=True
    list_first = phone_book[0]
    del phone_book[0]
    for list_index in phone_book:
        if list_first == list_index[:len(list_first)]:
            answer = False
            break
    return 
# 세번째 시도 - 62.5/100
#시간복잡도 log n
def solution3(phone_book):
    answer=True
    list_first = phone_book[0]
    del phone_book[0]
    while phone_book:
        loop_list=phone_book[0]
        loop_list_string = loop_list[:len(list_first)]
        if list_first !=loop_list_string:
            del phone_book[0]
        else:
            answer=False
            break
    return answer
#다른사람 풀이
# zip()으로 앞뒤갚 비교....
def solution4(phone_book):
    phone_book.sort()
    for p1,p2 in zip(phone_book,phone_book[1:]):
        print(p1)
        if p2.startswith(p1):
            return False
    return True
solution4(["119", "97674223", "1195524421"])


