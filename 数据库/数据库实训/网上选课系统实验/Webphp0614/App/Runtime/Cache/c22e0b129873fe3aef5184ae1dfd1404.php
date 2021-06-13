<?php if (!defined('THINK_PATH')) exit();?><!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>学生首页</title>
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
	color:#FFF}
.style2{
	text-align:right;
	margin-top:10px;
	margin-right:10px;
	color:#FFF;}
#top{
	margin-top:10px;
	margin-right:10px;
	top: 10px;
	right: 10px;
	color: #F0F;
	float: right;
	}
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
#right{
	background-color:#CFF;
	text-align:center;
	height: 200px;
	width: 700px;
	margin-top:0px;
	margin-right:50px;
	color:#90F;
	float:right;
	position:absolute;
	top:250px;
	right:140px;
	}
#topnav{
	text-align:center;
	background-color:#6F6;
	font-size:24px;
	}
#man{
	font-size: 24px;
	font-style: large;
	margin-left:10px;
	height:30px;
	padding:10px;

}
#skin{
	font-size:24px;
	color:#9F0;}
#hr{
	color:#FF3;}
-->
</style>
</head>

<body>
<div id="all">
	<div id="head">
		学生首页
	</div>
    <div class="style1">选课系统-v1.0</div>
        
		<div id="top"><a href="<?php echo U('Index/index');?>">学校主页</a>
			 <a href="#">教务处</a>
			 <a href="#">学生处</a>
			 <a href="#">课程信息</a>
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
    <div id="right">
		<div id="topnav">学生选课管理
			<hr color="#3333FF">
        </div>
 	
    <div>  
    <p id="skin"><a href="<?php echo U('Student/chooseCourse');?>">进入学生选课系统</a></p>
    <p id="skin"><a href="<?php echo U('Student/stucoulist');?>">学生已选课程管理</a></p>
   </div>
</div>
</div>

</body>
</html>