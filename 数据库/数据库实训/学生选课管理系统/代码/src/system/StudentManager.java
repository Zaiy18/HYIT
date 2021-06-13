package system;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
public class StudentManager extends JFrame implements ActionListener {
	JPanel p = new JPanel();
	JButton btnAdd = new JButton("����");
	JButton btnDelete = new JButton("ɾ��");
	JButton btnAlter = new JButton("�޸�");
	JButton btnSearch = new JButton("��ѯ");
	JButton btnDisplay = new JButton("��ʾ");
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

	public StudentManager() {
		super("ѧ����Ϣ����");
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
		this.setResizable(false);
		show();
	}
	StudentManager(QueryStudent sst) {
		super("ѧ����Ϣ����");
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
		this.setResizable(false);
		show();
	}
	public void display() {
		int i = 0;
		int j = 0;
		int k = 0;
		List al = new ArrayList();
		try {
			rs = stmt.executeQuery("select * from students");
			while (rs.next()) { 
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
		String[] columnNames = { "ѧ��", "����", "����", "�Ա�", "Ժϵ" };

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
		String xh = null;
		String xm = null;
		int nl = 0;
		String xb = null;
		String yx = null;
		int row = -1;
		row = sTable.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "��ѡ��");
		} else {
			if (!bstd) {
				int j1 = 0;
				try {
					rs = stmt.executeQuery("select * from students");
					while (rs.next() && j1 <= row) {
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
							+ xh + "'"); 
					JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
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
					JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
					this.dispose();
					new StudentManager().display();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
	public void update() {
		String xh = null;
		String xm = null;
		int nl = 0;
		String xb = null;
		String yx = null;
		int row = -1;
		row = sTable.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵļ�¼��");
		} else {
			int j1 = 0;
			try {
				if (!bstd) {
					rs = stmt.executeQuery("select * from students");
				} else {
					rs = stmt.executeQuery("select * from students where sId='" + mxh
							+ "'");
				}
				while (rs.next() && j1 <= row) {
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
			sadd.setTitle("�޸�");
			sadd.tsno.setText(xh);
			sadd.tsname.setText(xm);
			sadd.tsage.setText("" + nl);
			this.dispose();
		}
	}
	public void select() {
		int i=-1;
		mxh = sst.xh;
		playerInfo = new Object[50][7];
		String[] columnNames = { "�γ̺�", "�γ���", "�ο���ʦ", "�ص�","ʱ��", "ѧ��"};
		try {
			rs = stmt.executeQuery("select cid,cname,cteacher,cplace,ctime,ccredit from courses where cid in"
					+ "(select cid from stclass where sid ='"+mxh +"')");
			while (rs.next()) {
				i++;
				playerInfo[i][0] = rs.getString("cid");
				playerInfo[i][1] = rs.getString("cname");
				playerInfo[i][2] = rs.getString("cteacher");
				playerInfo[i][3] = rs.getString("cplace");
				playerInfo[i][4] = rs.getString("ctime");
				playerInfo[i][5] = rs.getString("ccredit");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (playerInfo[0][1] == null) {
			this.dispose();
			JOptionPane.showMessageDialog(null, "ѧ�Ų����ڣ�");
			new StudentManager().display();
		} else {
			sTable = new JTable(playerInfo, columnNames);
			p1.add(sTable);
			scroll = new JScrollPane(sTable);
			this.add(scroll);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "����") {
			new StudentAdd("��", "����Ժ");
			this.dispose();
		}
		if (e.getActionCommand() == "ɾ��") {
			this.delete();
		}
		if (e.getActionCommand() == "�޸�") {
			this.update();
		}
		if (e.getActionCommand() == "��ѯ") {
			sst = new QueryStudent("ѧ�ţ�");
			this.dispose();
		}
		if (e.getActionCommand() == "��ʾ") {
			this.dispose();
			new StudentManager().display();
		}
	}

}
