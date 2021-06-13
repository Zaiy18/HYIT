import os
ad ='/Users/zhanglei/Downloads/罗密欧与朱丽叶(英文版)莎士比亚.txt'
isFile = os.path.isfile(ad)  # 用于判断用户输入文件地址是否正确
if isFile:

    # 正确分解出单词列表

    f = open(ad, "r")
    file = f.read()
    words = file.split()

    for i in range(len(words)):  # 去除标点符号(基础有限用了笨方法)
        words[i] = words[i].replace(',', '')
        words[i] = words[i].replace('.', '')
        words[i] = words[i].replace('?', '')
        words[i] = words[i].replace("'", '')
        words[i] = words[i].replace("--", ' ')
        words[i] = words[i].replace(";", '')
        words[i] = words[i].replace("[", '')
        words[i] = words[i].replace("]", '')
        words[i] = words[i].replace("-", '')
        words[i] = words[i].replace("!", '')
        # print(words[i])
    print("单词列表:", words)
    print("\n\n********************************************************\n\n")
    print("\n\n********************************************************\n\n")

    # 正确得到单词频次字典

    word_time = dict()
    for word in words:
        word_time.setdefault(word, 0)  # setdefault:如果键不存在于字典中，将会添加键并将值设为默认值
        word_time[word] += 1
    print("单词频次:", word_time)
    print("\n\n********************************************************\n\n")
    print("\n\n********************************************************\n\n")

    # 按单词频次逆序输出结果

    word_time_sorted = sorted(word_time.items(), key=lambda word_time: word_time[1],
                              reverse=True)  # sorted() 函数对所有可迭代的对象进行排序操作
    bword_time_sorted = []
    for i in word_time_sorted:
        bword_time_sorted.append((i[0], i[1]))
    print("按单词频次逆序输出：", tuple(bword_time_sorted))


else:
    print("您所输入的地址错误。")
