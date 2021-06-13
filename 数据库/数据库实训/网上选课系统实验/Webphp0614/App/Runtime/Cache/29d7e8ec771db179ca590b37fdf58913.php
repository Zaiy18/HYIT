<?php if (!defined('THINK_PATH')) exit();?><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>选课系统</title>
<link rel="stylesheet" type="text/css" href="/Webphp/Public/css/index.css" />

<style type="text/css">

#header{
	background-color:#63F;
	font-size:24px;
	text-align:center;
	margin-top:0px;
	}
#top{
	margin-right:0px;
	top: 30px;
	right: 0px;
	color: #F0F;
	float: right;
}
#cat{
	background-color:#0F6;
	margin-top:0px;

}
#middle{
	text-align: center;
	right: 20px;
}
#left{
	background-color:#F9F;
	background-position:left;
	height: 100px;
	width: 300px;
	border-top-width: 2px;
	border-right-width: 2px;
	border-bottom-width: 2px;
	border-left-width: 2px;
	}
.box{
	background-color:#C9C;
	border-color:#30F;
	list-style:none;
	float:none;}
</style></head>

<body id="cat">
<div>
 	<div id="header">
    	<h1 align="center">学生选修课网上选课系统</h1>
    </div>
	<div id="top">
		<a href="<?php echo U('/Index/index');?>">学校主页</a> 
    	<a href="<?php echo U('/Course/index2');?>">教务处</a>
    	<a href="#">学生处</a>
        <a href="#">关于系统</a>
  	</div>
    <div id="left">
    	<div class="box">
        	<h3>学生登录系统</h3>
            <hr color="#FFCC66">
               <ul>用户信息
			     <li>编号:<?php echo (session('StuNo')); ?></li>
				 <li>姓名:<?php echo (session('StuName')); ?></li>
				 <li>角色：学生</li>
			   </ul>
        </div>
        <div class="box">
        	<h3>友情链接</h3>
            <hr color="#FFCC66">
            <ul>
            	<li><a href="#">使用方法</a></li>
                <li><a href="#">常见问题</a></li>
                <li><a href="#">联系我们</a></li>
            </ul>
        </div>
		  <div class="box">
        	<h3>生活链接</h3>
            <hr color="#FFCC66">
            <ul>
            	<li><a href="http://dccsat.cduestc.cn/index/">成都学院云计算系</a></li>
            </ul>
        </div>
    </div>
     <div id="middle">
	<center>
	<table width="50%" border="1" >
  <tr>
    <td><div align="center">学生姓名</div></td>
    <td><div align="center">已选课程号</div></td>
    <td><div align="center">志愿号</div></td>
    <td><div align="center">操作</div></td>
  </tr>
  <?php if(is_array($list)): $i = 0; $__LIST__ = $list;if( count($__LIST__)==0 ) : echo "" ;else: foreach($__LIST__ as $key=>$vo): $mod = ($i % 2 );++$i;?><tr>
    <td><div align="center"><?php echo ($vo["StuNo"]); ?></div></td>
    <td><div align="center"><?php echo ($vo["CouNo"]); ?></div></td>
    <td><div align="center"><?php echo ($vo["WillOrder"]); ?></div></td>
    <td><div align="center"><?php echo ($vo["State"]); ?></div></td>
    <td>
   <a style="color:#F00;">已选</a>
  <a href="<?php echo U("/Student/delete/StuNo/$vo[StuNo]");?>">删除</a>
    </td>

  </tr><?php endforeach; endif; else: echo "" ;endif; ?>
  </table>
	</center>
    </div>
 </div>   
</body>
</html>