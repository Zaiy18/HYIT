lst_busstop=["龙江新城市","阳光广场","汉江路","嫩江路","清凉山公园","拉萨路","五台山","莫愁路"]        
startStop=input("请输入起点站：")
endStop= input("请输入终点站：")
startIndex=lst_busstop.index(startStop)
endIndex=lst_busstop.index(endStop)
if startIndex>endIndex:
    print("您需要乘坐反方向线路。")
else:
    print("从{}站前往{}站需要{}站。".format(startStop,endStop,endIndex-startIndex))

