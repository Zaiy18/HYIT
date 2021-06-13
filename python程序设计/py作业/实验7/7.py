myDict={"John":"123","Marry":"111","Tommy":"123456"}
username=input('请输入用户名：')
if username not in myDict:
    print('该用户不存在！')
else:
    password=input('请输入密码：')
    if password!=myDict[username]:
        print('密码不正确！')
    else:
        print('成功登录！')
