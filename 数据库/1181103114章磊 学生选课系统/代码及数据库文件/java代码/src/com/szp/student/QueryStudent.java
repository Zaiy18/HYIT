package com.szp.student;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class QueryStudent extends JFrame implements ActionListener {// ����ѧ��������Ϣ�����в�ѯʱ����ѧ�ŵĽ���
	JLabel ltitle = null;
	JTextField tsno = new JTextField(8);//ָ���ı���ĳ��Ⱥ����ݣ�JTextField(String text, int columns) 
	JButton btnOK = new JButton("ȷ��");
	JPanel p = new JPanel();
	String xh = null;

	public QueryStudent(String str) {// ���췽��
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
		xh = tsno.getText();// ȡ�õ�ǰ����ѧ�ŵ�ֵ
		if (xh.equals("")) {// �ж��Ƿ�������ѧ��
			JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ�գ����������룡");
		} else {
			this.dispose();
			new StudentManager(this).select();
		}

	}
}

