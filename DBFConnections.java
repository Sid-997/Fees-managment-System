package fpack;
import java.sql.*;

import javax.swing.table.TableModel;
	public class DBFConnections{
		static Connection conn;
	static Connection connects(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("drive ok");
			// String url="jdbc:mysql://localhost:3306/my project";
			String url="jdbc:mysql://127.0.0.1:3306/my project";
			String user ="root";
			String pass="1234";
			conn=DriverManager.getConnection(url,user,pass);
			System.out.println("Connected");
		}
		catch(ClassNotFoundException se){
			se.printStackTrace();
		}
	catch(SQLException se)
	{
	se.printStackTrace();
	}
	return conn;
	}
	public static void main(String ar[])
	{
		connects();
	}
	public static TableModel resultsetToTableModel(ResultSet rs) {
		
		return null;
	}
	}