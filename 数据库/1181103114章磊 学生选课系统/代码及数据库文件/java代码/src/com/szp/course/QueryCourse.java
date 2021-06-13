package com.szp.course;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class QueryCourse extends JFrame implements ActionListener {// 用于课程信息管理中查询时输入课程号的界面
	JLabel ltitle = new JLabel("课程号：");
	JTextField tcno = new JTextField(8);
	JButton btnOK = new JButton("确定");
	JPanel p = new JPanel();
	String kch = null;

	public QueryCourse() { // 构造方法
		p.add(ltitle);
		p.add(tcno);
		p.add(btnOK);
		add(p);
		this.setBounds(300, 280, 200, 160);
		btnOK.addActionListener(this);
		this.setResizable(false);
		this.show();
	}

	public void actionPerformed(ActionEvent e) {
		kch = tcno.getText();// 取得当前输入课程号的值
		if (kch.equals("")) {// 判断是否输入了课程号
			JOptionPane.showMessageDialog(null, "课程号不能为空，请重新输入！");
		} else {
			this.dispose();
			new CourseManager(this, "课程信息管理").select();
		}

	}
}








