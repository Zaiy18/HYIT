import matplotlib.pyplot as plt
import matplotlib
# 添加
def add_stu():
    print('*********添加学员**********')
    student_id = input('请输入学员学号：')
    name = input('请输入学员姓名：')
    age = input('请输入学员的年龄：')
    sex = input('请输入学员性别（男/女）：')
    banji = input('请输入班级：')
    zhuanyeke1 = input('专业课1：')
    zhuanyeke2 = input('专业课2：')
    zhuanyeke3 = input('专业课3：')
    zhuanyeke4 = input('专业课4：')
    zhuanyeke5 = input('专业课5：')
    student = [student_id, name, age, sex, banji, zhuanyeke1, zhuanyeke2, zhuanyeke3, zhuanyeke4, zhuanyeke5]
    student_list.append(student)


# 查询学生信息：
def query_stu(type):
    # print('*************%s学员**************' % type)
    # print('1.查询所有学员')
    # print('2.输入学员姓名查询 ')
    # num = int(input('选择操作：'))
    # if num == 1:
    #     for x in range(0, len(student_list)):

    #
    #
    #         print('学号：%s 姓名：%s 年龄：%s 性别：%s 班级：%s 专业课1：%s 专业课2：%s 专业课3：%s 专业课4：%s 专业课5：%s ' % (
    #         student_id, name, age, sex, banji, zhuanyeke1, zhuanyeke2, zhuanyeke3, zhuanyeke4, zhuanyeke5))
    #     return student
    # else:
    num=input('1.输入学生姓名查询\n2.输入学生学号查询')
    num=int(num)
    if num == 1:
        for x in range(0, len(student_list)):
            student = student_list[x]
            student_id = student[0]
            name = student[1]
            age = student[2]
            sex = student[3]
            banji = student[4]
            zhuanyeke1 = student[5]
            zhuanyeke2 = student[6]
            zhuanyeke3 = student[7]
            zhuanyeke4 = student[8]
            zhuanyeke5 = student[9]
        name_1 = input('请输入学员姓名：')
        while 1:
            rs = False
            for student in student_list:
                if student[1] == name_1:
                    print('学号：%s 姓名：%s 年龄：%s 性别：%s 班级：%s 专业课1：%s 专业课2：%s 专业课3：%s 专业课4：%s 专业课5：%s ' % (student_id, name, age, sex, banji, zhuanyeke1, zhuanyeke2, zhuanyeke3, zhuanyeke4, zhuanyeke5))
                    rs = True
            if rs == False:
                name_1 = input('未找到学生，请重输：')
            else:
                break
    else:
        for x in range(0, len(student_list)):
            student= student_list[x]
            student_id = student[0]
            name = student[1]
            age = student[2]
            sex = student[3]
            banji = student[4]
            zhuanyeke1 = student[5]
            zhuanyeke2 = student[6]
            zhuanyeke3 = student[7]
            zhuanyeke4 = student[8]
            zhuanyeke5 = student[9]
        student_id_1=input('请输入学生学号：')
        while 1:
            rs = False
            for student in student_list:
                if student[0] == student_id_1:
                    print('学号：%s 姓名：%s 年龄：%s 性别：%s 班级：%s 专业课1：%s 专业课2：%s 专业课3：%s 专业课4：%s 专业课5：%s ' % (student_id, name, age, sex, banji, zhuanyeke1, zhuanyeke2, zhuanyeke3, zhuanyeke4, zhuanyeke5))
                    rs = True
            if rs == False:
                student_id_1 = input('未找到学员，请重输：')
            else:
                break

        return student


# 封装判断选择序号是否符合范围的函数
# 带返回值的函数，函数执行完会返回一个结果，可以声明变量接受这个结果
def select_num(type):
    index = input('请选择要%s的学员序号：' % type)
    index = int(index)
    while index not in range(0, len(student_list)):
        index = input('选择的学员不存在，请重选：')
        index = int(index)
    # 返回选择的序号
    return index

#	按班级查询学生信息
def all_stu():
    banji_1 = input('请输入想查询的班级：')
    for x in range(0, len(student_list)):
        student = student_list[x]
        student_id = student[0]
        name = student[1]
        age = student[2]
        sex = student[3]
        banji = student[4]
        zhuanyeke1 = student[5]
        zhuanyeke2 = student[6]
        zhuanyeke3 = student[7]
        zhuanyeke4 = student[8]
        zhuanyeke5 = student[9]
        if student[4] == banji_1:
            print('学号：%s 姓名：%s 年龄：%s 性别：%s 班级：%s 专业课1：%s 专业课2：%s 专业课3：%s 专业课4：%s 专业课5：%s ' %(student_id, name, age, sex, banji, zhuanyeke1, zhuanyeke2, zhuanyeke3, zhuanyeke4, zhuanyeke5))



