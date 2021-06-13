dic_score={"徐丽":[88,90,98,95],"张兴":[85,92,95,98],"刘宁":[89,89,90,92],"张旭":[82,86,89,90]}
for k,v in dic_score.items():
    dic_score[k].append(sum(v)/len(v))
print("姓名\t语文\t数学\t英语\t计算机\t平均分")
for k,v in dic_score.items():
    print(k,end="\t")
    for x in v:
        print(x,end="\t")
    print()
