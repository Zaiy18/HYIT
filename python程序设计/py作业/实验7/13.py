s=input("请输入字符串:")
myDict={}
for c in s:
    ch=c.lower()
    if ch.isalpha():
        myDict [ch]= myDict.get(ch,0)+1
print(myDict) 
