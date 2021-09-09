from collections import defaultdict
def solution(genres, plays):
    final_dict = defaultdict(lambda:[])
    for i, genre_play_tuple in enumerate(zip(genres, plays)):
        #genre_play_tuple[0] 이건 classic 이랑 pop을 의미
        final_dict[genre_play_tuple[0]].append((genre_play_tuple[1], i))
    answer = genre_play_tuple
    return final_dict