<?php if (!defined('THINK_PATH')) exit();?><!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>教师编辑课程</title>
<style type="text/css">
<!--
body{
	background-color:#999;}
#all{
	background-color:#090;
	width:1200px;
	margin:0px 65px 0px;}
.STYLE1 {
	background-color:#030;
	font-size:36px;
	text-align:center;
	margin-top:0px;
	height:50px;
	padding-top:10px;
}
.STYLE2{
	font-family: "宋体";
	text-align:center;
	font-size: x-large;
	background-color:#666;
	margin-top:0px;
	padding-top:5px;
	}
#left{
	background-color:#060;
	margin-left:10px;
	margin-top:0px;
	width:340px;
	height:450px;}
.box{
	background-color:#9F0;
	text-align:left;
	width:300px;
	margin-top:20px;
	margin-left:5px;
	padding-top:2px;
	padding-bottom:2px;
	}
#center{
	width:400px;
	height:100px;
	margin-left:800px;
	position:absolute;
	top:200px;
	right:500px;
	}

-->
</style>
</head>

<body>
<div id="all">
<div class="STYLE1">
	课程添加</div>
<div class="STYLE2">
	选课系统-v1.0</div>
<div>
	<table width="600" border="1">  
    首页	
    <a>课程列表</a>
    选课信息
</table>
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
<div id="center">
<form name="form1" method="post" action="<?php echo U('/Course/add_do');?>">
	<table width="600" border="2">
  <tr>
    <td colspan="3"><div align="center">请输入课程</div></td>
    </tr>
  <tr>
    <td width="280">编号：</td>
    <td colspan="2"><label>
      <input type="text" name="CouNo" value="<?php echo ($info["CouNo"]); ?>" >
      <input type="hidden" name="CouNo2" >
    </label></td>
    </tr>
  <tr>
    <td>名称：</td>
    <td colspan="2"><label>
      <input type="text" name="CouName" value="<?php echo ($info["CouName"]); ?>">
    </label></td>
    </tr>
  <tr>
    <td>类型：</td>
    <td colspan="2">
    <select name="Kind">
    <option value="必修" <?php if($info["Kind"] == '必修'): ?>selected="selected"<?php endif; ?>>必修
    <option value="选修" <?php if($info["Kind"] == '选修'): ?>selected="selected"<?php endif; ?>>选修
    </select>
   </td>
    </tr>
  <tr>
    <td>学分：</td>
    <td colspan="2"><label>
      <input type="text" name="Credit">
    </label></td>
    </tr>
  <tr>
    <td>教师：</td>
    <td colspan="2"><label>
      <input type="text" name="Teacher">
    </label></td>
    </tr>
  <tr>
    <td>上课时间：</td>
    <td colspan="2"><label>
      <input type="text" name="SchoolTime">
    </label></td>
    </tr>
  <tr>
    <td>限定人数</td>
    <td colspan="2"><label>
      <input type="text" name="LimiNum">
    </label></td>
    </tr>
  <tr>
    <td>图片</td>
    <td width="213">&nbsp;</td>
    <td width="557">&nbsp;</td>
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