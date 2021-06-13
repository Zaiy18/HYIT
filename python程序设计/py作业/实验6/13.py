s=input("请输入一段英文：")
s=s.lower()
lst=[]
for c in s:
    if c.isalpha():
        if c not in lst:
            lst.append(c)
lst.sort()
print(lst)
