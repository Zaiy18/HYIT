<?php if (!defined('THINK_PATH')) exit();?><!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
<style type="text/css">
<!--
.map{
	background-color:#6FF;}
.STYLE1 {
	font-family: "宋体";
	font-size: x-large;
	text-align:center;
	background-color:#963;
	direction:inherit;
}
#nav{
	border-width:15px;
	background-color:#63F;
	}
#list{
	padding:20px;}


-->
</style>
</head>

<body class="map">
<div class="STYLE1">
	选课系统-v1.0</div>
<div id="list"> 
    <a href="<?php echo U('/Index/index');?>">首页	</a>
    <a href="#">课程列表</a>
    <a href="#"> 选课信息</a>
    <hr color="#CC6633";>

</div>


<div  id="nav">
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
</div>
<div>
<form name="form1" method="post" action="<?php echo U('/Course/add_do');?>">
	<table width="1072" border="1">
  <tr>
    <td colspan="3"><div align="center">请输入课程</div></td>
    </tr>
  <tr>
    <td width="280">学号：</td>
    <td colspan="2"><label>
      <input type="text" name="StuNo" value="<?php echo ($info["StuNo"]); ?>" >
      <input type="hidden" name="StuNo2" >
    </label></td>
    </tr>
  <tr>
    <td>姓名：</td>
    <td colspan="2"><label>
      <input type="text" name="StuName" value="<?php echo ($info["StuName"]); ?>">
    </label></td>
    </tr>
  <tr>
    <td>班级：</td>
    <td colspan="2">
    
    <label>
      <input type="text" name="Classno" value="<?php echo ($info["Classno"]); ?>">
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