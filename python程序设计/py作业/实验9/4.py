
import csv

ls1, ls2, ls3 = [], [], []
with open('score.csv', "r", encoding='utf-8') as file:
    reader = csv.DictReader(file)
    
    for row in reader:
        print(row)
        ls1.append(int(row["程序设计"]))
        ls2.append(int(row["细胞生物"]))
        ls3.append(int(row["生理学"]))

print('程序设计课程平均成绩：{:.2f},最高分{},最低分{}'.format(sum(ls1) / len(ls1), max(ls1), min(ls1)))
print('细胞生物课程平均成绩：{:.2f},最高分{},最低分{}'.format(sum(ls2) / len(ls2), max(ls2), min(ls2)))
print('生理学课程平均成绩：{:.2f},最高分{},最低分{}'.format(sum(ls3) / len(ls3), max(ls3), min(ls3)))
