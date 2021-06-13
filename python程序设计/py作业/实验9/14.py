import csv

with open('score.txt ', "r", encoding='utf-8') as file:
    data = list(csv.reader(file))[1:]  # 去除标题行
print(data)

for d in data:
    d.append(str(round(int(d[1]) * 0.4 + int(d[2]) * 0.6)))
print(data)

data.sort(key=lambda x: x[3], reverse=True)
data.insert(0, ['学号', '平时成绩', '期末成绩', '总评成绩'])
# print(data)

with open('score_total.txt ', "w", encoding='utf-8', newline='') as file:
    writer = csv.writer(file)
    writer.writerows(data)
