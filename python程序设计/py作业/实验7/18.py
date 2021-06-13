dic_repertory={"酱油":50,"醋":60,"盐":100,"糖":120,"鸡精":20,"麻油":40}
dic_change={"酱油":100,"醋":80,"鸡精":50,"蚝油":60}
dic_repertory.update(dic_change)
dic_result=sorted(zip(dic_repertory.values(),dic_repertory.keys()),reverse=True)
print("库存最多的商品是：{}".format(dic_result[0][1]))
print("库存最少的商品是：{}".format(dic_result[-1][1]))
