with open('zen.txt', "r", encoding='utf-8') as file:
    content = file.readlines()

words = [len(row[:-1].split()) for row in content]

print(f'行数：{len(content)}')
print(f'单词的个数：{sum(words)}')
