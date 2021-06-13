s='''When in the Course of human events, it becomes necessary for one people to dissolve the political bands which have connected them with another, and to assume among the Powers of the earth, the separate and equal station to which the Laws of Nature and of Nature's God entitle them, a decent respect to the opinions of mankind requires that they should declare the causes which impel them to the separation.'''
s=s.lower().replace(',','').replace('.','')
lst=s.split(' ')
dic={}
for word in lst:
    dic[word]=dic.get(word,0)+1
print(dic)
newlst=[(v,k) for k,v in dic.items()]
newlst.sort()
print(newlst[-1:-6:-1])
