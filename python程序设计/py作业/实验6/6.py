lst_student=[["001","李梅",19],["002","刘祥",20],["003","张武",18]]
lst_new=[["004","刘宁",20],["006","梁峰",19]]
lst_student.extend(lst_new)
lst_student.insert(4,["005","林歌",20])
print("学号为003的学生信息：",lst_student[2])
print("所有学生的姓名：",[x[1] for x in lst_student])
print("年龄小于19的所有学生的信息：",[x for x in lst_student if x[2]>19])
