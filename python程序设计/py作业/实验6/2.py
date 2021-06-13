lst_monthdays=[31,28,31,30,31,30,31,31,30,31,30,31]
month=eval(input("请输入月份:"))
while month!=0:
    print("您好，{}月份有{}天！".format(month,lst_monthdays[month-1]))
    month=eval(input("请输入月份:"))
print("程序结束！")

