package fpack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewStudent extends JDialog {

	public ViewStudent() {

	}
	JScrollPane jsp;
	{
		setVisible(true);
		setModal(true);
		setTitle("Table View");
		String st = "select * from student";
		try
		{
			Connection con=DBFConnections.connects();
			PreparedStatement ps = con.prepareStatement(st);

			ResultSet rs = ps.executeQuery();
			String columns[] = new String[]{"eid","name","year","email","course","fees","paid","due","address","country"};
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(columns);
			JTable table = new JTable();
			setSize(500, 500);
			setModal(true);
			getContentPane().setLayout(null);
			table.setModel(model);
			table.setFillsViewportHeight(true);
			while(rs.next())
			{
				int id = rs.getInt("eid");
				String name = rs.getString("name");
				String year = rs.getString("year");
				String email = rs.getString("email");
				String course = rs.getString("course");
				double fees= rs.getDouble("fees");
				double paid = rs.getDouble("paid");
				double Due = rs.getDouble("Due");
				String address = rs.getString("address");
				String country = rs.getString("country");
				String contact = rs.getString("contact");
				model.addRow(new Object[]{id,name,year,email,course,fees,paid,Due,address,country,contact});
				jsp = new JScrollPane(table,JScrollPane.
						VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			}	
		} 
		catch (SQLException se) 
		{

			se.printStackTrace();	
		}

		getContentPane().add(jsp);
		setSize(649,377);
		jsp.setBounds(44, 11, 550, 250);
		getContentPane().setLayout(null);
	}

	public static void main(String[] args)
	{
		new ViewStudent();

	}

}
