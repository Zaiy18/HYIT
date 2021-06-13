k=0
dic_student={}
dic_student[("一班","王建")]=[18,"172cm","80kg"]
dic_student[("一班","张云")]=[19,"165cm","55kg"]
dic_student[("二班","张秋雨")]=[18,"178cm","82kg"]
dic_student[("二班","刘欢")]=[17,"169cm","75kg"]
dic_student[("二班","姜宇")]=[19,"170cm","70kg"]
for k,v in dic_student.items():
    print("{:<5}{:<8}\t{:<4}{:<8}{:<8}".format(k[0],k[1],v[0],v[1],v[2]))
