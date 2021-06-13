s1=input("请输入要兑换的美元币值，以$结束：")

a=eval(s1[0:-1])

print(a,end="")

print("美元可以兑换",end="")

print(format(a*6.686,'.2f'),end="")

print("人民币",end="")

