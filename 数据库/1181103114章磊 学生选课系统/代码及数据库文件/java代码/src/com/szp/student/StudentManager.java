package com.szp.student;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class StudentManager extends JFrame implements ActionListener {// 学生信息管理
	JPanel p = new JPanel();
	JButton btnAdd = new JButton("增加");
	JButton btnDelete = new JButton("删除");
	JButton btnAlter = new JButton("修改");
	JButton btnSearch = new JButton("查询");
	JButton btnDisplay = new JButton("显示");
	JMenuBar mb = new JMenuBar();
	JPanel p1 = new JPanel();;
	JTable sTable;
	JScrollPane scroll;
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	Object[][] playerInfo;
	QueryStudent sst;
	String mxh = null;
	boolean bstd = false;

	public StudentManager() {// 构造方法
		super("学生信息管理");
		add("South", p);
		this.add("Center", p1);
		mb.add(btnAdd);
		mb.add(btnDelete);
		mb.add(btnAlter);
		mb.add(btnSearch);
		mb.add(btnDisplay);
		this.connDB(); // 连接数据库
		// this.display();
		this.setBounds(200, 200, 400, 260);
		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);
		btnAlter.addActionListener(this);
		btnSearch.addActionListener(this);
		btnDisplay.addActionListener(this);
		this.setJMenuBar(mb);
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		show();
	}

	StudentManager(QueryStudent sst) {// 构造方法
		super("学生信息管理");
		this.sst = sst;
		bstd = true;
		add("South", p);
		this.add("Center", p1);
		mb.add(btnAdd);
		mb.add(btnDelete);
		mb.add(btnAlter);
		mb.add(btnSearch);
		mb.add(btnDisplay);
		this.connDB();
		this.setBounds(200, 200, 400, 260);
		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);
		btnAlter.addActionListener(this);
		btnSearch.addActionListener(this);
		btnDisplay.addActionListener(this);
		this.setJMenuBar(mb);
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		show();
	}

	public void display() {// 显示所有学生的基本信息
		int i = 0;
		int j = 0;
		int k = 0;
		List al = new ArrayList();
		try {
			rs = stmt.executeQuery("select * from students");
			while (rs.next()) { // 找出表中的记录数赋给i
				al.add(rs.getString("sId"));
				al.add(rs.getString("sName"));
				al.add(rs.getString("sAge"));
				al.add(rs.getString("sSex"));
				al.add(rs.getString("sDepart"));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		playerInfo = new Object[i][5];
		String[] columnNames = { "学号", "姓名", "年龄", "性别", "院系" };

		try {
			rs = stmt.executeQuery("select * from students order by sId");
			while (rs.next()) {
				playerInfo[j][0] = rs.getString("sId");
				playerInfo[j][1] = rs.getString("sName");
				playerInfo[j][2] = rs.getString("sAge");
				playerInfo[j][3] = rs.getString("sSex");
				playerInfo[j][4] = rs.getString("sDepart");
				j++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sTable = new JTable(playerInfo, columnNames);// 创建网格
		p1.add(sTable);
		scroll = new JScrollPane(sTable);
		this.add(scroll);
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

	public void closeDB() // 关闭数据库连接
	{
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete() {// 删除某个学生的基本信息
		String xh = null;
		String xm = null;
		int nl = 0;
		String xb = null;
		String yx = null;
		int row = -1;
		row = sTable.getSelectedRow();
		if (row == -1) {// 判断要删除的信息是否被选中
			JOptionPane.showMessageDialog(null, "请选择要删除的记录！");
		} else {
			if (!bstd) {// 判断选择的是不是查询后的结果
				int j1 = 0;
				try {
					rs = stmt.executeQuery("select * from students");
					while (rs.next() && j1 <= row) {// 找出当前被选中的记录在数据库中的对应
						xh = rs.getString("sId");
						xm = rs.getString("sName");
						nl = rs.getInt("sAge");
						xb = rs.getString("sSex");
						yx = rs.getString("sDepart");
						j1++;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				int i1 = 0;
				try {
					int rs1 = stmt.executeUpdate("delete from students where sId='"
							+ xh + "'"); // 删除数据库中当前被选中的记录
					//stmt.executeUpdate("delete from unpw where un='" + xh + "'");// 删除对应的用户表中的记录
					JOptionPane.showMessageDialog(null, "记录删除成功！");
					this.dispose();
					new StudentManager().display();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				try {
					int rs1 = stmt.executeUpdate("delete from s where sno='"
							+ mxh + "'");
					stmt.executeUpdate("delete from unpw where un='" + mxh
							+ "'");
					JOptionPane.showMessageDialog(null, "记录删除成功！");
					this.dispose();
					new StudentManager().display();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void update() {// 修改某个学生的基本信息
		String xh = null;
		String xm = null;
		int nl = 0;
		String xb = null;
		String yx = null;
		int row = -1;
		row = sTable.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录！");
		} else {
			int j1 = 0;
			try {
				if (!bstd) {// 判断选择的是不是查询后的结果
					rs = stmt.executeQuery("select * from students");
				} else {
					rs = stmt.executeQuery("select * from students where sId='" + mxh
							+ "'");
				}
				while (rs.next() && j1 <= row) {// 找出当前被选中的记录在数据库中的对应
					xh = rs.getString("sId");
					xm = rs.getString("sName");
					nl = rs.getInt("sAge");
					xb = rs.getString("sSex");
					yx = rs.getString("sDepart");
					j1++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			StudentAdd sadd = new StudentAdd(xb, yx);
			sadd.setTitle("修改");
			sadd.tsno.setText(xh);
			sadd.tsname.setText(xm);
			sadd.tsage.setText("" + nl);
			this.dispose();
		}
	}

	public void select() {// 显示某个查询的结果
int i=-1;
		mxh = sst.xh;
		playerInfo = new Object[50][6];
		String[] columnNames = { "课程号", "课程名", "任课老师", "地点", "学分" };
		try {
			rs = stmt.executeQuery("select cid,cname,cteacher,cplace,ctime,ccredit from courses where cid in"
					+ "(select cid from syllabus where sid ='"+mxh +"')");
			while (rs.next()) {
				i++;
				playerInfo[i][0] = rs.getString("cid");
				playerInfo[i][1] = rs.getString("cname");
				playerInfo[i][2] = rs.getInt("cteacher");
				playerInfo[i][3] = rs.getString("cplace");
				playerInfo[i][4] = rs.getString("ctime");
				playerInfo[i][5] = rs.getString("ccredit");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (playerInfo[0][1] == null) {
			this.dispose();
			JOptionPane.showMessageDialog(null, "学号不存在！");
			new StudentManager().display();
		} else {
			sTable = new JTable(playerInfo, columnNames);// 创建网格
			p1.add(sTable);
			scroll = new JScrollPane(sTable);
			this.add(scroll);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "增加") {

			new StudentAdd("男", "计科系");
			this.dispose();
		}
		if (e.getActionCommand() == "删除") {
			this.delete();
		}
		if (e.getActionCommand() == "修改") {
			this.update();
		}
		if (e.getActionCommand() == "查询") {
			sst = new QueryStudent("学号：");
			this.dispose();
		}
		if (e.getActionCommand() == "显示") {
			this.dispose();
			new StudentManager().display();
		}
	}

}
