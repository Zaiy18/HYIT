lst_info=[["李玉","男",25],["金忠","男",23],["刘妍","女",21],["莫心","女",24],["沈冲","男",28]]
name=input("请输入您要删除信息的员工姓名：")
while name!="0":
    for info in lst_info:
        if info[0]==name:
            lst_info.remove(info) 
            print("删除后的列表：{}".format(lst_info))
            break
    else:
        print("列表中不存在该员工姓名！")
    name=input("请输入您要删除信息的员工姓名：")
print("程序结束！")