# 修改
def alter_stu():
    if len(student_list) == 0:
        print('没有学员信息，无法进行修改操作！')
        # 强制结束函数的执行，return下面的代码都不会再执行
        return
    query_stu('修改')
    index = int(select_num('修改'))
    student = student_list[index]
    new_name = input('请输入修改后的姓名（%s）：' % student[0])
    new_age = input('请输入修改后的年龄（%s）:' % student[1])
    new_sex = input('请输入修改后的性别（%s）:' % student[2])
    new_phone = input('请输入修改后的手机号（%s）:' % student[3])
    student[0] = new_name
    student[1] = new_age
    student[2] = new_sex
    student[3] = new_phone
    print('修改学员成功')

#计算每位学生的总分和平均分
def  allandavg():

    for x in range(0, len(student_list)):
        student = student_list[x]
        student_id = student[0]
        name = student[1]
        age = student[2]
        sex = student[3]
        banji = student[4]
        zhuanyeke1 = student[5]
        zhuanyeke2 = student[6]
        zhuanyeke3 = student[7]
        zhuanyeke4 = student[8]
        zhuanyeke5 = student[9]
        sum=int(zhuanyeke1)+int(zhuanyeke2)+int(zhuanyeke3)+int(zhuanyeke4)+int(zhuanyeke4)+int(zhuanyeke5)
        pingjun=int(sum)/5
        print('学号：%s 姓名：%s 年龄：%s 性别：%s 班级：%s 总分: %s 平均分: %s ' % (student_id, name, age, sex, banji, sum, pingjun))
    return student
# 删除
def dele_stu():
    query_stu('删除')
    index = select_num('删除')
    rs = input('是否真的删除（y/n）:')
    if rs == 'y':
        student_list.pop(index)
        print('删除成功')
    else:
        print('删除数据操作已取消！')


# 存储至本地文件
def save_data():
    file_handle = open('2.csv', 'w')
    for student in student_list:
        # 把列表中的数据用 , 分开拼接为一个字符串
        s = ','.join(student)
        file_handle.write(s)
        file_handle.write('\n')
    file_handle.close()

def bujige():
    bujige1 = 0
    bujige2 = 0
    bujige3 = 0
    bujige4 = 0
    bujige5 = 0
    for x in range(0, len(student_list)):

        student = student_list[x]
        student_id = student[0]
        name = student[1]
        age = student[2]
        sex = student[3]
        banji = student[4]
        if  banji=='1181':
            zhuanyeke1 = student[5]
            if int(zhuanyeke1)<60:
                bujige1=bujige1+1
            zhuanyeke2 = student[6]
            if int(zhuanyeke2)<60:
                bujige2=bujige2+2
            zhuanyeke3 = student[7]
            if int(zhuanyeke3)<60:
                bujige3=bujige3+1
            zhuanyeke4 = student[8]
            if int(zhuanyeke4)<60:
                bujige4=bujige4+1
            zhuanyeke5 = student[9]
            if int(zhuanyeke5)<60:
                bujige5=bujige5+1
    print('专业课1：%s 专业课2：%s 专业课3：%s 专业课4：%s 专业课5：%s' % (bujige1, bujige2, bujige3, bujige4, bujige5))
    bujige1 = 0
    bujige2 = 0
    bujige3 = 0
    bujige4 = 0
    bujige5 = 0
    for x in range(0, len(student_list)):

        student = student_list[x]
        student_id = student[0]
        name = student[1]
        age = student[2]
        sex = student[3]
        banji = student[4]
        if banji == '1182':
            zhuanyeke1 = student[5]
            if int(zhuanyeke1) < 60:
                bujige1 = bujige1 + 1
            zhuanyeke2 = student[6]
            if int(zhuanyeke2) < 60:
                bujige2 = bujige2 + 2
            zhuanyeke3 = student[7]
            if int(zhuanyeke3) < 60:
                bujige3 = bujige3 + 1
            zhuanyeke4 = student[8]
            if int(zhuanyeke4) < 60:
                bujige4 = bujige4 + 1
            zhuanyeke5 = student[9]
            if int(zhuanyeke5) < 60:
                bujige5 = bujige5 + 1
    print('专业课1：%s 专业课2：%s 专业课3：%s 专业课4：%s 专业课5：%s' % (bujige1, bujige2, bujige3, bujige4, bujige5))
# 引入python内置函数os
import os


# 读取文件内容
def read_data():
    # 判断文件是否存在，如果存在，在做打开文件的操作
    # 如果文件存在返回true，否则返回False
    rs = os.path.exists('1.csv')
    if rs == True:
        # 1，打开文件
        file_handle = open('1.csv', mode='r')
        # 2.读取所有行
        contents = file_handle.readlines()
        # 3.取出每一个姓名
        for msg in contents:
            # 去除\n
            msg = msg.strip('\n')
            # 使用 空格分割字符串
            student = msg.split(',')
            # 将小列表添加到大列表中
            student_list.append(student)
        #print(student_list)
        file_handle.close()



        #查询班级信息
