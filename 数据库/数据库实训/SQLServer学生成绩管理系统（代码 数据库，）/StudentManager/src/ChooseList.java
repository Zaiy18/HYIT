import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class ChooseList extends JPanel //implements ActionListener
{
	//int count=0;//�Ѿ�ѡ��Ŀγ���
	static int selectedcount=0;
	static MymyTable table;
	static DefaultTableModel dtm=new DefaultTableModel(   
            new Object [] {"�γ̱��","�γ�����","ѧ��","�ον�ʦ","��ʦְ��","�Ͽεص�","�γ̳ɼ�"},0);  
	static String id=Logon.userid;
	ChooseList()
	{
		setLayout(new BorderLayout());
		table=new MymyTable(dtm);
		JScrollPane sp=new JScrollPane(table);
        add(sp);
		
	}
	/*private JTable initTable(JTable table) {   
        DefaultTableModel dtm = new DefaultTableModel(   
            new Object [] {"�γ̱��","�γ�����","ѧ��","�ον�ʦ","��ʦְ��","�Ͽεص�"},0);   
        SqlManager DBm=SqlManager.createInstance();
        DBm.connectDB();
        String sql="exec SelectedCourse'"+Logon.userid+"'";//����ѡ�޿Σ����ѡ������û�дﵽ5ʱ����MyTable.b=true;
        ResultSet rs=DBm.executeQuery(sql);
        try{
        	while(rs.next())
            {
        		dtm.addRow(new Object[] {rs.getString(1),rs.getString(2),
        				rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
            }
        	rs.close();
        }catch(SQLException e){
        	e.printStackTrace();
        }
        DBm.closeDB();
  
        table.setModel(dtm); 
        return table;
	}*/
	public static int getSelectedCount()
	{
		SqlManager DBm=SqlManager.createInstance();
		DBm.connectDB();
		String sql="exec SelectedCourseNum'"+Logon.userid+"'";
		ResultSet rs=DBm.executeQuery(sql);
		try{
			rs.next();
			selectedcount=Integer.parseInt(rs.getString(1).trim());
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		//System.out.println(selectedcount);
		return selectedcount;
	}	
	public static void updateTable()
	{
		SqlManager DBm=SqlManager.createInstance();
        DBm.connectDB();
        String sql="exec SelectedDetail'"+Logon.userid+"'";//����ѡ�޿Σ����ѡ������û�дﵽ5ʱ����MyTable.b=true;
        //System.out.println(sql);
        ResultSet rs=DBm.executeQuery(sql);
        try{
        	DefaultTableModel dtm2=new DefaultTableModel(   
    	            new Object [] {"�γ̱��","�γ�����","ѧ��","�ον�ʦ","��ʦְ��","�Ͽεص�","�γ̳ɼ�"},0);  
        	while(rs.next())
            {
        		dtm2.addRow(new Object[] {rs.getString(1),rs.getString(2),
        				rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});	
            }
        	table.setModel(dtm2);
        	rs.close();
        }catch(SQLException ex){
        	ex.printStackTrace();
        }
        DBm.closeDB();
	}
}
class MymyTable extends JTable
{
	static boolean b=true;	
	MymyTable(DefaultTableModel tdm)
	{
		super(tdm);
	}
	public   boolean   isCellEditable(int   rowIndex,   int   columnIndex){
		return false; 
	}	
}