import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class CourseList extends JPanel implements ActionListener
{
	int count=0;//�ɹ�ѡ��Ŀγ���
	MyTable table1;
	JTable table2;
	TableColumnModel tcm;
	JButton button;
	CourseList()
	{
		setLayout(new BorderLayout());
		button=new JButton("ȷ��");
		button.addActionListener(this);
		JPanel p=new JPanel();
		p.add(button);
		table1=new MyTable();
		JTable table2=initTable(table1);
		JScrollPane sp=new JScrollPane(table2);
		add(sp,BorderLayout.CENTER);
		add(p,BorderLayout.SOUTH);
	}
	private JTable initTable(JTable table) {   
        DefaultTableModel dtm = new DefaultTableModel(   
            new Object [] {"","�γ̱��","�γ�����","ѧ��","�ον�ʦ","��ʦְ��","�Ͽεص�","��ѡ����"},0);   
        SqlManager DBm=SqlManager.createInstance();
        DBm.connectDB();
        String sql="exec AllCourse";//����ѡ�޿Σ����ѡ������û�дﵽ5ʱ����MyTable.b=true;
        ResultSet rs=DBm.executeQuery(sql);
        try{
        	while(rs.next())
            {
        		dtm.addRow(new Object[] {new Boolean(false),rs.getString(1),rs.getString(2),
        				rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
        		count++;
            }
        	rs.close();
        }catch(SQLException e){
        	e.printStackTrace();
        }
        DBm.closeDB();
        table.setModel(dtm);   
        TableColumnModel tcm = table.getColumnModel();   
        tcm.getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));   
        tcm.getColumn(0).setCellRenderer(new MyTableRenderer());
        tcm.getColumn(0).setPreferredWidth(20);   
        tcm.getColumn(0).setWidth(20);   
        tcm.getColumn(0).setMaxWidth(20);   
        return table;   
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==button)
		{
			if(selectcourse()>0)
			{
				JOptionPane.showMessageDialog(this,"ѡ�γɹ�\n���\"ȷ��\"�鿴��ѡ�γ�",
						"ѡ�γɹ�",JOptionPane.INFORMATION_MESSAGE);
				ChooseList.updateTable();
				StuPanel.card.show(StuPanel.pCenter, "��ѡ�γ�");
			}
		}
	}
	public int selectcourse()
	{
		int selectedCount=ChooseList.getSelectedCount();
		int a=xianzhi();
		int c=0;
		String[] courseID=new String[selectedCount];
		if(selectedCount==3)
		{
			JOptionPane.showMessageDialog(this,"ѡ����Ŀ���ܳ���3�ţ����Ѿ�ѡ����3��\n���\"ȷ��\"�鿴��ѡ�γ�",
					"����",JOptionPane.WARNING_MESSAGE);
			ChooseList.updateTable();
			StuPanel.card.show(StuPanel.pCenter, "��ѡ�γ�");
			return c ;
		}
		else{
			if(a+selectedCount>3)
			{
				JOptionPane.showMessageDialog(this,"ѡ����Ŀ���ܳ���3�ţ����Ѿ�ѡ����"+selectedCount+"��\n���\"ȷ��\"�鿴��ѡ�γ�",
						"����",JOptionPane.WARNING_MESSAGE);
				ChooseList.updateTable();
				StuPanel.card.show(StuPanel.pCenter, "��ѡ�γ�");
				return c;
			}
			else
			{//����ѡ�ظ���
				String sql="exec SelectedCourse'"+Logon.userid+"'";
				//System.out.println(sql+"����ѡ�ظ���");
				SqlManager DBm=SqlManager.createInstance();
				DBm.connectDB();
				ResultSet rs=DBm.executeQuery(sql);
				try{
					int i=0;
					while(rs.next()){
						courseID[i]=rs.getString(1).trim();
						System.out.println(courseID[i]+"changdu");
					}
					rs.close();
				}catch(SQLException e){
					e.printStackTrace();
					return c;
				}
				DBm.closeDB();
				for(int i=0;i<count;i++)
				{
					for(int j=0;j<selectedCount;j++)
					{
						if(table1.getValueAt(i,0).toString().equals("true"))
						{
							//System.out.println(table1.getValueAt(i,1).toString().trim()+"ѡ�β����ظ�,���");
							//System.out.println(courseID[j]);
							if(table1.getValueAt(i,1).toString().trim().equals(courseID[j])){
								JOptionPane.showMessageDialog(this,"ѡ�β����ظ���\n���\"ȷ��\"�鿴��ѡ�γ�",
										"����",JOptionPane.WARNING_MESSAGE);
								ChooseList.updateTable();
								StuPanel.card.show(StuPanel.pCenter, "��ѡ�γ�");
								return c;
						    }
						}
					}	
				}
				for(int i=0;i<count;i++)
				{
					if(table1.getValueAt(i,0).toString().equals("true"))
					{
						String courseid=table1.getValueAt(i,1).toString();
						sql="exec SelectCourse'"+Logon.userid+"','"+courseid+"'";
						DBm.connectDB();
						c=DBm.executeUpdate(sql);
						DBm.closeDB();
						System.out.println("c1="+c);
					}System.out.println("c2="+c);
				}
				if(c==0)
				{
					JOptionPane.showMessageDialog(this,"��ѡ��ѡ�޿�",
							"����",JOptionPane.WARNING_MESSAGE);
				}
				return c;
			}
		}
	}
	public int xianzhi()
	{
		int a=0;
		for(int i=0;i<count;i++)
		{
			if(table1.getValueAt(i,0).toString().equals("true"))
				a++;
		}
		return a;
	}
}
class MyTable extends JTable
{
	static boolean b=true;	
	public   boolean   isCellEditable(int   rowIndex,   int   columnIndex){
		if (columnIndex>0)return false;   
		else return true;
	}	
}
class MyTableRenderer extends JCheckBox implements TableCellRenderer 
{
    public Component getTableCellRendererComponent( JTable table,   
            Object value,   
            boolean isSelected,   
            boolean hasFocus,   
            int row,   
            int column ) {   
        Boolean b = (Boolean) value;   
        this.setSelected(b.booleanValue());   
        return this;   
    }   
} 
