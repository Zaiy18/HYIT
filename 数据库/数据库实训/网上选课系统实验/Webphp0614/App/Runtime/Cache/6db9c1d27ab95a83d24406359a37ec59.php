<?php if (!defined('THINK_PATH')) exit();?><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生选课</title>
<link rel="stylesheet" type="text/css" href="/Webphp/Public/css/index.css" />

<style type="text/css">


body{
	background-color:#999;}
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
#top{
	margin-right:20px;
	margin-top:20px;
	top: 30px;
	right: 0px;
	float: right;
}

#middle{
	text-align: center;
	position: absolute;
	left: 50px;
	top: 200px;
	right: -200px;
	bottom: 50px;
}
#left{
	background-color:#060;
	height: 300px;
	width: 300px;
	border-top-width: 2px;
	border-right-width: 2px;
	border-bottom-width: 2px;
	border-left-width: 2px;
	}
.box{
	background-color:#390;
	border-color:#30F;
	list-style:none;
	float:none;}
c{
	color:#F00;ss}
</style></head>

<body>
<div id="all">
 	<div id="header">
    	<h1 align="center">学生选修课网上选课系统</h1>
    </div>
	<div id="top">
		<a href="<?php echo U('/Index/index');?>">学校主页</a> 
    	<a href="<?php echo U('/Course/index2');?>">教务处</a>
    	<a href="#">学生处</a>
        <a href="#">关于系统</a>
        <a href="<?php echo U('/Student/index');?>">返回</a>
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
    <td><div align="center">课程编号</div></td>
    <td><div align="center">课程名称</div></td>
    <td><div align="center">上课老师</div></td>
    <td><div align="center">学分</div></td>
    <td><div align="center">上课时间</div></td>
    <td><div align="center">操作</div></td>
  </tr>
  <?php if(is_array($list)): $i = 0; $__LIST__ = $list;if( count($__LIST__)==0 ) : echo "" ;else: foreach($__LIST__ as $key=>$vo): $mod = ($i % 2 );++$i;?><tr>
    <td align="center"><?php echo ($vo["CouNo"]); ?></td>
    <td><div align="center"><?php echo ($vo["CouName"]); ?></div></td>
    <td><div align="center"><?php echo ($vo["Teacher"]); ?></div></td>
    <td><div align="center"><?php echo ($vo["Credit"]); ?></div></td>
    <td><div align="center"><?php echo ($vo["SchoolTime"]); ?></div></td>
    <td align="center">
   <?php if($vo[StuNo] == ''): ?><a href="<?php echo U("/Student/choseCourseDo/CouNo/$vo[CouNo]");?>">添加</a>
   <?php else: ?>
   <c>已选</c><?php endif; ?> 
    </td>

  </tr><?php endforeach; endif; else: echo "" ;endif; ?>
  </table>
	</center>
    </div>
 </div>   
</body>
</html>