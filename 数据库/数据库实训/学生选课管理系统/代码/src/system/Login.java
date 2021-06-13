package system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Login extends JFrame implements ActionListener, ItemListener {
	JPanel p1 = null;
	JPanel p2 = null;
	JPanel p3 = null;
	JLabel userName = new JLabel("学号或工号：");
	JTextField txtUser = new JTextField();
	JLabel password = new JLabel("密码：");
	JPasswordField txtPwd = new JPasswordField(6);
	JLabel role = new JLabel("登陆对象：");
	JComboBox cbrole = new JComboBox();
	JButton btnLogin = new JButton("登录");
	Icon image;
	static int OK = 1;
	static int CANCEL = 0;
	int actionCode = 0;
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	int qxian = 0;
	public Login() {
		super("选课系统");
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		cbrole.addItem("教师");
		cbrole.addItem("学生");
		this.setLayout(new FlowLayout());
		this.setBounds(700, 350, 400, 200);
		p2.setLayout(new GridLayout(4, 2));
		p2.add(userName);
		p2.add(txtUser);
		p2.add(password);
		p2.add(txtPwd);
		p2.add(role);
		p2.add(cbrole);
		p3.add(btnLogin);
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.show();
		btnLogin.addActionListener(this);
		cbrole.addItemListener(this);
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
		boolean success = false;
		if (source == btnLogin) {
			if (txtUser.getText().equals("") || txtPwd.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "不能为空！");
			} else {
				this.connDB();
			}
			if(cbrole.getSelectedItem().equals("教师")){
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
									new ManagerFrane();
								}
								success = true;
								break;
							} else {
								JOptionPane.showMessageDialog(null, "密码错误！");
								txtPwd.setText("");
								success = true;
							}
						}
					}
				
					if (!success) {
						JOptionPane.showMessageDialog(null, "登录错误！");
						
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
						if (txtUser.getText().equals(sid)) {
							if (txtPwd.getText().equals(pw)) {
								actionCode = OK;
								this.setVisible(false);
								StudentFrame ss=	new StudentFrame();
								ss.setSid(sid);
								ss.create();
								success = true;
								break;
							} else {
								JOptionPane.showMessageDialog(null, "密码错误！");
								txtPwd.setText("");
								success = true;
							}
						}
					}
					if (!success) {
						JOptionPane.showMessageDialog(null, "登录错误！");
						txtUser.setText("");
						txtPwd.setText("");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} 
	}
	public static void main(String[] args) {
		new Login();
    }
}
		
		
	