def chaban():
    for x in range(0, len(student_list)):
        student = student_list[x]
        student_id = student[0]
        name = student[1]
        age = student[2]
        sex = student[3]
        banji = student[4]
        zhuanyeke1 = student[5]
        zhuanyeke2 = student[6]
        zhuanyeke3 = student[7]
        zhuanyeke4 = student[8]
        zhuanyeke5 = student[9]
        banji_1 = input('请输入想查询的班级：')
    while 1:
        rs = False
        for student in student_list:
            if student[4] == banji_1:
                print('学号：%s 姓名：%s 年龄：%s 性别：%s 班级：%s 专业课1：%s 专业课2：%s 专业课3：%s 专业课4：%s 专业课5：%s ' % (
                student_id, name, age, sex, banji, zhuanyeke1, zhuanyeke2, zhuanyeke3, zhuanyeke4, zhuanyeke5))
                rs = True
        if rs == False:
            banji_1 = input('未找到学员，请重输：')
        else:
            break

    return student


import numpy as np

from numpy import *
def zhuzhuangtu():
    str=input('班级平均分:a\n平均分和总平均分:b')
    # -*- coding: utf-8 -*-
    if str=='a':
        data = [260, 240]
        labels = ['1181', '1182']
        plt.bar(range(len(data)), data, tick_label=labels)
        plt.show()

    else:
        size = 6
        x = np.arange(size)
        a = [50, 40, 90, 80, 100, 340]
        b = [30, 80, 60, 84, 55, 240]
        labels = ['clss1', 'clss2', 'class3', 'class4', 'class5', 'all']

        total_width, n = 0.8, 3
        width = total_width / n
        x = x - (total_width - width) / 2

        plt.bar(x, a, width=width, label='1181',tick_label=labels)
        plt.bar(x + width, b, width=width, label='1182')


        plt.legend()
        plt.show()















def show_menu():
    print("    +－－－－－－－－－－－－－－－－－－－－－+")
    print("    |      学生成绩信息管理系统             |")
    print("    |         计算机1181 章磊              |")
    print("    +－－－－－－－－－－－－－－－－－－－－－ +")
    print("    |        1 录入学生信息                |")
    print("    |        2 保存学生信息                |")
    print("    |        3 载入学生信息                |")
    print("    |        4 删除学生信息                |")
    print("    |        5 计算总分和平均分            |")
    print("    |        6 查询学生信息                |")
    print("    |        7 查询班级信息                |")
    print("    |        8 班级成绩的柱状图显示         |")
    print("    |        9 统计班级不及格人数           |")
    print("    |        0 退出系统                    |")
    print("    +－－－－－－－－－－－－－－－－－－－－－+")



# 声明一个大列表，存放学员姓名
student_list = []#!
read_data()
while 1:
    show_menu()
    numa = input('请选择您需要执行的操作(0 退出）')
    numa = int(numa)
    while numa not in range(0, 10):
        numa = int(input('您选择的选项不存在，请重选：'))
    if numa == 1:
        #录入学生信息
        add_stu()
    elif numa == 2:
        #保存学生信息
        save_data()
    elif numa == 3:
        read_data()
    elif numa == 4:
        # 删除学员
        print('1.通过序号删除学员')
        print('2.删除全部学员')
        print('3.根据学员姓名删除')
        numb = input('请选择操作：')
        numb = int(numb)
        while numb not in range(1, 4):
            numb = int(input('所输选项不存在，请重输：'))
        if numb == 1:
            dele_stu()
        elif numb == 2:
            rs = input('是否真的删除（y/n）:')
            if rs == 'y':
                student_list.clear()
                print('删除成功')
            else:
                print('删除数据操作已取消！')
        else:
            name = input('请输入想要删除学员的姓名：')
            rs = input('是否真的删除（y/n）:')
            if rs == 'y':
                while 1:
                    rs = False
                    for student in student_list:
                        if student[0] == name:
                            student_list.remove(student)
                            print(student_list)
                            print('删除成功')
                            rs = True
                    if rs == False:
                        # print('未找到请重新输入')
                        name = input('未找到学员，请重输：')
                    else:
                        break
            else:
                print('删除数据操作已取消！')
    elif numa == 5:
        allandavg()
    elif numa == 6:
        query_stu(type)
    elif numa == 7:
        all_stu()
    elif numa == 8:
        zhuzhuangtu()
    elif numa == 9:
        bujige()


    else:
        print('退出程序')
        break
