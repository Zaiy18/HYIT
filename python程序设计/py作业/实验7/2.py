dic_student={}
for i in range(1,6):
    name=input("请输入第"+str(i)+"个学生的姓名:")
    age=input("请输入第"+str(i)+"个学生的年龄:")
    dic_student[name]=age
for k,v in dic_student.items():
    print("{:<3}\t{}岁".format(k,v))
