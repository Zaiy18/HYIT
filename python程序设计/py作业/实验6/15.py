def sentence_reverse(s):
    lst=s.split(" ")
    return " ".join(lst[-1::-1])

s1=input("请输入一段英文：")
s2=sentence_reverse(s1)
print(s2)
