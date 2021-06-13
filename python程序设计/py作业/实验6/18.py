s="语文:80,数学:82,英语:90, 物理: 85,化学:88,美术:80"
lst_score=[]
for x in s.split(","):
    print(type(x))
    print(x)
    i=x.index(":")+1
    score=int(x[i:])
    lst_score.append(score)
zf=sum(lst_score)
print("总分：{}\n平均分：{:.1f}".format(zf,zf/len(lst_score)))
