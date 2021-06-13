lst_sides=[3,4,5,6,6,6,4,4,3]
lst_area=[]
for i in range(0,len(lst_sides),3):
    a,b,c=lst_sides[i:i+3]
    p=(a+b+c)/2
    s=p*(p-a)*(p-b)*(p-c)
    lst_area.append(s)
print(lst_area)
