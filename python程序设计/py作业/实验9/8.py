# 将文件内容“Hello world”中的“world”替换为“Python”。

with open('9-8.txt', "r", encoding='utf-8') as file:
    content = file.read()
    s = content.replace('world', 'Python')

with open('9-8.txt', "w", encoding='utf-8') as file:
    file.write(s)
