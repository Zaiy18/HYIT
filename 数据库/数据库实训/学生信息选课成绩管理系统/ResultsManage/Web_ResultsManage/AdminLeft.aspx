﻿<%@ Page Language="C#" AutoEventWireup="true" CodeFile="AdminLeft.aspx.cs" Inherits="AdminLeft" %>

<%--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">--%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/chili-1.7.pack.js"></script>
<script type="text/javascript" src="js/jquery.easing.js"></script>
<script type="text/javascript" src="js/jquery.dimensions.js"></script>
<script type="text/javascript" src="js/jquery.accordion.js"></script>
<script language="javascript">
    jQuery().ready(function () {
        jQuery('#navigation').accordion({
            header: '.head',
            navigation1: true,
            event: 'click',
            fillSpace: true,
            animated: 'bounceslide'
        });
    });
</script>
<style type="text/css">
<!--
body {
	margin:0px;
	padding:0px;
	font-size: 12px;
}
#navigation {
	margin:0px;
	padding:0px;
	width:147px;
}
#navigation a.head {
	cursor:pointer;
	background:url(images/main_34.gif) no-repeat scroll;
	display:block;
	font-weight:bold;
	margin:0px;
	padding:5px 0 5px;
	text-align:center;
	font-size:12px;
	text-decoration:none;
}
#navigation ul {
	border-width:0px;
	margin:0px;
	padding:0px;
	text-indent:0px;
}
#navigation li {
	list-style:none; display:inline;
}
#navigation li li a {
	display:block;
	font-size:12px;
	text-decoration: none;
	text-align:center;
	padding:3px;
}
#navigation li li a:hover {
	background:url(images/tab_bg.gif) repeat-x;
		border:solid 1px #adb9c2;
}
-->
</style>
</head>
<body>
<form id="form1" runat="server">
<div  style="height:100%;">
  <ul id="navigation">
    <li> <a class="head">基础信息管理</a>
      <ul>
        <li><a href="DepartmentManage.aspx" target="rightFrame">院系管理</a></li>
        <li><a href="MajorManage.aspx" target="rightFrame">专业管理</a></li>
        <li><a href="ClassManage.aspx" target="rightFrame">班级管理</a></li>
        <li><a href="SemesterManage.aspx" target="rightFrame">学期设置</a></li>
      </ul>
    </li>
    <li> <a class="head">教师管理</a>
      <ul>
        <li><a href="TeacherManage.aspx" target="rightFrame">教师信息管理</a></li>
      </ul>
    </li>
    <li> <a class="head">学生管理</a>
      <ul>
        <li><a href="SudentsManage.aspx" target="rightFrame">学生信息管理</a></li>
      </ul>
    </li>
   <li> <a class="head">课程管理</a>
      <ul>
        <li><a href="CourseManage.aspx" target="rightFrame">课程信息管理</a></li>
      </ul>
    </li>
     <li> <a class="head">成绩管理</a>
      <ul>
        <li><a href="ResultsManage.aspx" target="rightFrame">成绩登记</a></li>
      </ul>
    </li>
    <li> <a class="head">系统管理</a>
      <ul>
        <li><a href="UpdatePwd.aspx" target="rightFrame">修改密码</a></li>
         <li><asp:LinkButton ID="lnkbOut" runat="server"  OnClientClick="return confirm('确定要退出系统吗？')" onclick="lnkbOut_Click" >退出系统</asp:LinkButton></li>
      </ul>
    </li>
  </ul>
</div>
</form>
</body>
</html>
