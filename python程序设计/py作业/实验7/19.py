n=int(input("请设置加密位移数："))
dic_convertor={}
for i in range(26):
    ming=ord("a")+i   #ming为键的ASCII编码
    ch=ming+n
    if ch<=122:
        mi=ch       
    else:
        mi=ch-122+96
    dic_convertor[chr(ming)]=chr(mi)
for k,v in dic_convertor.items():
    print("{}:{}".format(k,v))
mingwen=input("请输入明文：")
for i in mingwen:
    print(dic_convertor[i],end="")
