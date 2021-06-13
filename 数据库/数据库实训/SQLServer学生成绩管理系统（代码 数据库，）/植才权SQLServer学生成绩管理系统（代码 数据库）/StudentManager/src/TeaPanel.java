import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TeaPanel extends JPanel 
{
	JButton b1,b2;
	TeaInfo teainfo;
	StoreScore ss;
	JPanel p1=new JPanel(),
           p2=new JPanel(),
           p3=new JPanel();
    static JPanel pCenter=new JPanel();
	static CardLayout card=new CardLayout();
	TeaPanel(MyFrame f)
	{
		setLayout(new BorderLayout());
		p3.setLayout(new BorderLayout());
		pCenter.setLayout(card);
		teainfo=new TeaInfo(f);
		ss=new StoreScore();
		pCenter.add("������Ϣ",teainfo);
		pCenter.add("¼��ɼ�",ss);
		JLabel label=new JLabel("��ʦ��¼ϵͳ");
		label.setFont(new Font("TimesRoman",Font.BOLD,24));
		p1.add(label);
		
		b1=new JButton("  ��  ��  ��  Ϣ  ");
		b2=new JButton("  ¼  ��  ��  ��  ");
		b1.addActionListener(new   ActionListener(){
			public void actionPerformed(ActionEvent e){
				card.show(pCenter,"������Ϣ");
			}
		});
		b2.addActionListener(new   ActionListener(){
			public void actionPerformed(ActionEvent e){
				ss.updateTable();
				card.show(pCenter,"¼��ɼ�");
			}
		});
		p2.add(b1);
		p2.add(b2);
		
		p3.add(p2,BorderLayout.NORTH);
		p3.add(pCenter,BorderLayout.CENTER);
	    
		add(p1,BorderLayout.NORTH);
		add(p3,BorderLayout.CENTER);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		
	}
}
