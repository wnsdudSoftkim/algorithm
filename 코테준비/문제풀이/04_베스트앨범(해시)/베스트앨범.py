from collections import Counter
def solution(genres, plays):
    max_plays_index = plays.index(max(plays))
    plays.pop(max_plays_index)
    answer = []
    answer.append(max_plays_index)
    pop_index = genres.index(genres[max_plays_index]) # pop 인덱스를 찾는다
    
    return answer
