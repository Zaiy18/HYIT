lst_busstop=["龙江新城市","阳光广场","汉江路","嫩江路","清凉山公园","拉萨路"," 五台山","莫愁路"]
dic_estate={"龙江新城市":["白云园","腾飞园"],"阳光广场":["龙江小区","芳草园"],"汉江路":["金信花园","龙凤花园"],"嫩江路":["西城蓝湾","花开四季"]}
start=input("请输入起点(小区名):")
end=input("请输入终点(小区名):")
for k,v in dic_estate.items():
    if start in v:
        startStop=k
        break
for k,v in dic_estate.items():
    if end in v:
        endStop=k
        break
startIndex=lst_busstop.index(startStop)
endIndex=lst_busstop.index(endStop)
if startIndex>endIndex:
    print("您需要乘坐反方线线路。")
else:
    print("起点站：{}站,终点站：{}站,共{}站。".format(startStop,endStop,endIndex-startIndex))
