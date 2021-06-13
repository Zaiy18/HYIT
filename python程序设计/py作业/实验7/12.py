dic_class={"托班":["聪聪班","伶伶班","楠楠班"],"小班":["小一班","小二班"],"中班":["中一班","中二班"],"大班":["大一班","大二班"]}
dic_number={"聪聪班":26,"伶伶班":23,"楠楠班":25,"小一班":32,"小二班":31,"中一班":	33,"中二班":34,"大一班":32,"大二班":33}
dic_totle={}
for k,v in dic_class.items():
    s=0
    for x in v:
        s+=dic_number[x]
    dic_totle[k]=s    
for k,v in dic_totle.items():
    print("{}:{}人".format(k,v))
print("全园:{}人".format(sum(dic_totle.values())))
