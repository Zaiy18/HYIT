lst_staff=["李梅","张富","付妍","赵诺","刘江"]
dic_award={"张富":10000,"赵诺":15000}
for x in lst_staff:
    if x in dic_award:
        print("{}年终奖：{}元".format(x,dic_award[x]))
    else:
        print("{}年终奖：{}元".format(x,5000))
