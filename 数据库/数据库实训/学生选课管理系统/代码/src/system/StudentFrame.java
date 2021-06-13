package system;
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
	JFrame f = new JFrame("学生选课系统");
	JButton b1 = new JButton("选择课程");
	JButton b2 = new JButton("删除课程");
	JButton b3 = new JButton("自己课表");
	JButton b4 = new JButton("所有课程");
	JButton b5 = new JButton("查看成绩");
	String[] cloum = { "课程号", "课程名","地点","任课老师","地点","学分"};
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
		p1.add(b3);
		p1.add(b1);
		p1.add(b2);
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
		f.setResizable(true);
		f.setVisible(true);
	}
	public void display() {
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		flag=false;
	}
	public void displayChoose() {
		for (int i = 0; i < 50; i++)
			for (int j = 0; j <= 5; j++)
				table.setValueAt("", i, j);
		try {
			this.connDB();
			String sql ="select cid,cname,cteacher,cplace,ctime,ccredit from courses where cid in"
					+ "(select cid from stclass where sid ='"+sid +"')";
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
		
		int column=0;
		row = table.getSelectedRow();
		String  cid =table.getValueAt(row, column).toString();
		System.out.println("我是选中的行："+cid);
		
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录！");
		} else {
			if (flag) {
				int j1 = 0;
				
				int i1 = 0;
				try {
					int rs1 = stmt.executeUpdate("delete from stclass where sid='"
							+ sid + "' and cid='"+cid+"'");
					JOptionPane.showMessageDialog(null, "课程删除成功！");
					this.dispose();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "请选择您课表中的课程");
			}
		}
	}
	public void chooseCourse() {
		String kch = null;
		String kcm = null;
		int id =0;
		int row = -1;
		row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "请选择！");
		} else {
			int j1 = 0;
			try {
				this.connDB();
				rs = stmt.executeQuery("select * from courses order by cid");
				
				while (rs.next() && j1 <= row) {
					kch = rs.getString("cid");
					kcm = rs.getString("cname");
					j1++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs=stmt.executeQuery("select * from stclass where sid='"+sid+"' and cid='"+kch+"'");
				if(rs.next()){
					JOptionPane.showMessageDialog(null, "您已经选择了该课程！");
				}
				else {
					int rs=	stmt.executeUpdate("insert into stclass(sid,cid) values('"+sid+"','"+kch+"')");
					JOptionPane.showMessageDialog(null, "选课成功！");
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void grade() {
		Object[][] playerInfo1;
		JTable sTable1;
		JPanel p11 = new JPanel();;
		JScrollPane scroll1;
		int i=-1;
		playerInfo1 = new Object[20][3];
		String[] columnNames1 = { "学号", "课程号", "分数"};
		try {
			this.connDB();
			rs = stmt.executeQuery("select * from stclass where sid ='"+sid+"'");
			while (rs.next()) {
				i++;
				playerInfo1[i][0] = rs.getString("sid");
				playerInfo1[i][1] = rs.getString("cid");
				playerInfo1[i][2] = rs.getString("grades");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			sTable1 = new JTable(playerInfo1, columnNames1);
			p11.add(sTable1);
			scroll1 = new JScrollPane(sTable1);
			this.add(scroll1);
			this.setTitle("成绩单");
			this.setSize(400,200);
			this.setLocation(300,300);
			this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "选择课程") {
			this.chooseCourse();
		}
		if (e.getActionCommand() == "删除课程") {
			this.delete();
		}
		if (e.getActionCommand() == "所有课程") {
			this.dispose();
			this.display();
		}
		if (e.getActionCommand() == "自己课表") {
		    this.displayChoose();
		}
		if (e.getActionCommand()== "查看成绩") {
			this.grade();
		}
	}

}