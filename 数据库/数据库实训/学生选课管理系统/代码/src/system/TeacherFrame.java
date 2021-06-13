package system;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
class ManagerFrane extends JFrame implements ActionListener {
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JButton btns = new JButton("学生信息");
	JButton btnc = new JButton("课程信息");
	ManagerFrane() {
		super("学生选课系统");
		setSize(350, 200);
		add("North", p1);
		add("Center", p2);
		p2.add(btns);
		p2.add(btnc);
		btns.addActionListener(this);
		btnc.addActionListener(this);
		this.setResizable(false);
		this.setBounds(700, 350, 330, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		show();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "学生信息")
			new StudentManager().display();
		if (e.getActionCommand() == "课程信息")
			new CourseManager("课程信息").display();
	}
}

