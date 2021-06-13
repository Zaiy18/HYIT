lst=[1,1]
for i in range(2,31):
    lst.append(lst[i-1]+lst[i-2])
print(lst)

