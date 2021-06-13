lst_odd=[1,3,5,7,9]
lst_even=[2,4,6,8,10]
newlist=lst_odd.copy()
newlist.extend(lst_even)
newlist.sort()
print(newlist)
