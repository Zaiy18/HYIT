import random
a=range(10,100)
lst=random.sample(a,20)
lst1=sorted(lst[:10])
lst[:10]=lst1
lst2=sorted(lst[10:],reverse=True)
lst[10:]=lst2
print(lst)
