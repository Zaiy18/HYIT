<?php if (!defined('THINK_PATH')) exit();?><!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>教师首页</title>
<style type="text/css">
body{
	background-color:#999;}
#all{
	background-color:#090;
	width:1200px;
	height:600px;
	margin:0px 70px 0px;}
#hop{
	background-color:#030;
	font-size:36px;
	text-align:center;
	margin-top:0px;
	height:50px;
	padding-top:10px;
	}
.style1{
	font-family: "宋体";
	text-align:center;
	font-size: x-large;
	background-color:#666;
	margin-top:0px;
	padding-top:5px;}
.style2{
	text-align:right;
	margin-top:10px;
	margin-right:10px;
	color:#FFF;}
.box{
	background-color:#9F0;
	text-align:left;
	width:300px;
	margin-top:20px;
	margin-left:5px;
	padding-top:10px;
	}
#left{
	background-color:#060;
	margin-left:10px;
	margin-top:0px;
	width:350px;
	height:400px;}
#center{
	background-color:#CFF;
	width:400px;
	height:300px;
	margin-left:800px;
	position:absolute;
	top:200px;
	right:400px;
	font-size:24px;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>

<body>
<div id="all">
<div  id="hop">教师首页</div>
<div class="style1">选课系统-v1.0</div>
<div class="style2">课程列表&nbsp;&nbsp;选课信息 </div>
<div id="left">
<div class="box">
        	<h3>教师页面</h3>
               <ul>用户信息
			     <li>编号:<?php echo (session('TeatNo')); ?></li>
				 <li>姓名:<?php echo (session('TeaName')); ?></li>
				 <li>角色：教师</li>
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
    <div id="center">
    <ul>
   <li> <a href="<?php echo U('/Course/add');?>">添加课程</a></li>
  <li>  <a href="<?php echo U('/Course/coulist');?>">管理课程</a></li>
  <li> <a href="<?php echo U('/Student/stuadd');?>">添加学生</a></li>
  <li> <a href="<?php echo U('/Student/stulist');?>">管理学生</a></li>
    <li><a href="<?php echo U('/Student/stucoulist1');?>">查看学生已选课程</a>
</ul></li>
</div>
    </div>
</body>
</html>