package fpack;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JTable;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class view_accountant extends JDialog
{
	public view_accountant() {
	}
	JScrollPane jsp;
	{
		setTitle("Table View");
		String st = "select * from fees";	
		try
		{
			Connection con=DBFConnections.connects();
			PreparedStatement ps = con.prepareStatement(st);

			ResultSet rs = ps.executeQuery();
			String columns[] = new String[]{"eid","name","password","email","address","contact"};
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(columns);
			JTable table = new JTable();
			table.setModel(model);
			
			setSize(500, 500);
			setModal(true);
			getContentPane().setLayout(null);
			table.setModel(model);
			table.setFillsViewportHeight(true);
			while(rs.next())
			{
				int id = rs.getInt("eid");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String contact = rs.getString("contact");
				model.addRow(new Object[]{id,name,password,email,address,contact});
				jsp = new JScrollPane(table,JScrollPane.
						VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

			}
		} catch (SQLException se) 
		{
			
			se.printStackTrace();	
			

		}
		getContentPane().add(jsp);
		setSize(649,377);
		jsp.setBounds(44, 11, 550, 250);
		getContentPane().setLayout(null);
		setVisible(true);
	}
	public static void main(String ar[]){
		new view_accountant();
	}
	}


	
	

