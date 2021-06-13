package com.szp.student;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class StudentAdd extends JFrame implements ActionListener, ItemListener {// 用于学生信息管理中增加或修改某条记录的界面
	JLabel lsno = new JLabel("学号：");
	JLabel lsname = new JLabel("姓名：");
	JLabel lssex = new JLabel("性别：");
	JLabel lsage = new JLabel("年龄：");
	JLabel lsdept = new JLabel("院系：");
	JTextField tsno = new JTextField(14);
	JTextField tsname = new JTextField(14);
	JComboBox cbssex = new JComboBox();
	JTextField tsage = new JTextField(14);
	JComboBox cbsdept = new JComboBox();
	JButton btnOK = new JButton("   确     定     ");
	JButton btnCancel = new JButton("   取     消     ");
	JPanel p = new JPanel();
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String xb = "男";
	String yx = "计科系";
	boolean isNewsm = true;// 用于判断是否显示学生管理的界面

	public StudentAdd(String xb, String yx) {// 构造方法
		this.xb = xb;
		this.yx = yx;
		this.setTitle("增加");
		this.setBounds(200, 200, 230, 280);
		if (xb.trim().equals("男")) {
			cbssex.addItem("男");
			cbssex.addItem("女");
		} else {
			cbssex.addItem("女");
			cbssex.addItem("男");
		}
		if (yx.trim().equals("计科系")) {
			cbsdept.addItem("计科系");
			cbsdept.addItem("物理系");
			cbsdept.addItem("数学系");
			cbsdept.addItem("外语系");
		}
		if (yx.trim().equals("物理系")) {
			cbsdept.addItem("物理系");
			cbsdept.addItem("计科系");
			cbsdept.addItem("数学系");
			cbsdept.addItem("外语系");
		}
		if (yx.trim().equals("外语系")) {
			cbsdept.addItem("外语系");
			cbsdept.addItem("计科系");
			cbsdept.addItem("物理系");
			cbsdept.addItem("数学系");

		}
		if (yx.trim().equals("数学系")) {
			cbsdept.addItem("数学系");
			cbsdept.addItem("计科系");
			cbsdept.addItem("物理系");
			cbsdept.addItem("外语系");
		}
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		p.add(lsno);
		p.add(tsno);
		p.add(lsname);
		p.add(tsname);
		p.add(lsage);
		p.add(tsage);
		p.add(lssex);
		p.add(cbssex);
		p.add(lsdept);
		p.add(cbsdept);
		p.add(btnOK);
		p.add(btnCancel);
		this.add(p);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cbssex.addItemListener(this);
		cbsdept.addItemListener(this);
		btnOK.addActionListener(this);
		btnCancel.addActionListener(this);
		this.show();
	}

	public void connDB() { // 连接数据库
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=choosecourse","sa", "258456");
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeDB() // 关闭连接
	{
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void insertst() { // 插入记录
		String xh = null;
		String xm = null;
		String nl = "0";
		xh = tsno.getText().trim();
		xm = tsname.getText().trim();
		try {
			nl =  tsage.getText().trim();
			if (this.getTitle() == "修改") {// 如果是修改记录
				lsno.setEnabled(false);
				try {
					
					this.connDB();
					System.out.println(":"+xm+":"+nl+":"+xb+":"+yx+":"+xh);
					
					int rs1 = stmt.executeUpdate("UPDATE students SET sName='"+xm+"',sSex='"+xb.trim()+"',sDepart='"+yx.trim()+"',sAge='"+nl+"' where sId='"+xh.trim()+"'");
							
					JOptionPane.showMessageDialog(null, this.getTitle() + "成功！",
							"提示", JOptionPane.INFORMATION_MESSAGE);
					this.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
//			String str = "insert into students values('" + xh + "','" + xm + "'," + nl
//					+ ",'" + xb + "','" + yx + "')";

//			this.connDB();// 连接数据库
//			try {
//				stmt.executeUpdate(str);
//				
//				
//			} catch (SQLException e) {
//				JOptionPane.showMessageDialog(null, "学号已存在！");
//				tsno.setText("");
//			}
		} catch (NumberFormatException e) {// 判断年龄是否为数字
			JOptionPane.showMessageDialog(null, "年龄必须是整数！");
			tsage.setText("");
			isNewsm = false;
		}

		if (this.getTitle() == "增加") {// 如果是增加记录，对应的用户表中也增加一条记录
			try {
				this.connDB();
				stmt.executeUpdate("insert into students(sId,sName,sAge,sSex,sDepart) values('" + xh + "','" + xm + "'," + nl
					+ ",'" + xb + "','" + yx + "')");
			} catch (NullPointerException e) {

			} catch (SQLException e) {
				 e.printStackTrace();
			}
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "   确     定     ") {
			this.insertst();
			if (isNewsm) {
				new StudentManager().display();
			}
			isNewsm = true;
		}
		if (e.getActionCommand() == "   取     消     ") {
			this.setVisible(false);
			new StudentManager().display();
		}

	}

	public void itemStateChanged(ItemEvent e) { // 下拉框的监听
		if (e.getStateChange() == ItemEvent.SELECTED) {
			JComboBox jcb = (JComboBox) e.getSource();
			if ((jcb.getSelectedItem() == "男")
					|| (jcb.getSelectedItem() == "女")) {
				xb = (String) jcb.getSelectedItem();
			} else {
				yx = (String) jcb.getSelectedItem();
			}
		}
	}
}

