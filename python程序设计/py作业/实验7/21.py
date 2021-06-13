s= '''Whether the weather be fine, or whether the weather be not. Whether the weather be cold, or whether the weather be hot. We will weather the weather whether we like it or not.'''
s=s.lower().replace(',','').replace('.','')
lst=s.split(' ')
wordSet=set(lst)
print(wordSet)
print("一共出现了{}个单词。".format(len(wordSet)))
