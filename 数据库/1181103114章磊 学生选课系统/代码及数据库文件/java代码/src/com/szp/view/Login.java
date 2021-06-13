package com.szp.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Login extends JFrame implements ActionListener, ItemListener {// ��¼����
	JPanel p1 = null;
	JPanel p2 = null;
	JPanel p3 = null;
	JLabel userName = new JLabel("�û���");
	JTextField txtUser = new JTextField();
	JLabel password = new JLabel("���룺");
	JPasswordField txtPwd = new JPasswordField(6);
	JLabel role = new JLabel("��ɫ��");
	JComboBox cbrole = new JComboBox();
	JButton btnLogin = new JButton("��¼");
	JButton btncz = new JButton("����");
	JButton btnCancel = new JButton("ȡ��");
	JLabel imageLabel;
	Icon image;
	static int OK = 1;
	static int CANCEL = 0;
	int actionCode = 0;
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	int qxian = 0;

	public Login() {// ���췽��
		super("��¼����");
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		cbrole.addItem("��ʦ");
		cbrole.addItem("ѧ��");
		image = new ImageIcon("picture\\st.jpg");
		imageLabel = new JLabel(image);
		p1.add(imageLabel);
		this.setLayout(new FlowLayout());
		this.setBounds(100, 100, 246, 345);
		p2.setLayout(new GridLayout(4, 2));
		p2.add(userName);
		p2.add(txtUser);
		p2.add(password);
		p2.add(txtPwd);
		p2.add(role);
		p2.add(cbrole);
		p3.add(btnLogin);
		p3.add(btncz);
		p3.add(btnCancel);
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.show();
		btnLogin.addActionListener(this);
		cbrole.addItemListener(this);
		btncz.addActionListener(this);
		btnCancel.addActionListener(this);
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

	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			JComboBox jcb = (JComboBox) e.getSource();
			qxian = jcb.getSelectedIndex();
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		String un = null;
		String pw = null;
		String sid=null;
		boolean success = false;// �����ж��Ƿ��¼�ɹ�
		if (source == btnLogin) {
			if (txtUser.getText().equals("") || txtPwd.getText().equals("")) {// �ж��Ƿ��������û���������
				JOptionPane.showMessageDialog(null, "��¼�������벻��Ϊ�գ�");
			} else {
				this.connDB();
			}
			if(cbrole.getSelectedItem().equals("��ʦ")){
				try {
					rs = stmt.executeQuery("select * from teacher where tID='"
							+ txtUser.getText()+"'");
					while (rs.next()) {
						un = rs.getString("tID").trim();
						pw = rs.getString("tPassword").trim();
						if (txtUser.getText().equals(un)) {
							if (txtPwd.getText().equals(pw)) {
								actionCode = OK;
								this.setVisible(false);
								if (qxian == 0) {
									new ManagerFrane();// �������Ա����
								}
								success = true;
								break;
							} else {
								JOptionPane.showMessageDialog(null, "�������");
								txtPwd.setText("");
								success = true;
							}
						}
					}
				
					if (!success) {
						JOptionPane.showMessageDialog(null, "��¼������");
						
						txtPwd.setText("");
					}
	
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			else {
				try {
					rs = stmt.executeQuery("select * from students where sId='"
							+ txtUser.getText()+"'");
					while (rs.next()) {
						un = rs.getString("sName").trim();
						pw = rs.getString("sPassword").trim();
						sid= rs.getString("sId").trim();
						System.out.println(un);
						if (txtUser.getText().equals(sid)) {
							if (txtPwd.getText().equals(pw)) {
								actionCode = OK;
								this.setVisible(false);
								//if (qxian == 0) {
								StudentFrame ss=	new StudentFrame();// �������Ա����
								//}
								ss.setSid(sid);
								ss.create();
								success = true;
								break;
							} else {
								JOptionPane.showMessageDialog(null, "�������");
								txtPwd.setText("");
								success = true;
							}
						}
					}
				
					if (!success) {
						JOptionPane.showMessageDialog(null, "��¼������");
						txtUser.setText("");
						txtPwd.setText("");
					}
	
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		} else if (source == btncz) {
			
			txtPwd.setText("");
		} else if (source == btnCancel) {
			System.exit(0);
		}
		
		
		
		}
	
	
	public static void main(String[] args) {
		 //new SimpleStudentManager("ѡ��");
		///dome.Create();
//		SimpleStudentManager sManager=new SimpleStudentManager();
//		sManager.setSid("201404");
//		sManager.create();
//		new ManagerFrane();
		new Login();
//		WorkforceManagement sa =new WorkforceManagement();
//		sa.create();
	}
}
		
		
	

