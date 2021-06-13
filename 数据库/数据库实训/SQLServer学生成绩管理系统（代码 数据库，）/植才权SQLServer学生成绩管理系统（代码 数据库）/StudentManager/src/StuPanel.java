import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StuPanel extends JPanel implements ActionListener
{
	JButton b1,b2,b3;
	StuInfo stuinfo;
	CourseList courselist;
	ChooseList chooselist;

	JPanel p1=new JPanel(),
           p2=new JPanel(),
           p3=new JPanel();
    static JPanel pCenter=new JPanel();
	static CardLayout card=new CardLayout();
	StuPanel(MyFrame f)
	{
		setLayout(new BorderLayout());
		p3.setLayout(new BorderLayout());
		pCenter.setLayout(card);
		
		JLabel label=new JLabel("ѧ��ѡ��ϵͳ");
		label.setFont(new Font("TimesRoman",Font.BOLD,24));
		p1.add(label);
		
		b1=new JButton("  ��  ��  ��  Ϣ  ");
		b2=new JButton("  ��  ��  ��  ��  ");
		b3=new JButton("  ��  ѡ  ��  ��  ");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		
		stuinfo=new StuInfo(f);
		courselist=new CourseList();
		chooselist=new ChooseList();
		pCenter.add("������Ϣ",stuinfo);
		pCenter.add("�γ��б�",courselist);
		pCenter.add("��ѡ�γ�",chooselist);
		
		p3.add(p2,BorderLayout.NORTH);
		p3.add(pCenter,BorderLayout.CENTER);
	    
		add(p1,BorderLayout.NORTH);
		add(p3,BorderLayout.CENTER);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
			card.show(pCenter, "������Ϣ");
		if(e.getSource()==b2)
			card.show(pCenter, "�γ��б�");
		if(e.getSource()==b3)
		{
			ChooseList.updateTable();
			/*Vector   rec_vector=new   Vector();//�ӽ������ȡ���ݷ�������rec_vector��   
	        rec_vector.addElement(rs.getString(1));   
	        rec_vector.addElement(rs.getString(2));   
	        rec_vector.addElement(rs.getString(3));   
	        rec_vector.addElement(rs.getString(4));   
	        rec_vector.addElement(rs.getString(5));   
	        Vector vector=new Vector();
	        vector.addElement(rec_vector);//����rec_vector��������vect��       
	        ChooseList.dtm.fireTableStructureChanged();//���±����ʾ����vect������ */
			card.show(pCenter, "��ѡ�γ�");
		}			
	}
}
