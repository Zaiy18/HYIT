with open('9-12.txt', "r", encoding='utf-8') as file:
    content = file.read()

data = [int(d) for d in content.split(',')]
data.sort()

new_content = ','.join([str(d) for d in data])
print(new_content)

with open('9-12_sort.txt', "w", encoding='utf-8') as file:
    file.write(new_content)
