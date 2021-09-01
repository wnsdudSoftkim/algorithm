# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
number_people = input()
total_time = []
answer = []
first_time = []
second_time = []
for i in range(int(number_people)):
	time = input()
	total_time.append(time)
for i in range(int(number_people)):
	first_time.append(total_time[i][:5])
for i in range(int(number_people)):
	second_time.append(total_time[i][8:])
if max(first_time) >= min(second_time):
	print("-1")
else:
	print(max(first_time)+" ~ "+min(second_time))
#- 정답