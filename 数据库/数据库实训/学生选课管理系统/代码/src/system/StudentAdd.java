package system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class StudentAdd extends JFrame implements ActionListener, ItemListener {
	JLabel lsno = new JLabel("ѧ�ţ�");
	JLabel lsname = new JLabel("������");
	JLabel lssex = new JLabel("�Ա�");
	JLabel lsage = new JLabel("���䣺");
	JLabel lsdept = new JLabel("Ժϵ��");
	JTextField tsno = new JTextField(14);
	JTextField tsname = new JTextField(14);
	JComboBox cbssex = new JComboBox();
	JTextField tsage = new JTextField(14);
	JComboBox cbsdept = new JComboBox();
	JButton btnOK = new JButton("   ȷ     ��     ");
	JButton btnCancel = new JButton("   ȡ     ��     ");
	JPanel p = new JPanel();
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String xb = "��";
	String yx = "����Ժ";
	boolean isNewsm = true;
	public StudentAdd(String xb, String yx) {
		this.xb = xb;
		this.yx = yx;
		this.setTitle("����");
		this.setBounds(200, 200, 230, 280);
		if (xb.trim().equals("��")) {
			cbssex.addItem("��");
			cbssex.addItem("Ů");
		} else {
			cbssex.addItem("Ů");
			cbssex.addItem("��");
		}
		if (yx.trim().equals("����Ժ")) {
			cbsdept.addItem("����Ժ");
			cbsdept.addItem("���Ժ");
			cbsdept.addItem("����Ժ");
			cbsdept.addItem("��ͳԺ");
		}
		if (yx.trim().equals("���Ժ")) {
			cbsdept.addItem("���Ժ");
			cbsdept.addItem("����Ժ");
			cbsdept.addItem("����Ժ");
			cbsdept.addItem("��ͳԺ");
		}
		if (yx.trim().equals("��ͳԺ")) {
			cbsdept.addItem("��ͳԺ");
			cbsdept.addItem("����Ժ");
			cbsdept.addItem("���Ժ");
			cbsdept.addItem("����Ժ");

		}
		if (yx.trim().equals("����Ժ")) {
			cbsdept.addItem("����Ժ");
			cbsdept.addItem("����Ժ");
			cbsdept.addItem("���Ժ");
			cbsdept.addItem("��ͳԺ");
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
			if (this.getTitle() == "�޸�") {
				lsno.setEnabled(false);
				try {
					
					this.connDB();
					int rs1 = stmt.executeUpdate("UPDATE students SET sName='"+xm+"',sSex='"+xb.trim()+"',sDepart='"+yx.trim()+"',sAge='"+nl+"' where sId='"+xh.trim()+"'");
							
					JOptionPane.showMessageDialog(null, this.getTitle() + "�ɹ���",
							"��ʾ", JOptionPane.INFORMATION_MESSAGE);
					this.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "���������������");
			tsage.setText("");
			isNewsm = false;
		}

		if (this.getTitle() == "����") {
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
		if (e.getActionCommand() == "   ȷ     ��     ") {
			this.insertst();
			if (isNewsm) {
				new StudentManager().display();
			}
			isNewsm = true;
		}
		if (e.getActionCommand() == "   ȡ     ��     ") {
			this.setVisible(false);
			new StudentManager().display();
		}

	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			JComboBox jcb = (JComboBox) e.getSource();
			if ((jcb.getSelectedItem() == "��")
					|| (jcb.getSelectedItem() == "Ů")) {
				xb = (String) jcb.getSelectedItem();
			} else {
				yx = (String) jcb.getSelectedItem();
			}
		}
	}
}

