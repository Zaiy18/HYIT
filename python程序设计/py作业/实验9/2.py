#file = open('9-2.txt', 'r', encoding='utf-8')
file = open('9-2.txt', 'r')
content = file.read()
file.close()

scores = [float(n) for n in content.split()]
print(scores)

maxScore = max(scores)
minScore = min(scores)
scores.remove(maxScore)
scores.remove(minScore)
print(scores)
print(sum(scores) / len(scores))
