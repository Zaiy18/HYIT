with open('website.txt ', "r", encoding='utf-8') as file:
    website = file.read().splitlines()  # .split('\n')
with open('url.txt ', "r", encoding='utf-8') as file:
    url = file.read().splitlines()  # .split('\n')
print(website)
print(url)

comb = list(zip(website, url))
print(comb)

ls = [d[0] + ',' + d[1] for d in comb]
content = '\n'.join(ls)
print(content)

with open('website_url.txt', "w", encoding='utf-8') as file:
    file.write(content)
