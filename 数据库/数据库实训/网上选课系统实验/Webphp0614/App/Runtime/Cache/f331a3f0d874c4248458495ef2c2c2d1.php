<?php if (!defined('THINK_PATH')) exit();?><!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>选课系统——首页</title>
<meta http-equiv="content-type" content="text/html" charset="utf-8" />
<link rel="stylesheet" type="text/css" href="../../../public/css/greenspan.css" />
<link rel="stylesheet" type="text/css" href="/Webphp/Public/css/greenspan.css" />
</head>

<body>
<div id="outside">

<div id="permlink">
  <a href="#">学校主页</a>
  <a href="#">教务处</a>
  <a href="#">学生处</a>
</div> <!-- permlink 结束-->

<div id="header">
 <h1> 网上选课系统</h1>
</div>

<div id="topnav">
 <a href="#">学校主页</a>
 <a href="#">学生处</a>
 <a href="#">团委</a>
 <a href="#">公共服务</a>
 <a href="#">关于本系统</a>
</div>

<div id="left">
 <div class="box">
  <h3>用户登录</h3>
  
  <form action=<?php echo U('/Index/checkLogin');?> method="post">
  <p>
  用户名<br /><input type="text" name="username" size="10"/><br/>
  密码<br /><input type="password" name="password" size="12"/><br/>
  你的身份<br/>
  <select name="role">
   <option value="student">学生
   <option value="teacher">老师
  </select>
  <br/>
  <input type="submit" value="确定" name="ok">
  <input type="reset" value="重置" name="reset">
 </form>
 你是第<font color="#0000FF"> 这里将统计显示计数器的次数</font>个访问者
 </div><!-- end of box-->
 
<div class="box">
<h3> 快速链接</h3>
<ul>
 <li><a href="#"> 使用方法</a></li>
 <li><a href="#"> 常见问题</a></li>
 <li><a href="#"> 联系我们</a></li>
</ul>
 </div><!-- end of box-->
</div><!-- end of left-->
<div id="middle">
 <div class="box">
  <h3>随机课程展示</h3>
  这里将显示图片和对应课程的详细信息
  </div><!-- end of box-->
 </div><!--end of middle-->
</div><!--end of outsaide-->
</body>
</html>