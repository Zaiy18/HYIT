<?php if (!defined('THINK_PATH')) exit();?><!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>添加学生信息</title>
<style type="text/css">
<!--
body{
	background-color:#999;}
#all{
	background-color:#090;
	width:1200px;
	height:600px;
	margin:0px 70px 0px;}
#head{
	background-color: #030;
	text-align:center;
	height:50px;
	font-size:36px;
	padding:8px;
}
.style1{
	font-family: "宋体";
	text-align:center;
	font-size: x-large;
	background-color:#666;
	margin-top:0px;
	padding-top:5px;
	height:35px;
	color:#FFF;}
#left{
	background-color:#060;
	margin-left:10px;
	margin-top:70px;
	width:350px;
	height:400px;}
.box{
	background-color:#9F0;
	text-align:left;
	width:300px;
	margin-top:20px;
	margin-left:5px;
	padding-top:10px;
	}
#top{
	margin-top:10px;
	margin-right:10px;
	top: 10px;
	right: 10px;
	color: #F0F;
	float: right;
	}
#middle{
	width:400px;
	height:100px;
	margin-left:800px;
	position:absolute;
	top:200px;
	right:400px;
	}

-->
</style>
</head>

<body>
<div id="all">
	<div id="head">
		学生信息管理
	</div>
	<div class="style1">
	选课系统-v1.0</div>
	<div id="top"><a href="<?php echo U('Index/index');?>">学校主页</a>
			 <a href="#">教务处</a>
			 <a href="#">学生处</a>
			 <a href="<?php echo U('Teacher/index');?>">教师首页</a>
		</div>
 <div id="left">
<div class="box">
        	<h3>学生页面</h3>
               <ul>用户信息
			     <li>编号:<?php echo (session('StuNo')); ?></li>
				 <li>姓名:<?php echo (session('StuName')); ?></li>
				 <li>角色：学生</li>
			   </ul>
        </div>


<div class="box">
        	<h3>友情链接</h3>
            <ul>
            	<li><a href="#">使用方法</a></li>
                <li><a href="#">常见问题</a></li>
                <li><a href="#">联系我们</a></li>
            </ul>
</div>
		  <div class="box">
        	<h3>生活链接</h3>
            <ul>
            	<li><a href="http://dccsat.cduestc.cn/index/">成都学院云计算系</a></li>
            </ul>
        </div>
    </div>
<div id="middle">
<form name="form1" method="post" action="<?php echo U('/Student/add_do');?>">
	<table border="2" bordercolor="#66FF33" width="500" height="200">
  <tr>
    <td colspan="3"><div align="center">请输入学生信息</div></td>
    </tr>
  <tr>
    <td width="280">学号：</td>
    <td colspan="2"><label>
      <input type="text" name="StuNo">
    </label></td>
    </tr>
  <tr>
    <td>姓名：</td>
    <td colspan="2"><label>
      <input type="text" name="StuName">
    </label></td>
    </tr>
  <tr>
    <td>班级：</td>
    <td colspan="2"><label>
      <input type="text" name="Classno">
    </label></td>
    </tr>
 <tr>
    <td>&nbsp;</td>
    <td colspan="2">
      <label>
      <input type="submit" name="Submit" value="提交">
      </label>
      <input type="submit" name="Submit2" value="重置">
       </td>
    </tr>
</table>
</form> 
</div>
</div>

</body>
</html>