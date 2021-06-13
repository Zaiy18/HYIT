 package com.szp.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.szp.course.CourseManager;
import com.szp.student.*;

class ManagerFrane extends JFrame implements ActionListener {// ����Ա����
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JButton btns = new JButton("ѧ����Ϣ����");
	JButton btnc = new JButton("�γ���Ϣ����");
	JButton btnClose = new JButton("�˳�����ϵͳ");
	//JLabel l = new JLabel("����Ա");

	ManagerFrane() {// ���췽��
		super("ѧ��ѡ��ϵͳ");
		setSize(350, 200);
		add("North", p1);
		add("Center", p2);
		//p1.add(l);
		p2.add(btns);
		p2.add(btnc);
		/*p2.add(btnsc);
		p2.add(btng);
		p2.add(btnu);*/
		p2.add(btnClose);
		btns.addActionListener(this);
		btnc.addActionListener(this);
		/*btnsc.addActionListener(this);
		btng.addActionListener(this);
		btnu.addActionListener(this);*/
		btnClose.addActionListener(this);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		show();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "ѧ����Ϣ����")
			new StudentManager().display();
		if (e.getActionCommand() == "�γ���Ϣ����")
			new CourseManager("�γ���Ϣ����").display();
		if (e.getActionCommand() == "�˳�����ϵͳ") {
			System.exit(0);
		}
	}
}

