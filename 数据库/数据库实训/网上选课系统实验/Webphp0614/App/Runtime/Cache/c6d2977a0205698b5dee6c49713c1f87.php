<?php if (!defined('THINK_PATH')) exit();?><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>选课系统</title>
<link rel="stylesheet" type="text/css" href="/Webphp/Public/css/index.css" />

<style type="text/css">
body{
	background-color:#999;
	}
#all{
	background-color:#9F9;
	width:1200px;
	height:600px;
	margin: 0px 80px 0px;}

#header{
	background-color:#060;
	padding:1px 1px 1px;
	text-align:center;
	font-size:24px;
	color:#FFF;
	}
#left{
	background-color:#060;
	height: 300px;
	width: 300px;
	position: absolute;
	left: 100px;
	top: 150px;
	}

#topnav{
	text-align:right;
	text-color:#F63;}
#middle{
	text-align: center;
	position: absolute;
	left: 50px;
	top: 200px;
	right: -200px;
	bottom: 50px;
}
.box{
	background-color:#390;
	width:300px;
	margin-top:10px;
	margin-right:10px;
	list-style:none;}
</style></head>

<body id="cat">
<div id="all">
	
    <div id="header">
    	<h1 align="center">选修课网上选课系统</h1>
    </div>
    <div id="permlink">
    	<div align="right"><a href="<?php echo U('/Index/index');?>">学校主页</a> 
    	   <a href="<?php echo U('/Course/index2');?>">教务处</a>
    	    <a href="#">学生处</a>
            <a href="#">关于系统</a>
  	      </div>
	</div>
   
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

    <div id="middle">
	<center>
	<table width="50%" border="2" bordercolor="#00FF33">
  <tr>
    <td><div align="center">学号</div></td>
    <td><div align="center">姓名</div></td>
    <td><div align="center">班级</div></td>
    <td><div align="center">操作</div></td>
  </tr>
  <?php if(is_array($list)): $i = 0; $__LIST__ = $list;if( count($__LIST__)==0 ) : echo "" ;else: foreach($__LIST__ as $key=>$vo): $mod = ($i % 2 );++$i;?><tr>
    <td align="center"><?php echo ($vo["StuNo"]); ?></td>
    <td><?php echo ($vo["StuName"]); ?></td>
    <td><?php echo ($vo["Classno"]); ?></td>
    <td><a href="<?php echo U("/Student/edit/StuNo/$vo[StuNo]");?>">编辑</a> <a href="<?php echo U("/Student/delete/StuNo/$vo[StuNo]");?>" onclick="return confirm('确定删除?')">删除</a></td>
  </tr><?php endforeach; endif; else: echo "" ;endif; ?>
</table>
	</center>

		</div>
</div>
</body>
</html>