package system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class StudentAdd extends JFrame implements ActionListener, ItemListener {
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
	String yx = "计软院";
	boolean isNewsm = true;
	public StudentAdd(String xb, String yx) {
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
		if (yx.trim().equals("计软院")) {
			cbsdept.addItem("计软院");
			cbsdept.addItem("物电院");
			cbsdept.addItem("气科院");
			cbsdept.addItem("数统院");
		}
		if (yx.trim().equals("物电院")) {
			cbsdept.addItem("物电院");
			cbsdept.addItem("计软院");
			cbsdept.addItem("气科院");
			cbsdept.addItem("数统院");
		}
		if (yx.trim().equals("数统院")) {
			cbsdept.addItem("数统院");
			cbsdept.addItem("计软院");
			cbsdept.addItem("物电院");
			cbsdept.addItem("气科院");

		}
		if (yx.trim().equals("气科院")) {
			cbsdept.addItem("气科院");
			cbsdept.addItem("计软院");
			cbsdept.addItem("物电院");
			cbsdept.addItem("数统院");
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
	public void insertst() { 
		String xh = null;
		String xm = null;
		String nl = "0";
		xh = tsno.getText().trim();
		xm = tsname.getText().trim();
		try {
			nl =  tsage.getText().trim();
			if (this.getTitle() == "修改") {
				lsno.setEnabled(false);
				try {
					
					this.connDB();
					int rs1 = stmt.executeUpdate("UPDATE students SET sName='"+xm+"',sSex='"+xb.trim()+"',sDepart='"+yx.trim()+"',sAge='"+nl+"' where sId='"+xh.trim()+"'");
							
					JOptionPane.showMessageDialog(null, this.getTitle() + "成功！",
							"提示", JOptionPane.INFORMATION_MESSAGE);
					this.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "年龄必须是整数！");
			tsage.setText("");
			isNewsm = false;
		}

		if (this.getTitle() == "增加") {
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
	public void itemStateChanged(ItemEvent e) {
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

