dic_country={"China":"Beijing","America":"Washington","Norway":"Oslo","Japan":"Tokyo","Germany":"Berlin","Canada":"Ottawa","France":"Paris","Thailand":"Bangkok"}
country=input("请输入国家名：").lower().capitalize()
if country in dic_country:
    print("首都名：{}".format(dic_country[country]))
else:
    print("未查询到该国家名！")
