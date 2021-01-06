# 주어진 배열에서 가장 많이 나온 숫자 반환
array=[1,2,3,1,25,12,5,12,3,2,32]
n= len(array)
major = -1
majorcount = 0
for i in range(0,n):
    v=array[i]
    count=0
    for j in range(0,n):
        if(array[i]==v):
            count+1
    if (count>majorcount):
        majorcount=count
        major=v
print(major)


