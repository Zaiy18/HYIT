dic_menu={"蔬菜":{"青菜":"绿色","胡萝卜":"橙色","茄子":"紫色","毛豆":"绿色"},
          "水果":{"山竹":"紫色","香蕉":"黄色","橙子":"橙色","草莓":"红色"},
          "饮料":{"椰子汁":"白色","西瓜汁":"红色","玉米汁":"黄色","葡萄汁":"紫色"}}
dic_color={}
for k,v in dic_menu.items():
     for key,value in v.items():
        dic_color[value]=dic_color.get(value,0)+1
print(dic_color)
