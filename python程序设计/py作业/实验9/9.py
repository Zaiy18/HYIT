file = open('yzy.txt', 'r', encoding='utf-8')
content = file.read()
file.close()

file = open('yzy3.txt', 'a', encoding='utf-8')
file.write('游子吟\n')
file.write('唐代：孟郊\n')
file.write(content)
file.close()
