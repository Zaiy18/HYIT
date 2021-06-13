dic_house={"001":["3室1厅","68.69平方米","南北","简装","37124元/平方米","35人"],"002":["2室2厅","87.16平方米","南西","精装","37375元/平方米","148人"],"003":["3室1厅","61.72平方米","南北","精装","37266元/平方米","146人"],"004":["2室2厅","68.18平方米","南北","精装","68496元/平方米","79人"],"005":["2室2厅","71.67平方米","南","简装","33487元/平方米","105人"],"006":["3室1厅","84.78平方米","南北","简装","51782元/平方米","34人"]}
lst_result1=sorted(dic_house.items(),key=lambda x:int(x[1][4][:-5]))
print("单价最低的三套房源：")
for i in range(3):
    print("房源编号：{}，房源信息：{}".format(lst_result1[i][0],lst_result1[i][1]))
lst_result2=sorted(dic_house.items(),key=lambda x:int(x[1][5][:-1]),reverse=True)
print("人气最高的三套房源：")
for i in range(3):
      print("房源编号：{}，房源信息：{}".format(lst_result2[i][0],lst_result2[i][1]))
