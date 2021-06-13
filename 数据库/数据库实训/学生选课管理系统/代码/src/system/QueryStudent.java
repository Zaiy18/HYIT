package system;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class QueryStudent extends JFrame implements ActionListener {
	JLabel ltitle = null;
	JTextField tsno = new JTextField(8);
	JButton btnOK = new JButton("确定");
	JPanel p = new JPanel();
	String xh = null;

	public QueryStudent(String str) {
		ltitle = new JLabel(str);
		p.add(ltitle);
		p.add(tsno);
		p.add(btnOK);
		add(p);
		this.setBounds(300, 280, 300, 280);
		btnOK.addActionListener(this);
		this.setResizable(false);
		this.show();
	}
	public void actionPerformed(ActionEvent e) {
		xh = tsno.getText();
		if (xh.equals("")) {
			JOptionPane.showMessageDialog(null, "学号不能为空");
		} else {
			this.dispose();
			new StudentManager(this).select();
		}

	}
}

