package com.szp.course;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class QueryCourse extends JFrame implements ActionListener {// ���ڿγ���Ϣ�����в�ѯʱ����γ̺ŵĽ���
	JLabel ltitle = new JLabel("�γ̺ţ�");
	JTextField tcno = new JTextField(8);
	JButton btnOK = new JButton("ȷ��");
	JPanel p = new JPanel();
	String kch = null;

	public QueryCourse() { // ���췽��
		p.add(ltitle);
		p.add(tcno);
		p.add(btnOK);
		add(p);
		this.setBounds(300, 280, 200, 160);
		btnOK.addActionListener(this);
		this.setResizable(false);
		this.show();
	}

	public void actionPerformed(ActionEvent e) {
		kch = tcno.getText();// ȡ�õ�ǰ����γ̺ŵ�ֵ
		if (kch.equals("")) {// �ж��Ƿ������˿γ̺�
			JOptionPane.showMessageDialog(null, "�γ̺Ų���Ϊ�գ����������룡");
		} else {
			this.dispose();
			new CourseManager(this, "�γ���Ϣ����").select();
		}

	}
}








