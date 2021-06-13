package com.szp.course;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class CourseManager extends JFrame implements ActionListener {// 课程信息管理
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
	QueryCourse cst;
	String mkch = null;
	boolean bstd = false;

	public CourseManager(String title) {// 构造方法
		super(title);
		add("South", p);
		this.add("Center", p1);
		mb.add(btnAdd);
		mb.add(btnDelete);
		mb.add(btnAlter);
		mb.add(btnSearch);
		mb.add(btnDisplay);
		this.connDB();// 连接数据库
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

	CourseManager(QueryCourse cst, String title) {// 构造方法
		super(title);
		this.cst = cst;
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

	public void display() {// 显示所有的课程信息
		int i = 0;
		int j = 0;
		int k = 0;
		List al = new ArrayList();
		try {
			rs = stmt.executeQuery("select * from courses");
			while (rs.next()) {// 找出表中的记录数赋给i
				al.add(rs.getString("cid"));
				al.add(rs.getString("cname"));
				al.add(rs.getString("cteacher"));
				al.add(rs.getString("cplace"));
				al.add(rs.getString("ctime"));
				al.add(rs.getFloat("ccredit"));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		playerInfo = new Object[i][6];
		String[] columnNames = { "课程号", "课程名","任课老师","地点","时间","学分"};//, "先行课程号"

		try {
			rs = stmt.executeQuery("select * from courses order by cid");
			while (rs.next()) {
				playerInfo[j][0] = rs.getString("cid");
				playerInfo[j][1] = rs.getString("cname");
				playerInfo[j][2] = rs.getString("cteacher");
				playerInfo[j][3] = rs.getString("cplace");
				playerInfo[j][4] = rs.getString("ctime");
				
				playerInfo[j][5] = rs.getString("ccredit");
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

	public void closeDB() // 关闭连接
	{
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete() {// 删除某个课程信息
		String kch = null;
		String kcm = null;
		//String xxkch = null;

		int row = -1;
		row = sTable.getSelectedRow();
		if (row == -1) {// 判断要删除的信息是否被选中
			JOptionPane.showMessageDialog(null, "请选择要删除的记录！");
		} else {
			if (!bstd) {// 判断选择的是不是查询后的结果
				int j1 = 0;
				try {
					rs = stmt.executeQuery("select * from courses");
					while (rs.next() && j1 <= row) {// 找出当前被选中的记录在数据库中的对应
						kch = rs.getString("cid");
						kcm = rs.getString("cname");
						//xxkch = rs.getString("pcno");
						j1++;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				int i1 = 0;
				try {
					int rs1 = stmt.executeUpdate("delete from courses where cid='"
							+ kch + "'");// 删除数据库中当前被选中的记录
					JOptionPane.showMessageDialog(null, "记录删除成功！");
					this.dispose();
					new CourseManager("课程信息管理").display();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				try {
					int rs1 = stmt.executeUpdate("delete from courses where cid='"
							+ mkch + "'");// 删除数据库中当前被选中的记录
					JOptionPane.showMessageDialog(null, "记录删除成功！");
					this.dispose();
					new CourseManager("课程信息管理").display();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void update() {// 修改某个课程记录
		String kch = null;
		String kcm = null;
		int id =0;
		//String xxkch = null;

		int row = -1;
		row = sTable.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录！");
		} else {
			int j1 = 0;
			try {
				if (!bstd) {// 判断选择的是不是查询后的结果
					rs = stmt.executeQuery("select * from courses");
				} else {
					rs = stmt.executeQuery("select * from courses where cid='" + mkch
							+ "'");
				}
				while (rs.next() && j1 <= row) {// 找出当前被选中的记录在数据库中的对应
					kch = rs.getString("cid");
					kcm = rs.getString("cname");
					id = rs.getInt("id");
					//xxkch = rs.getString("pcno");
					j1++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			AddCourse cadd = new AddCourse(id);
			cadd.setTitle("修改");
			cadd.tcno.setText(kch);
			cadd.tcname.setText(kcm);
			//cadd.tpcno.setText(xxkch);
			//cadd.tcno.setEnabled(false);
			this.dispose();
		}
	}

	public void select() {// 显示某个查询的结果
int i=-1;
		mkch = cst.kch;
		playerInfo = new Object[50][5];
		String[] columnNames = { "学号", "姓名","年龄","性别","院系"};//"先行课程号"
		try {
			rs = stmt.executeQuery("select sId,sName,sAge,sSex,sDepart from students where sId in"
					+ "(select sId from syllabus where cid ='"+mkch +"')");
			while (rs.next()) {
				i++;
				playerInfo[i][0] = rs.getString("sId");
				playerInfo[i][1] = rs.getString("sName");
				playerInfo[i][2] = rs.getString("sAge");
				playerInfo[i][3] = rs.getString("sSex");
				playerInfo[i][4] = rs.getString("sDepart");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (playerInfo[0][1] == null) {
			this.dispose();
			JOptionPane.showMessageDialog(null, "课程号不存在！");
			new CourseManager("课程信息管理").display();
		} else {
			sTable = new JTable(playerInfo, columnNames);// 创建网格
			p1.add(sTable);
			scroll = new JScrollPane(sTable);
			this.add(scroll);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "增加") {

			new AddCourse(0);
			this.dispose();
		}
		if (e.getActionCommand() == "删除") {
			this.delete();
		}
		if (e.getActionCommand() == "修改") {
			this.update();
		}
		if (e.getActionCommand() == "查询") {
			cst = new QueryCourse();
			this.dispose();
		}
		if (e.getActionCommand() == "显示") {
			this.dispose();
			new CourseManager("课程信息管理").display();
		}
	}

}


