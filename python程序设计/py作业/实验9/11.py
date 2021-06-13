with open('zen.txt', "r", encoding='utf-8') as file:
    content = file.read().lower().replace('\n', '').replace('.', ' ')

words = content.split()
dic_fq = {}
for word in words:
    dic_fq[word] = dic_fq.get(word, 0) + 1

for fq in dic_fq.items():
    print(f'{fq[0]}:{fq[1]}')

