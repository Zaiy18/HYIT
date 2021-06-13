package com.szp.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class StudentFrame  extends JFrame implements ActionListener {
	public StudentFrame() {
	}
	JFrame f = new JFrame("学生选课");
	JButton b1 = new JButton("选课");
	JButton b2 = new JButton("删除");
	JButton b3 = new JButton("个人课表");
	JButton b4 = new JButton("所有课程");
	JButton b5 = new JButton("注销");
	
	String[] cloum = { "课程号", "课程名","任课老师","地点","时间","学分"};
	Object[][] row = new Object[50][6];
	JTable table = new JTable(row, cloum);
	JScrollPane scrollpane = new JScrollPane(table);
	JSplitPane splitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	Connection con;
	Statement stmt;
	ResultSet rs;
	boolean flag = false;
	private String sid;
	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	void create() {
		JPanel p = (JPanel) f.getContentPane();
		p.setLayout(new FlowLayout());
		p.add(scrollpane);
		p.add(splitpane);
		JPanel p1 = new JPanel();
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		JPanel p2 = new JPanel();
		p2.setBackground(Color.black);
		p2.add(scrollpane);
		JPanel p3 = new JPanel();
		p.setLayout(new FlowLayout());
		
		splitpane.add(p1, splitpane.TOP);
		splitpane.add(p2, splitpane.BOTTOM);
		splitpane.setDividerLocation(50);
		p.setBackground(Color.black);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		f.setBounds(220, 100, 550, 450);
		f.setResizable(true);// 可以调整界面大小
		f.setVisible(true);
	}

	public void display() {// 显示所有的课程信息
		
		for (int i = 0; i < 50; i++)
			for (int j = 0; j <= 5; j++)
				table.setValueAt("", i, j);

		try {
			this.connDB();
			rs = stmt.executeQuery("select * from courses order by cid");
			int k=-1;
			while (rs.next()) {
				k++;
				String cid = rs.getString("cid");
				 String cname = rs.getString("cname");
				 String cteacher = rs.getString("cteacher");
				String cplace = rs.getString("cplace");
				 String ctime=rs.getString("ctime");
				
				String ccredit = rs.getString("ccredit");
				table.setValueAt(cid, k, 0);
				table.setValueAt(cname, k, 1);
				table.setValueAt(cteacher, k, 3);
				table.setValueAt(cplace, k, 2);
				table.setValueAt(ctime,k,4);
				table.setValueAt(ccredit,k,5);
				System.out.println("我是姓名："+cname);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		flag=false;
	}
	
	
	public void displayChoose() {// 显示已选的课程信息
		
		
		for (int i = 0; i < 50; i++)
			for (int j = 0; j <= 5; j++)
				table.setValueAt("", i, j);
		try {
			this.connDB();
			String sql ="select cid,cname,cteacher,cplace,ctime,ccredit from courses where cid in"
					+ "(select cid from syllabus where sid ='"+sid +"')";
			rs = stmt.executeQuery(sql);
			int k=-1;
			while (rs.next()) {
				k++;
				String cid = rs.getString("cid");
				 String cname = rs.getString("cname");
				 String cteacher = rs.getString("cteacher");
				String cplace = rs.getString("cplace");
				 String ctime=rs.getString("ctime");
				
				String ccredit = rs.getString("ccredit");
				table.setValueAt(cid, k, 0);
				table.setValueAt(cname, k, 1);
				table.setValueAt(cteacher, k, 3);
				table.setValueAt(cplace, k, 2);
				table.setValueAt(ctime,k,4);
				table.setValueAt(ccredit,k,5);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		flag=true;
		
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
		
		int column=0;
		row = table.getSelectedRow();
		String  cid =table.getValueAt(row, column).toString();
		System.out.println("我是选中的行："+cid);
		
		if (row == -1) {// 判断要删除的信息是否被选中
			JOptionPane.showMessageDialog(null, "请选择要删除的记录！");
		} else {
			if (flag) {// 判断选择的是不是查询后的结果
				//没有查询
				int j1 = 0;
				
				int i1 = 0;
				try {
					int rs1 = stmt.executeUpdate("delete from syllabus where sid='"
							+ sid + "' and cid='"+cid+"'");// 删除数据库中当前被选中的记录
					JOptionPane.showMessageDialog(null, "记录删除成功！");
					this.dispose();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
//				
				JOptionPane.showMessageDialog(null, "请选择您课表中的课程");
//				}
			}
		}

	}

	public void chooseCourse() {// 选择一门课
		String kch = null;
		String kcm = null;
		
		int id =0;
		//String xxkch = null;

		int row = -1;
		row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "请选择要选择的课程！");
		} else {
			int j1 = 0;
			try {
				this.connDB();
				
					rs = stmt.executeQuery("select * from courses order by cid");
				
				while (rs.next() && j1 <= row) {// 找出当前被选中的记录在数据库中的对应
					kch = rs.getString("cid");
					kcm = rs.getString("cname");
					id = rs.getInt("id");
					System.out.println("hahahhhhhahha:"+kch);
					//xxkch = rs.getString("pcno");
					j1++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				System.out.println("hahahhhhhahha:"+kch);
				rs=stmt.executeQuery("select * from syllabus where sid='"+sid+"' and cid='"+kch+"'");
				if(rs.next()){
					JOptionPane.showMessageDialog(null, "您已经选择了该课程！");
				}
				else {
					int rs=	stmt.executeUpdate("insert into syllabus(sid,cid) values('"+sid+"','"+kch+"')");
					JOptionPane.showMessageDialog(null, "选课成功！");
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
		}
	}

	

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "选课") {
			this.chooseCourse();
		
		}
		if (e.getActionCommand() == "删除") {
			this.delete();
		}
		
		if (e.getActionCommand() == "所有课程") {
			this.dispose();
			this.display();
		}
		if (e.getActionCommand() == "个人课表") {
			System.out.println("我是个人课表");
			
			//new SimpleStudentManager("学生选课",sid).displayChoose();
		this.displayChoose();
		}
		if (e.getActionCommand() == "注销") {
			f.dispose();
			new Login();
		}
	}

}