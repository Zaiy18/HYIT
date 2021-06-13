cost = []
with open('a.txt', 'r') as file:
    print(file.readlines())
    for row in file.readlines():
        ls = row.split(' ')
        cost.append(int(ls[1]) * int(ls[2]))
print(sum(cost))
