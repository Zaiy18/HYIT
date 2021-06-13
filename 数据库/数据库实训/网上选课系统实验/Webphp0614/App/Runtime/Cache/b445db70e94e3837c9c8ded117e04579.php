<?php if (!defined('THINK_PATH')) exit();?><!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
<style type="text/css">
<!--
.STYLE1 {
	font-family: "宋体";
	text-align:center;
	font-size: x-large;
	background-color:#FF6;
}
#key{
	background-color:#09F;}

-->
</style>
</head>

<body id="key">
<div class="STYLE1">
	选课系统-v1.0</div>
<div>
	<table width="600" border="1">  
    首页	
    <a>课程列表</a>
    选课信息
</table>
</div>


<div>
<table width="239" border="1">
  用户信息<br/>
  编号：<?php echo (session('TeatNo')); ?>
  <br/>
  姓名:<?php echo (session('TeaName')); ?><br/>
  角色：老师
</table>
</div>
<div>
	<table width="240" border="1">
  <tr>
    <td width="204">友情链接</td>
  </tr>
  <tr>
    <td>电子科技大学成都学院</td>
  </tr>
  <tr>
    <td>云计算系</td>
  </tr>
</table>
</div>
<div>
<form name="form1" method="post" action="<?php echo U('/Course/add_do');?>">
	<table width="1072" border="1">
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

</body>
</html>