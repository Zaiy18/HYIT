package com.szp.course;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class AddCourse extends JFrame implements ActionListener{// ���ڿγ���Ϣ���������ӻ��޸�ĳ����¼�Ľ���
	JLabel lcno = new JLabel("�γ̺ţ�");
	JLabel lcname = new JLabel("�γ�����");
	JLabel lcteacher = new JLabel("�ο���ʦ��");
	JLabel lcplace = new JLabel("�ص㣺");
	JLabel lctime = new JLabel("ʱ�䣺");
	JLabel lccredit = new JLabel("ѧ�֣�");
	JTextField tcno = new JTextField(10);
	JTextField tcname = new JTextField(10);
	JTextField tcteacher = new JTextField(10);
	JTextField tcplace = new JTextField(10);
	JTextField tctime = new JTextField(10);
	JTextField tccredit = new JTextField(10);
	JButton btnOK = new JButton("ȷ��");
	JButton btnCancel = new JButton("ȡ��");
	JPanel p = new JPanel();
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	boolean isNewsm = true;// �����ж��Ƿ���ʾ�γ���Ϣ����Ľ���
	int id =0;//ͨ����id�޸Ŀγ���Ϣ

	public AddCourse(int id) {// ���췽��
		this.id=id;
		this.setTitle("����");
		this.setBounds(200, 200, 346, 235);
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		p.add(lcno);
		p.add(tcno);
		p.add(lcname);
		p.add(tcname);
		p.add(lcteacher);
		p.add(tcteacher);
		
		p.add(tcteacher);
		p.add(tcteacher);
		
		p.add(lcplace);
		p.add(tcplace);
		
		p.add(lccredit);
		p.add(tccredit);
		
		p.add(btnOK);
		p.add(btnCancel);
		this.add(p);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnOK.addActionListener(this);
		btnCancel.addActionListener(this);
		this.show();
	}

	public void connDB() { // �������ݿ�
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

	public void closeDB() // �ر�����
	{
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void insertst() { // �����¼
		String kch = null;
		String kcm = null;
        String xxkch=null;
		kch = tcno.getText();
		kcm = tcname.getText();
		//xxkch=tpcno.getText();
	
			if (this.getTitle() == "�޸�") {// ������޸ļ�¼����ɾ��������
				try {
					this.connDB();
					//rs = stmt.executeQuery("select id from courses where ")
					int rs1 = stmt.executeUpdate("UPDATE courses SET cid='"+kch+"',cname='"+kcm+"',cteacher='"+tcteacher.getText().trim()+"',cplace='"+tcplace.getText().trim()+"',ctime='"+tctime.getText().trim()+"',ccredit="+tccredit.getText().trim()+" where id="+id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
			String str = "insert into courses(cid,cname,cteacher,cplace,ctime,ccredit) values('" + kch + "','" + kcm + "','"+tcteacher.getText().trim()+"','"+tcplace.getText().trim()+"','"+tctime.getText().trim()+"',"+tccredit.getText().trim()+")";

			this.connDB();// �������ݿ�
			try {
				stmt.executeUpdate(str);

				JOptionPane.showMessageDialog(null, this.getTitle() + "�ɹ���",
						"��ʾ", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(
								"menu4.gif"));
				this.setVisible(false);
			}

			catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "�γ̺��Ѵ��ڣ�");
				tcno.setText("");
				e.printStackTrace();
			}
			}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "ȷ��") {
			this.insertst();
			if (isNewsm) {
				new CourseManager("�γ���Ϣ����").display();
			}
			isNewsm = true;
		}
		if (e.getActionCommand() == "ȡ��") {
			this.setVisible(false);
			new CourseManager("�γ���Ϣ����").display();
		}

	}

}

