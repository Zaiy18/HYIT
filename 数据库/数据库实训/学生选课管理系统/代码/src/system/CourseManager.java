package system;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class CourseManager extends JFrame implements ActionListener {
	JPanel p = new JPanel();
	JButton btnAdd = new JButton("增加");
	JButton btnDelete = new JButton("删除");
	JButton btnAlter = new JButton("修改");
	JButton btnDisplay = new JButton("显示");
	JMenuBar mb = new JMenuBar();
	JPanel p1 = new JPanel();;
	JTable sTable;
	JScrollPane scroll;
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	Object[][] playerInfo;
	String mkch = null;
	boolean bstd = false;
	public CourseManager(String title) {
		super(title);
		add("South", p);
		this.add("Center", p1);
		mb.add(btnAdd);
		mb.add(btnDelete);
		mb.add(btnAlter);
		mb.add(btnDisplay);
		this.connDB();
		this.setBounds(200, 200, 400, 260);
		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);
		btnAlter.addActionListener(this);
		btnDisplay.addActionListener(this);
		this.setJMenuBar(mb);
		this.setResizable(false);
		show();
	}
	public void display() {
		int i = 0;
		int j = 0;
		int k = 0;
		List al = new ArrayList();
		try {
			rs = stmt.executeQuery("select * from courses");
			while (rs.next()) {
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
		String[] columnNames = { "课程号", "课程名","任课老师","地点","时间","学分"};

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
		sTable = new JTable(playerInfo, columnNames);
		p1.add(sTable);
		scroll = new JScrollPane(sTable);
		this.add(scroll);
	}
	public void connDB() {
		try {
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:microsoft:sqlserver://localhost:1433; DatabaseName=choosecourse","zq", "258456");
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeDB()
	{
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void delete() {
		String kch = null;
		String kcm = null;
		int row = -1;
		row = sTable.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "请选择！");
		} else {
			if (!bstd) {
				int j1 = 0;
				try {
					rs = stmt.executeQuery("select * from courses");
					while (rs.next() && j1 <= row) {
						kch = rs.getString("cid");
						kcm = rs.getString("cname");
						j1++;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				int i1 = 0;
				try {
					int rs1 = stmt.executeUpdate("delete from courses where cid='"
							+ kch + "'");
					JOptionPane.showMessageDialog(null, "删除成功！");
					this.dispose();
					new CourseManager("课程信息管理").display();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				try {
					int rs1 = stmt.executeUpdate("delete from courses where cid='"
							+ mkch + "'");
					JOptionPane.showMessageDialog(null, "删除成功！");
					this.dispose();
					new CourseManager("课程信息管理").display();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
	public void update() {
		String kch = null;
		String kcm = null;
		int id =0;
		int row = -1;
		row = sTable.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "请选择！");
		} else {
			int j1 = 0;
			try {
				if (!bstd) {
					rs = stmt.executeQuery("select * from courses");
				} else {
					rs = stmt.executeQuery("select * from courses where cid='" + mkch
							+ "'");
				}
				while (rs.next() && j1 <= row) {
					kch = rs.getString("cid");
					kcm = rs.getString("cname");
					id = rs.getInt("id");
					j1++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			AddCourse cadd = new AddCourse(id);
			cadd.setTitle("修改");
			cadd.tcno.setText(kch);
			cadd.tcname.setText(kcm);
			this.dispose();
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
		if (e.getActionCommand() == "显示") {
			this.dispose();
			new CourseManager("课程信息管理").display();
		}
	}
}


