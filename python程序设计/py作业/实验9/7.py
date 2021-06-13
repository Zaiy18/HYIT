with open('yzy.txt', "r", encoding='utf-8') as file:
    content = file.read()
    s = content.replace('\n', '')

print(s)

with open('yzy2.txt', "w", encoding='utf-8') as file:
    file.write(s)
