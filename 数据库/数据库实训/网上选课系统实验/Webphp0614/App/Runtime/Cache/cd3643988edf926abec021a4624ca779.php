<?php if (!defined('THINK_PATH')) exit();?><!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>教师添加课程</title>
<style type="text/css">
<!--
body{
	background-color:#CCC;}
.STYLE1 {
	font-family: "宋体";
	text-align:center;
	font-size: x-large;
	background-color:#666;
	margin-top:0px;
    }
#key{
	background-color:#9F9;
	width:1200px;
	margin: 0px 50px 50px 50px;
	}
#d1{
	background-color:#060;
	padding:1px 1px 1px;
	text-align:center;
	font-size:24px;
	color:#FFF;
	}
#d2{
	margin-left:0px;
	border-color:#060;
	padding:1px;
	margin-bottom:5px;
	padding-left:30px;
	width:100px;
	}

#nav{
	margin-top:10px;
	margin-left:1000px;
	margin-bottom:2px;}
c{color:#333;}p{font-size:16px;}
#d3{
	margin-left:350px;
	margin-top:-150px;
	padding-bottom:50px;}
#d4{
	margin-left:30px;}
-->
</style>
</head>

<body>
<div id="key">
	<div id="d1"><h3>教师课程管理</h3></div>
	<div class="STYLE1">
	选课系统-v1.0</div>
    <div id="nav">
   			 <a href="<?php echo U('Teacher/index');?>">首页</a>	
   			 <a href="#">课程列表</a>
   			 <a href="#">选课信息</a>
            
	</div>
    <div id="left">
		

		<div id="d4">
			 <table width="240" border="1" bordercolor="#003300" >
 				 <tr>
 					   <td width="204" align="center" bordercolor="#99FF33"><c>友情链接</c></td>
 				 </tr>
 				 <tr>
					    <td><a href="#">电子科技大学成都学院</a></td>
 				 </tr>
				  <tr>
 						   <td><a href="#">云计算系</a></td>
 				 </tr>
			</table>
		</div>
	</div>
	<div id="d2">
		
 			 <p>用户信息</p><br/>
 			 编号：<?php echo (session('TeatNo')); ?>
 			 <br/>
 			 姓名:<?php echo (session('TeaName')); ?><br/>
 			 角色：老师
		
	</div>

	<div id="d3">
		<form name="form1" method="post" action="<?php echo U('/Course/add_do');?>">
			<table width="800" border="1">
			  <tr>
 				   <td colspan="3"><div align="center">请输入课程</div></td>
  			  </tr>
  				<tr>
   					 <td width="280">编号：</td>
  					  <td colspan="2"><label>
  				    <input type="text" name="CouNo">
  					  </label></td>
			  </tr>
 				 <tr>
   						 <td>名称：</td>
  						  <td colspan="2"><label>
   					   <input type="text" name="CouName">
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