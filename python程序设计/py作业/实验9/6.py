import random

data = [random.randint(10, 100) for i in range(100)]

with open('number.txt', "w", encoding='utf-8') as file:
    k = 0
    for d in data:
        file.write(str(d) + ' ')
        k = k + 1
        if k % 10 == 0:
            file.write('\n')
